package com.ipartek.formacion.nidea.ejemplos;

import java.io.Serializable;
import java.nio.channels.spi.AbstractSelectionKey;

public abstract class ObjetoGrafico implements Imprimible,Cloneable,Serializable{

	private int x;
	private int y;
	
	public void mover(int x ,int y) {
		
		this.x=x;
		this.y=y;
	}

	abstract void dibujar();

	@Override
	public void imprimible() {
	
		
	}
	
}
