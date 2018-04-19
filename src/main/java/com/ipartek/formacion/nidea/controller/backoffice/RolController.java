package com.ipartek.formacion.nidea.controller.backoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.model.RolDAO;
import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Rol;

/**
 * Servlet implementation class RolController
 */
@WebServlet("/backoffice/rol")
public class RolController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VIEW_INDEX = "roles/index.jsp";
	private static final String VIEW_FORM = "roles/form.jsp";
	private RequestDispatcher dispatcher;
	private Alert alert;

	public static final int OP_MOSTRAR_FORMULARIO = 1;
	public static final int OP_BUSQUEDA = 14;
	public static final int OP_ELIMINAR = 13;
	public static final int OP_GUARDAR = 2;

	// PARAMETROS

	// Parametros Comunes
	private String nombreBuscar; // Buscador por Nombre del Rol
	private int op; // Operacion a realizar

	// Parametros de ROL
	private int id;
	private String nombre;
	Rol rol = new Rol();
	private RolDAO dao;

	@Override
	public void init(ServletConfig config) throws ServletException {

		/**
		 * Se ejecuta una sola vez con la primera ejecucion que se realiza
		 */
		super.init(config);
		dao = RolDAO.getInstance();
	}

	/**
	 * Se destruye cuando se cierra tomcat o servidor de aplicaciones
	 */
	@Override
	public void destroy() {

		super.destroy();
		dao = null;
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Antes de ejecutar DoGet/DoPost");
		super.service(request, response);
		System.out.println("Despues de ejecutar DoGet/DoPost");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RolController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	// Unimos las peticiones doGet y doPost,van a hacer lo mismo
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		alert = null;

		try {

			recogerParametros(request);
			switch (op) {
			case OP_MOSTRAR_FORMULARIO:
				mostrarFormulario(request);
				break;
			case OP_ELIMINAR:
				eliminar(request);
				break;

			case OP_BUSQUEDA:
				buscar(request);
				break;

			case OP_GUARDAR:
				guardar(request);
				break;
			default:
				listar(request);
				break;

			}

		} catch (Exception e) {
			alert = new Alert();
			e.printStackTrace();
		} finally {
			request.setAttribute("alert", alert);

			dispatcher.forward(request, response);
		}
	}

	private void listar(HttpServletRequest request) {

		ArrayList<Rol> rol = new ArrayList<Rol>();

		rol = dao.getAll();
		request.setAttribute("rol", rol);
		dispatcher = request.getRequestDispatcher(VIEW_INDEX);

	}

	private void guardar(HttpServletRequest request) {

		Rol rol = new Rol();

		try {
			rol.setNombre(nombre);
			rol.setId(id);

			if (request.getParameter("nombre") != null) {

				rol.setNombre(nombre);

			}

			if (rol.getNombre() == "") {
				alert = new Alert("Tienes que introducir un nombre", Alert.TIPO_DANGER);

			} else {
				// TODO hacer que el precio no este en blanco y solo acepte numeros

				if (rol.getNombre().length() > 25) {

					alert = new Alert("Maximo 25 palabras", Alert.TIPO_DANGER);
				}

				else {

					if (dao.save(rol)) {

						alert = new Alert("Rol Guardado", Alert.TIPO_PRIMARY);

					} else {

						alert = new Alert("Lo sentimos pero no hemos podido guardar el rol,el rol ya existe",
								Alert.TIPO_WARNING);

					}
				}

			}
		} catch (NumberFormatException e) {

			e.printStackTrace();
			alert = new Alert("No es posible meter un numero");

		} catch (NullPointerException e) {
			e.printStackTrace();
			alert = new Alert("El nombre no puede estar vacio");

		}

		request.setAttribute("rol", rol);
		dispatcher = request.getRequestDispatcher(VIEW_FORM);
	}

	private void buscar(HttpServletRequest request) {
		alert = new Alert("Busqueda para: " + nombreBuscar, Alert.TIPO_PRIMARY);
		ArrayList<Rol> rol = new ArrayList<Rol>();
		rol = dao.search(nombreBuscar);
		request.setAttribute("rol", rol);
		dispatcher = request.getRequestDispatcher(VIEW_INDEX);

	}

	private void eliminar(HttpServletRequest request) {
		if (dao.delete(id)) {
			alert = new Alert("Rol Eliminado id " + id, Alert.TIPO_PRIMARY);
		} else {
			alert = new Alert("Error Eliminando, sentimos las molestias ", Alert.TIPO_WARNING);
		}
		listar(request);
		dispatcher = request.getRequestDispatcher(VIEW_INDEX);
	}

	private void mostrarFormulario(HttpServletRequest request) {

		Rol rol = new Rol();
		if (id > -1) {
			rol = dao.getById(id);

		} else {
			alert = new Alert("Nuevo Rol", Alert.TIPO_WARNING);
		}
		request.setAttribute("rol", rol);
		dispatcher = request.getRequestDispatcher(VIEW_FORM);
	}

	private void recogerParametros(HttpServletRequest request) {

		/**
		 * Recogemos todos los datos enviados
		 */

		if (request.getParameter("op") != null) {
			op = Integer.parseInt(request.getParameter("op"));
		} else {
			op = 0;
		}

		nombreBuscar = (request.getParameter("search") != null) ? request.getParameter("search") : "";

		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		} else {
			id = -1;
		}

		if (request.getParameter("nombre") != null) {
			nombre = request.getParameter("nombre");
		} else {
			nombre = "";
		}

	}

}
