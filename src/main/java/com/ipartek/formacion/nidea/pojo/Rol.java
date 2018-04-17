package com.ipartek.formacion.nidea.pojo;

public class Rol {

	private String nombre;
	private int id;

	public String getNombre() {
		return nombre;
	}

	public Rol(String nombre, int id) {
		super();
		this.nombre = nombre;
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Rol [nombre=" + nombre + ", id=" + id + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
