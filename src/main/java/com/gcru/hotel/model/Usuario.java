package com.gcru.hotel.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Long idUsuario;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "DNI")
	private String dni;
	
	@Column(name = "ROL")
	private String rol;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "RESERVAS",
            joinColumns = {
                    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "ID_HABITACION", referencedColumnName = "ID_HABITACION",
                            nullable = false, updatable = false)})
    private List<Habitacion> habitaciones;
	
	public Usuario(Long idUsuario, String nombre, String dni, String rol) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.dni = dni;
		this.rol = rol;
	}
	
	public Usuario() {
		
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	
	
	
}
