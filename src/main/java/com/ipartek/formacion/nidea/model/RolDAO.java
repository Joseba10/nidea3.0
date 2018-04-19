package com.ipartek.formacion.nidea.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.nidea.pojo.Rol;

public class RolDAO implements Persistible<Rol> {

	private static RolDAO INSTANCE = null;

	// Private constructor para que nose pueda hacer new y crear N instancias

	private RolDAO() {
	}

	public synchronized static void CreateInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RolDAO();
		}

	}

	public static RolDAO getInstance() {
		if (INSTANCE == null) {
			CreateInstance();
		}
		return INSTANCE;
	}

	@Override
	public ArrayList<Rol> getAll() {

		ArrayList<Rol> lista = new ArrayList<Rol>();
		String sql = "SELECT `id`, `nombre` FROM `rol` ORDER BY `id` DESC LIMIT 500";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			Rol m = null;
			while (rs.next()) {
				m = (Rol) mapper(rs);
				lista.add(m);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Rol getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Rol pojo) {
		boolean resul = false;

		// sanear el nombre

		pojo.setNombre(com.ipartek.formacion.nidea.util.Utilidades.limpiar_espacios(pojo.getNombre()));

		if (pojo != null) {

			if (pojo.getId() == -1) {
				resul = crear(pojo);
			} else {
				resul = modificar(pojo);
			}
		}

		return resul;
	}

	@Override
	public boolean delete(int id) {
		boolean resul = false;
		String sql = "DELETE FROM `rol` WHERE  `id`= ?;";
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
	public Rol mapper(ResultSet rs) throws SQLException {

		// Rol del usuario
		Rol rol = new Rol();
		rol.setId(rs.getInt("rol_id"));
		rol.setNombre(rs.getString("rol_nombre"));

		return rol;
	}

	public ArrayList<Rol> search(String nombreBuscar) {
		ArrayList<Rol> lista = new ArrayList<Rol>();
		String sql = "SELECT `id`, `nombre` FROM `rol` WHERE `nombre` LIKE ?  ORDER BY `id` DESC LIMIT 500;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, "%" + nombreBuscar + "%");
			try (ResultSet rs = pst.executeQuery();) {
				Rol m = null;
				while (rs.next()) {
					m = mapper(rs);
					lista.add(m);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;

	}

	private boolean modificar(Rol pojo) {

		boolean resul = false;
		String sql = "UPDATE `rol` SET `nombre`= ?  WHERE  `id`= ?;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, pojo.getNombre().trim());
			pst.setInt(2, pojo.getId());

			int affetedRows = pst.executeUpdate();

			if (affetedRows == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resul;

	}

	private boolean crear(Rol pojo) {

		boolean resul = false;
		String sql = "INSERT INTO `rol` (`nombre) VALUES (?);";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, pojo.getNombre().trim());

			int affetedRows = pst.executeUpdate();

			if (affetedRows == 1) {

				// Recuperar ID generado de forma automatica

				try (ResultSet rs = pst.getGeneratedKeys()) {

					while (rs.next()) {
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
}
