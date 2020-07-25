package com.spring.crud.modelo.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "producto")
public class Producto implements Serializable{
	private static final long serialVersionUID = 9056268430529929722L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre", length = 100)
	private String nombre;
	
	@Column(name = "descripcion", length = 200)
	private String descripcion;
	
	@Column(name = "precio_compra")
	private double precio_compra;
	
	@Column(name = "precio_venta")
	private double precio_venta;

	@Column(name = "estado")
	private int estado;
}
