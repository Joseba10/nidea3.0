package com.ipartek.formacion.nidea.ejemplos;

public class Utilidades {

	//Limpiar espacios en blanco
	
	/**
	 * Metodo estatico para poder usarse desde la propia clase sin tener que instanciar un objeto.<br>
	 * 
	 * Limpiar los caracteres vacios de una cadena String. <br>
	 * 
	 * Hacemos trim,quita todos los espacios por delante y por detras ejemplo: <br>
	 * 
	 * " hola que haces   "=> "hola que hace"
	 * 
	 * 
	 * En caso de null retorna cadena vacia
	 * @param cadena
	 * @return
	 */
	public static String limpiar_espacios(String cadena) {
		
		cadena.trim();
		return "";
	}
	
	
}
