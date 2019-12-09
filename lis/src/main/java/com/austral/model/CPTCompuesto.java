package com.austral.model;

import java.util.ArrayList;


public class CPTCompuesto {
	
	private Long CodigoPadre;
	private ArrayList<Estudio> estudio;
	
	
	
	public Long getCodigoPadre() {
		return CodigoPadre;
	}
	public void setCodigoPadre(Long codigoPadre) {
		CodigoPadre = codigoPadre;
	}
	public ArrayList<Estudio> getEstudio() {
		return estudio;
	}
	public void setEstudio(ArrayList<Estudio> estudio) {
		this.estudio = estudio;
	}
	
	
	
	
	
	
}
