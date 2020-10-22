package com.gcru.hotel.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@ManyToMany(mappedBy = "habitaciones", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Usuario> usuarios;
	
	
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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
	
}
