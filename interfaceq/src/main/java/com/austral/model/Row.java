package com.austral.model;

import java.io.Serializable;
import java.util.Date;

public class Row implements Serializable {
	
	
	private Long inte_Codigo;
	private Date inte_FechaNovedad;
	private String inte_TipoNovedad;
	private Integer inte_Proceso;
	private String inte_Estado;
	private String inte_Observaciones;
	private String inte_Interfaz;
	private String inte_Datos;

	public Long getInte_Codigo() {
		return inte_Codigo;
	}

	public void setInte_Codigo(Long inte_Codigo) {
		this.inte_Codigo = inte_Codigo;
	}

	public Date getInte_FechaNovedad() {
		return inte_FechaNovedad;
	}

	public void setInte_FechaNovedad(Date inte_FechaNovedad) {
		this.inte_FechaNovedad = inte_FechaNovedad;
	}

	public String getInte_TipoNovedad() {
		return inte_TipoNovedad;
	}

	public void setInte_TipoNovedad(String inte_TipoNovedad) {
		this.inte_TipoNovedad = inte_TipoNovedad;
	}

	public Integer getInte_Proceso() {
		return inte_Proceso;
	}

	public void setInte_Proceso(Integer inte_Proceso) {
		this.inte_Proceso = inte_Proceso;
	}

	public String getInte_Estado() {
		return inte_Estado;
	}

	public void setInte_Estado(String inte_Estado) {
		this.inte_Estado = inte_Estado;
	}

	public String getInte_Observaciones() {
		return inte_Observaciones;
	}

	public void setInte_Observaciones(String inte_Observaciones) {
		this.inte_Observaciones = inte_Observaciones;
	}

	public String getInte_Interfaz() {
		return inte_Interfaz;
	}

	public void setInte_Interfaz(String inte_Interfaz) {
		this.inte_Interfaz = inte_Interfaz;
	}

	public String getInte_Datos() {
		return inte_Datos;
	}

	public void setInte_Datos(String inte_Datos) {
		this.inte_Datos = inte_Datos;
	}
	
	@Override
	public String toString() {
		return this.inte_Datos + ' ' + this.inte_Estado;
	}

}
