package com.ipartek.formacion.nidea.ejemplos;

public class Circulo extends ObjetoGrafico implements Ordenable{

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	int radio;
	@Override
	void dibujar() {
	
		
	}
	
	public void imprimir() {
		
	}
	
	public Circulo(){
		super();
		
	}

	@Override
	public int getValor() {
	
		return 0;
	}

	
	
	

}
