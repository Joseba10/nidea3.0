package com.ipartek.formacion.nidea.ejemplos;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilidadesTest {

	
	String cadena="   hola que hace      ";

	@Test
	public void testLimpiarEspacios() {
		
		assertEquals("hola que hace",Utilidades.limpiar_espacios(cadena));
		
		assertEquals("",Utilidades.limpiar_espacios(null));
	}
	
	public void LimpiarEspacios() {
		
		
		cadena.trim();
		System.out.println(cadena);
	}

}
