package com.gcru.hotel.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HABITACIONES")
public class Habitacion implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_HABITACION")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHabitacion;
	
	@Column(name = "ESTADO_ACTUAL")
	private String estadoActual;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CATEGORIA")
	private Categoria categoria;
	
	
	public Habitacion(Long idHabitacion, String estadoActual, Categoria categoria) {
		super();
		this.idHabitacion = idHabitacion;
		this.estadoActual = estadoActual;
		this.categoria = categoria;
	}
	
	public Habitacion() {
		
	}
	

	public Long getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(Long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public String getEstadoActual() {
		return estadoActual;
	}

	public void setEstadoActual(String estadoActual) {
		this.estadoActual = estadoActual;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
	
}
