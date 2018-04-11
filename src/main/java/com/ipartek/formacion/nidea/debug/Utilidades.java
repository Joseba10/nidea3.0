package com.ipartek.formacion.nidea.debug;

import java.util.Date;

import org.junit.Test;

public class Utilidades {

	public static void main(String[] args) {

		diahoy();

	}

	static Object diahoy() {
		
		Date fecha = new Date();
		System.out.println (fecha);
		return fecha;
	}
	
	
	

}
