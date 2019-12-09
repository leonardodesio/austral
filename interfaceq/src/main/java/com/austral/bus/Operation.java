package com.austral.bus;


import javax.sql.DataSource;
import javax.xml.bind.JAXBContext;

import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.sql.SqlComponent;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.austral.bus.beans.InformarNovedadRequestBuilder;
import com.austral.bus.processors.RowProcessor;
import com.austral.model.Row;
import com.austral.model.soap.CPTCompuesto;
import com.austral.model.soap.novedadcombo.InformarNovedadComboResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class Operation {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(Operation.class.getName());
	
	public static Row row;
	
	public static void main(String[] args) throws Exception {
		
		//App
		ApplicationContext ctx = SpringApplication.run(Operation.class, args);
		
		//MySQL
		DataSource dataSource = (DataSource)ctx.getBean("dataSource");
		
		//Camel
		CamelContext camelContext = new DefaultCamelContext();
		
		//ActiveMQ
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		
		
		RedeliveryPolicy queuePolicy = new RedeliveryPolicy();
		//queuePolicy.setInitialRedeliveryDelay(0);
		//queuePolicy.setRedeliveryDelay(1000);
		//queuePolicy.setUseExponentialBackOff(false);
		queuePolicy.setMaximumRedeliveries(-1);

		RedeliveryPolicy topicPolicy = new RedeliveryPolicy();
		//topicPolicy.setInitialRedeliveryDelay(0);
		//topicPolicy.setRedeliveryDelay(1000);
		//topicPolicy.setUseExponentialBackOff(false);
		topicPolicy.setMaximumRedeliveries(-1);

		// Receive a message with the JMS API
		connectionFactory.getRedeliveryPolicyMap().put(new ActiveMQTopic(">"), topicPolicy);
		connectionFactory.getRedeliveryPolicyMap().put(new ActiveMQQueue(">"), queuePolicy);
		
		connectionFactory.setBrokerURL("tcp://activemq-amq-tcp:61616");
		
	
		ActiveMQComponent amqComponent = new ActiveMQComponent();
		amqComponent.setAcknowledgementModeName("CLIENT_ACKNOWLEDGE");
		//amqComponent.setUserName("amqus");
		//amqComponent.setUserName("amqpw");
		amqComponent.setConnectionFactory(connectionFactory);
		
		
		//ActiveMQ
		camelContext.addComponent("activemq", amqComponent);
		
		//SQL
		camelContext.getComponent("sql", SqlComponent.class).setDataSource(dataSource);
		
		
		camelContext.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				
				
				// XML Data Format
				JaxbDataFormat xmlDataFormat = new JaxbDataFormat();
				JAXBContext con = JAXBContext.newInstance(CPTCompuesto.class);
				xmlDataFormat.setContext(con);
				
				// JSON Data Format
				JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Row.class);
				
				
				
				//Default error handler disabled
			    errorHandler(noErrorHandler());
				
				
				//Camel Route 1
			    from("sql:select * from TIN_Interfaces where inte_Estado='N'")
					.to("sql:update TIN_Interfaces set inte_Estado='P' where inte_Codigo=:#${body[inte_Codigo]}")
					.process(new RowProcessor())
				    .marshal(jsonDataFormat)
				    .log(LoggingLevel.INFO, LOGGER, "Marshal result: ${body}")
					.to("activemq:queue:news?brokerURL=tcp://activemq-amq-tcp:61616");
				
				
				
				//Camel Route 2
				from("activemq:queue:news")
					.delay(10000L)
					.unmarshal(jsonDataFormat)
					.process(new Processor() {
						@Override
						public void process(Exchange exchange) throws Exception {
							Operation.row = exchange.getIn().getBody(Row.class);
						}
					})
					.setBody(simple("${body.inte_Datos}")) //Comienza a utilizar XML interno
					.log(LoggingLevel.INFO, LOGGER, "JSON Unmarshalling result: ${body}")
					.unmarshal(xmlDataFormat)
					.log(LoggingLevel.INFO, LOGGER, "XML Unmarshalling result: ${body}")
					.bean(InformarNovedadRequestBuilder.class)
	    			.setHeader(CxfConstants.OPERATION_NAME, constant("InformarNovedadCombo"))
    			    .setHeader(CxfConstants.OPERATION_NAMESPACE, constant("http://austral.com/model/soap"))
    			    .to("cxf://http://lis:8080/ws"
    			        + "?serviceClass=com.austral.model.soap.novedadcombo.NovedadComboPort"
    			        + "&wsdlURL=/wsdl/NovedadCombo.wsdl")
					.process(new Processor() {
						public void process(Exchange exchange) throws Exception {
							InformarNovedadComboResponse response = exchange.getIn().getBody(InformarNovedadComboResponse.class);
							exchange.getOut().setBody(response.getEstadoRespuesta());
						}
					})
					.log(LoggingLevel.INFO, LOGGER, "LIS Response: ${body}")
						.choice()
							.when().simple("${body} == 'OK'")
								.log(LoggingLevel.INFO, LOGGER, "approved ${body}")
								.process(new Processor() {
									@Override
									public void process(Exchange exchange) throws Exception {
										exchange.getOut().setBody(Operation.row.getInte_Codigo());
									}
								})
								.to("sql:update TIN_Interfaces set inte_Estado='A' where inte_Codigo=:#${body} limit 1")
							.otherwise()
								.log(LoggingLevel.INFO, LOGGER, "refused ${body}")
								.process(new Processor() {
									@Override
									public void process(Exchange exchange) throws Exception {
										exchange.getOut().setBody(Operation.row.getInte_Codigo());
									}
								})
								.to("sql:update TIN_Interfaces set inte_Estado='R' where inte_Codigo=:#${body} limit 1")
				    .end();
				
				
				
				
				
				
			}
		});
		
		
		while(true) {
			try {
				camelContext.start();
				Thread.sleep(10000);
			}catch(Exception e) {}
		}
		
		
		
	}

}
