package com.ipartek.formacion.nidea.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.nidea.pojo.Rol;
import com.ipartek.formacion.nidea.pojo.Usuario;

public class UsuarioDAO implements Persistible<Usuario> {

	private static UsuarioDAO INSTANCE = null;

	// Private constructor para que nose pueda hacer new y crear N instancias
	private UsuarioDAO() {
	}

	// creador sincronizado para protegerse de posibles problemas multi-hilo
	// otra prueba para evitar instanciación múltiple

	public synchronized static void CreateInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}

	}

	public static UsuarioDAO getInstance() {
		if (INSTANCE == null) {
			CreateInstance();
		}
		return INSTANCE;
	}

	/**
	 * Buscamos un usuario por nombre y password
	 * 
	 * @param nombre
	 *            String nombre del Usuario
	 * 
	 * @param password
	 *            String password del Usuario
	 * 
	 * @return Usuario si existe,null si no lo encuentra
	 * @throws SQLException
	 */

	public Usuario check(String nombre, String pass) throws SQLException {

		Usuario resul = null;
		String sql = "SELECT u.id as 'usuario_id', u.nombre as 'usuario_nombre', u.password, r.id as 'rol_id', r.nombre as 'rol_nombre' "
				+ "FROM usuario as u, rol as r " + "WHERE u.id_rol = r.id AND u.nombre=? and u.password = ?;";
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, nombre);
			pst.setString(2, pass);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					resul = mapper(rs);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	public ArrayList<Usuario> search(String nombreBuscar) {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		String sql = "SELECT `id`, `nombre`, `precio` FROM `material`,'usuario' WHERE `nombre` LIKE ?  ORDER BY `id` DESC LIMIT 500;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, "%" + nombreBuscar + "%");
			try (ResultSet rs = pst.executeQuery();) {
				Usuario m = null;
				while (rs.next()) {
					m = (Usuario) mapper(rs);
					lista.add(m);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;

	}

	@Override
	public ArrayList<Usuario> getAll() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		String sql = "SELECT `id`, `nombre`, `precio` FROM `material`,`usuario` ORDER BY `id` DESC LIMIT 500";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			Usuario m = null;
			while (rs.next()) {
				m = (Usuario) mapper(rs);
				lista.add(m);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ArrayList<Usuario>) lista;
	}

	@Override
	public Usuario getById(int id) {
		Usuario usuario = null;
		String sql = "SELECT `id`,`nombre`,`precio` FROM `material`,`usuario` where `id`=?;"; // Interrogante: Valor que
																								// le pasas

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setInt(1, id); // Sustituimos el interrogante

			try (ResultSet rs = pst.executeQuery()) {

				if (rs.next()) {// Avanza un paso en el cursor

					usuario = (Usuario) mapper(rs);

				}

			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;
	}

	@Override
	public boolean save(Usuario pojo) {
		boolean resul = false;

		// sanear el nombre

		((Usuario) pojo)
				.setNombre(com.ipartek.formacion.nidea.util.Utilidades.limpiar_espacios(((Usuario) pojo).getNombre()));

		if (pojo != null) {

			if (((Usuario) pojo).getId() == -1) {
				// resul = crear(pojo);
			} else {
				// resul = modificar(pojo);
			}
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
	public Usuario mapper(ResultSet rs) throws SQLException {
		Usuario u = new Usuario();
		u.setId(rs.getInt("usuario_id"));
		u.setNombre(rs.getString("usuario_nombre"));
		u.setPass(rs.getString("password"));

		// Rol del usuario
		Rol rol = new Rol();
		rol.setId(rs.getInt("rol_id"));
		rol.setNombre(rs.getString("rol_nombre"));
		u.setRol(rol);

		return u;
	}

}
