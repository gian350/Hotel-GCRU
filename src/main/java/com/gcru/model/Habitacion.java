package com.gcru.model;

import javax.persistence.*;

@Entity
@Table(name = "Habitaciones")
public class Habitacion {
	
	@Column(name = "idHabitacion")
	@Id
	private Long idHabitacion;
	
	@Column(name = "estadoActual")
	private String estadoActual;
	
	
	public Habitacion(Long idHabitacion, String estadoActual) {
		super();
		this.idHabitacion = idHabitacion;
		this.estadoActual = estadoActual;
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
	
	
}
