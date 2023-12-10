package com.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vuelos")
public class Vuelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_vuelo")
	private Integer idVuelo;
	private String compania;
	private Date fecha;
	private Double precio;
	@Column(name="plazas_disponibles")
	private Integer plazasDisponibles;
	
	public Vuelo() {
		super();
	}

	public Vuelo(Integer idVuelo, String compania, Date fecha, Double precio, Integer plazasDisponibles) {
		super();
		this.idVuelo = idVuelo;
		this.compania = compania;
		this.fecha = fecha;
		this.precio = precio;
		this.plazasDisponibles = plazasDisponibles;
	}

	public Integer getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(Integer idVuelo) {
		this.idVuelo = idVuelo;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getPlazasDisponibles() {
		return plazasDisponibles;
	}

	public void setPlazaDisponibles(Integer plazasDisponibles) {
		this.plazasDisponibles = plazasDisponibles;
	}
	
	

}
