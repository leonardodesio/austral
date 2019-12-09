package com.austral.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.austral.model.DatoXML;
import com.austral.model.soap.CPTCompuesto;
import com.austral.model.soap.InformarNovedadComboResponse;
import com.austral.model.soap.ObjectFactory;
import com.austral.services.ComponentService;


@Endpoint
public class ComponentEndpoint {
	
	@Autowired
	ComponentService service;
	
	
	private static final String NAMESPACE_URI = "http://austral.com/model/soap";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CPTCompuesto")
    @ResponsePayload
    public InformarNovedadComboResponse getCountry(@RequestPayload CPTCompuesto request) {
    	
    	ObjectFactory factory = new ObjectFactory();
    	InformarNovedadComboResponse response = (InformarNovedadComboResponse) factory.createInformarNovedadComboResponse();
    	
    	try {
    		
    		List<CPTCompuesto.Estudios.Estudio> lista = request.getEstudios().getEstudio();
    		int n = 1;
    		for(CPTCompuesto.Estudios.Estudio estudio : lista ) {
    			
    			DatoXML datoXML = new DatoXML();
    			datoXML.setCodigoPadre(request.getCodigoPadre());
    			datoXML.setNumeroEstudio(n);
    			datoXML.setCantidad(estudio.getCantidad());
    			datoXML.setCodigoCPT(estudio.getCodigoCPT());
    			datoXML.setDate(new Date());
    			
    			this.service.guardarNovedad(datoXML);
    			
    			n=n+1;
    		}
    		
    		
	    	
	    	response.setCodigoRespuesta("0");
	    	response.setEstadoRespuesta("OK");
        	
    	}catch(Exception e) {
    		
    		System.out.println(e);
    		
    	}
    	
    	return response;
    	
    }

}
