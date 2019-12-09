package com.austral.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.austral.model.DatoXML;
import com.austral.model.ComponentRepository;

@Service
public class ComponentService {
	
	@Autowired
	ComponentRepository repository;
	
	public void guardarNovedad(DatoXML datoXML) {
		
		this.repository.save(datoXML);
		
	}

}
