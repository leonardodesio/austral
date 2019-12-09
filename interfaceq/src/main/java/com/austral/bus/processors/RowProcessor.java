package com.austral.bus.processors;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.austral.bus.Operation;
import com.austral.model.Row;

public class RowProcessor implements Processor {

	
	public void process(Exchange exchange) throws Exception {
    	
    	Map<String, Object> row = exchange.getIn().getBody(Map.class);
    	
        Row r = new Row();
        
        r.setInte_Codigo((Long)row.get("inte_Codigo"));
        r.setInte_Datos((String)row.get("inte_Datos"));
        r.setInte_Estado((String) row.get("inte_Estado"));
        //r.setInte_FechaNovedad(new Date(((Timestamp)row.get("inte_FechaNovedad")).getTime()).toString());
        r.setInte_FechaNovedad(new Date(((Timestamp)row.get("inte_FechaNovedad")).getTime()));
        r.setInte_Interfaz((String) row.get("inte_Interfaz"));
        r.setInte_Observaciones((String) row.get("inte_Observaciones"));
        r.setInte_Proceso((Integer)row.get("inte_Proceso"));
        r.setInte_TipoNovedad((String) row.get("inte_TipoNovedad"));
        
        
        
        exchange.getOut().setBody(r);
		
    	/*Map<String, String> row = exchange.getIn().getBody(Map.class);
    	row.put("inte_FechaNovedad", new Date(((Timestamp)row.get("inte_FechaNovedad")).getTime()).toString());
    	exchange.getOut().setBody(row);*/
        
    }
	
	
}