package com.ipartek.formacion.nidea.model;

import java.util.ArrayList;

import com.ipartek.formacion.nidea.pojo.Material;

public interface Persistible<P> {
	
	/**
	 * Lista de una tabla de la base de datos ordenados por id descendente y limitado
	 * @return Coleccion
	 */

	public ArrayList<P> getall();
	
	/**
	 * OBTENEMOS EL DETALLE DE UN REGISTRO
	 * 
	 * @param id identificador
	 * @return Registro si existe,null en caso contrario
	 */
	public P getById(int id);
	
	/**
	 * Guardamos un registro en la base de datos
	 * 
	 *Si el id del Pojo==-1 Creamos
	 *Si el id del Pojo >1 Modificamos
	 *
	 * @param pojo
	 * @returnr
	 */
	public boolean save(P pojo);
	
	/**
	 * Eliminamos un registro por su identificador
	 * @param id
	 * @return
	 */
	
	public boolean delete(int id);

}
