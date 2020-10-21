package com.gcru.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categorias")
public class Categoria {

	@Column(name = "idCategoria")
	@Id
	private Long idCategoria;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "cantidadLimite")
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
