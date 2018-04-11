package com.ipartek.formacion.nidea.ejemplos;

public final class CirculoColoreado extends Circulo {

	
	private String color;
	
	@Override
	void dibujar() {
	
		super.dibujar();
	}
	
	public CirculoColoreado(){
		super();
		this.color="blanco";
	}
}
