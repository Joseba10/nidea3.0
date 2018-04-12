package com.ipartek.formacion.nidea.util;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.nidea.ejemplos.Ordenable;

public class Utilidades {

	// Limpiar espacios en blanco

	/**
	 * Metodo estatico para poder usarse desde la propia clase sin tener que
	 * instanciar un objeto.<br>
	 * 
	 * Limpiar los caracteres vacios de una cadena String. <br>
	 * 
	 * Hacemos trim,quita todos los espacios por delante y por detras ejemplo: <br>
	 * 
	 * " hola que haces "=> "hola que hace"
	 * 
	 * 
	 * En caso de null retorna cadena vacia
	 * 
	 * @param cadena
	 * @return
	 */
	public static String limpiar_espacios(String cadena) {

		String resul = "";

		if (cadena != null) {

			resul = cadena.trim();
			resul = resul.replaceAll(" ", " ");
		}

		return resul;
	}

	/**
	 * Ordenar con una coleccion con el algoritmo buble sort,ordena de menor a mayor
	 * basandose en el metodo getValor en la interfaz ordenable
	 * 
	 * @see com.ipartek.formacion.nidea.ejemplos.Ordenable
	 * @param coleccion
	 *            List<Ordenable> coleccion con los elementos a ordenar
	 * @return en caso de null retornamos una lista vacia
	 */
	public static List<Ordenable> bubbleSort(List<Ordenable> coleccion) {
		List<Ordenable> resul = new ArrayList<Ordenable>();

		if (coleccion != null) {

			resul = coleccion;
			int n = coleccion.size();
			Ordenable temp;

			for (int i = 0; i < n; i++) {
				for (int j = 1; j < (n - i); j++) {
					if (coleccion.get(j - 1).getValor() > coleccion.get(j).getValor()) {
						temp = coleccion.get(j - 1);
						coleccion.remove(j - 1);
						coleccion.add(j, temp);
					}
				}
			}

			System.out.println(coleccion);
			resul = coleccion;
		}

		return resul;
	}
}
