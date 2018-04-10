package com.ipartek.formacion.nidea.ejemplos;

public abstract class Vehiculo {

	private int puertas;
	private String color;
	
	//Constructor
	public Vehiculo() {
		super(); //java.lang.Objetc
		this.puertas=3;
		this.color="blanco";
	System.out.println("Vehiculo Nuevo Instanciado");
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "vehiculo [puertas=" + puertas + ", color=" + color + "]";
	}
	public abstract void arrancar();
	

	public void encenderLuces() {
		System.out.println("Luces Encendidas");
	}
}
