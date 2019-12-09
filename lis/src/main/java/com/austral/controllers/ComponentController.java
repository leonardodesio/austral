package com.austral.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.austral.model.CPTCompuesto;
import com.austral.model.CPTCompuestoResponse;

/**
 * 
 * 
 * {"CodigoPadre":1,"Estudios":[{"CodigoCPT":"80051HAA","Cantidad":1},
 * {"CodigoCPT":"80051HBB","Cantidad":5},
 * {"CodigoCPT":"99051HAA","Cantidad":2}]}
 * 
 * @author leonardodesio
 *
 */
@RestController
public class ComponentController {
	

	@RequestMapping(value = "/news/update", method = RequestMethod.POST)
	public CPTCompuestoResponse cambiarEstadoProcesando(@RequestBody CPTCompuesto compuesto) {
		
		CPTCompuestoResponse response = new CPTCompuestoResponse();
		response.setResult("OK");
		
		return response;
		
    }
	
	

}
