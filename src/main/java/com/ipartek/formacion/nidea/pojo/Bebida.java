package com.ipartek.formacion.nidea.pojo;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Bebida {
	
	private int id;
	@NotNull(message="No puede estar vacío")
	@Size(min = 3, max = 45,message="Minimo 3 caracteres y maximo 45")	
	private String nombre;
	
	@DecimalMin("0.1")
	private float precio;
	
	public Bebida() {
		super();
		this.id=-1;
		this.nombre="";
		this.precio=0;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}
	

	@Override
	public String toString() {
		return "Bebida [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

}
