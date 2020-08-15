package com.spring.crud.modelo.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor implements Serializable{
    private static final long serialVersionUID = 4886396317757079949L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre", length = 100)
	private String nombre;
	
	@Column(name = "nit", length = 100)
	private String nit;
	
	@Column(name = "direccion", length = 100)
	private String direccion;
	
	@Column(name = "telefono", length = 100)
	private String telefono;
	
	@Column(name = "estado")
	private int estado;
	
	public Proveedor() {
		super();
	}

	public Proveedor(Long id, String nombre, String nit, String direccion, String telefono, int estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nit = nit;
		this.direccion = direccion;
		this.telefono = telefono;
		this.estado = estado;
	}

	public Proveedor(String nombre, String nit, String direccion, String telefono, int estado) {
		super();
		this.nombre = nombre;
		this.nit = nit;
		this.direccion = direccion;
		this.telefono = telefono;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
    }
    
    public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
    }

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
}