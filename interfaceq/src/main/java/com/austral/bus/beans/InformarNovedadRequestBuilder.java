package com.austral.bus.beans;


import com.austral.model.soap.novedadcombo.ObjectFactory;

public class InformarNovedadRequestBuilder {
	
public com.austral.model.soap.novedadcombo.CPTCompuesto informarNovedadRequestRequest(com.austral.model.soap.CPTCompuesto cptCompuesto) {
		
		ObjectFactory factory = new ObjectFactory();
		
		com.austral.model.soap.novedadcombo.CPTCompuesto  cptCompuestoRequest = (com.austral.model.soap.novedadcombo.CPTCompuesto) factory.createCPTCompuesto();
	
		cptCompuestoRequest.setCodigoPadre(String.valueOf(cptCompuesto.getCodigoPadre()));
		
		cptCompuestoRequest.setEstudios(factory.createCPTCompuestoEstudios());
		
		for(com.austral.model.soap.CPTCompuesto.Estudios.Estudio e : cptCompuesto.getEstudios().getEstudio()) {
		
			com.austral.model.soap.novedadcombo.CPTCompuesto.Estudios.Estudio estudio = factory.createCPTCompuestoEstudiosEstudio();
			estudio.setCantidad(e.getCantidad());
			estudio.setCodigoCPT(e.getCodigoCPT());
			
			cptCompuestoRequest.getEstudios().getEstudio().add(estudio);
		
		}
		
		
        return cptCompuestoRequest;
		
	}

}
