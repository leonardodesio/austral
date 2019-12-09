package com.austral.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "TIN_Interfaces_destino")
public class DatoXML {
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha")
    private Date date;
	
	@Column(name="num_estudio")
	private Integer numeroEstudio;
	
	@Column(name="codigo_padre")
	private String codigoPadre;
	
	@Column(name="codigo_cpt")
	private String codigoCPT;
	
	@Column(name="cantidad")
	private String cantidad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getNumeroEstudio() {
		return numeroEstudio;
	}

	public void setNumeroEstudio(Integer numeroEstudio) {
		this.numeroEstudio = numeroEstudio;
	}

	public String getCodigoPadre() {
		return codigoPadre;
	}

	public void setCodigoPadre(String codigoPadre) {
		this.codigoPadre = codigoPadre;
	}

	public String getCodigoCPT() {
		return codigoCPT;
	}

	public void setCodigoCPT(String codigoCPT) {
		this.codigoCPT = codigoCPT;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	

	
	
}
