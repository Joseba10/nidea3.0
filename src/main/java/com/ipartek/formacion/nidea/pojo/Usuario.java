package com.ipartek.formacion.nidea.pojo;

public class Usuario {

	private int id;
	private String nombre;
	private Rol rol;

	public Usuario(int id, String nombre, int idroles) {
		super();
		this.id = id;
		this.nombre = nombre;

	}

	public Usuario(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + "]";
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
