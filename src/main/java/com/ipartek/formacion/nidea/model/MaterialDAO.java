package com.ipartek.formacion.nidea.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.nidea.controller.backoffice.MaterialesController;
import com.ipartek.formacion.nidea.pojo.Material;

public class MaterialDAO<P> implements Persistible<Material>{

    private static MaterialDAO INSTANCE = null;

    // Private constructor para que nose pueda hacer new y crear N instancias
    private MaterialDAO(){}

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple 
    
    public synchronized static void CreateInstance() {
        if (INSTANCE == null) {
        	INSTANCE= new MaterialDAO();
        }

    }
    
    public static MaterialDAO getInstance() {
        if (INSTANCE == null) {
        	CreateInstance();
        }
        return INSTANCE;
    }
	/**
	 * Recupera todos los materiales de la BBDD ordenados por id descendente
	 * 
	 * @return ArrayList<Material> si no existen registros new ArrayList<Material>()
	 */
	

	@Override
	public ArrayList<Material> getAll() {
		ArrayList<Material> lista = new ArrayList<Material>();
		String sql = "SELECT `id`, `nombre`, `precio` FROM `material` ORDER BY `id` DESC LIMIT 500";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			Material m = null;
			while (rs.next()) {
				m = mapper(rs);
				lista.add(m);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Material getById(int id) {
		
		Material material = null;
		String sql = "SELECT `id`,`nombre`,`precio` FROM `material` where `id`=?;"; //Interrogante: Valor que le pasas
		
		try (Connection con = ConnectionManager.getConnection();PreparedStatement pst=con.prepareStatement(sql);)
		{
			
			pst.setInt(1, id); //Sustituimos el interrogante
			
				try (ResultSet rs=pst.executeQuery()){
				
						if(rs.next()) {//Avanza un paso en el cursor
								
							material=mapper(rs);
					
							}
				
				
				
			} catch (Exception e) {
			
			}
			
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return material;
	}

	@Override
		public boolean save(Material pojo) {
		boolean resul = false;

		
		
		
		if (pojo != null) {
			
		
			if (pojo.getId() == -1) {
				resul = crear(pojo);
			} else {
				resul = modificar(pojo);
			}
		}

		return resul;
	}


	private boolean modificar(Material pojo) {
	

		boolean resul=false;
		String sql = "UPDATE `material` SET `nombre`= ? , `precio`= ? WHERE  `id`= ?;";
	
		try(Connection con = ConnectionManager.getConnection();	PreparedStatement pst = con.prepareStatement(sql);) {


			pst.setString(1, pojo.getNombre().trim());
			pst.setFloat(2, pojo.getPrecio());
			pst.setInt(3, pojo.getId());
			

			int affetedRows = pst.executeUpdate();

			if (affetedRows == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return resul;
	
	
	}

	private boolean crear(Material pojo) {

		boolean resul=false;
		String sql="INSERT INTO `material` (`nombre`, `precio`) VALUES ( ? , ? );";
	
		try(Connection con = ConnectionManager.getConnection();	PreparedStatement pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);) {


			pst.setString(1, pojo.getNombre().trim());
			pst.setFloat(2, pojo.getPrecio());
	
			

			int affetedRows = pst.executeUpdate();

			if (affetedRows == 1)
			{
							 //Recuperar ID generado de forma automatica
							
						try(ResultSet rs=pst.getGeneratedKeys()){
							
							while(rs.next()) {
							pojo.setId(rs.getInt(1));
							resul = true;
												}
						}
			}
	

		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return resul;
	
	}

	@Override
	public boolean delete(int id) {
		boolean resul = false;
		String sql = "DELETE FROM `material` WHERE  `id`= ?;";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, id);
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	@Override
	public Material mapper(ResultSet rs) throws SQLException {
		Material  m=null;
		
		if(rs!=null) {
		m= new Material();
		m= new Material();
		m.setId((rs.getInt("id")));
		m.setNombre(rs.getString("nombre"));
		m.setPrecio(rs.getFloat("precio"));
	
	}	return m;
		}
	

	

}
