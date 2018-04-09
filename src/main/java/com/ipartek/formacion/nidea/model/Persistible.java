package com.ipartek.formacion.nidea.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.TableRowSorter;

import com.ipartek.formacion.nidea.pojo.Material;

public interface Persistible<P> {
	
	/**
	 * Lista de una tabla de la base de datos ordenados por id descendente y limitado
	 * @return Coleccion
	 */

	public ArrayList<P> getAll();
	
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

	
	/**
	 * Nos Mapea un Resultado de la Base de Datos a un Pojo
	 * @param rs Resulset 1 registro de la Consulta
	 * @return
	 * 1 Pojo con los valores de Resulset o Null si no hay valores
	 * @throws SQLException 
	 */
	
	public P mapper(ResultSet rs) throws SQLException;
}

