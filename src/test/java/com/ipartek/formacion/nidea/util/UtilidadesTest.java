package com.ipartek.formacion.nidea.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilidadesTest {


	@Test
	public void testLimpiarEspacios() {
		
		assertEquals("hola que hace",Utilidades.limpiar_espacios("         hola que hace        "));
		
		assertEquals("",Utilidades.limpiar_espacios(null));
	}
	


}
