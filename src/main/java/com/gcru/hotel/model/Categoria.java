package com.gcru.hotel.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CATEGORIAS")
public class Categoria implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_CATEGORIA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "CANTIDAD_LIMITE")
	private int cantidadLimite;
	
	
	public Categoria(Long idCategoria, String nombre, int cantidadLimite) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.cantidadLimite = cantidadLimite;
	}
	
	public Categoria() {
		
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidadLimite() {
		return cantidadLimite;
	}

	public void setCantidadLimite(int cantidadLimite) {
		this.cantidadLimite = cantidadLimite;
	}

	
	
	
	
	
}
