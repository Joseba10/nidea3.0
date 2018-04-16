package com.ipartek.formacion.nidea.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.nidea.pojo.Usuario;

public class UsuarioDAO<P> implements Persistible<P> {

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
	public ArrayList<P> getAll() {
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
		return (ArrayList<P>) lista;
	}

	@Override
	public P getById(int id) {
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

		return (P) usuario;
	}

	@Override
	public boolean save(P pojo) {
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
	public P mapper(ResultSet rs) throws SQLException {
		Usuario m = null;

		if (rs != null) {
			m = new Usuario();
			m.setId((rs.getInt("id")));
			m.setNombre(rs.getString("nombre"));
			// m.setPrecio(rs.getFloat("precio"));

		}
		return (P) m;
	}

}
