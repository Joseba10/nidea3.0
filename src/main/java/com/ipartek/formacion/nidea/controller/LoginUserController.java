package com.ipartek.formacion.nidea.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.pojo.Alert;

/**
 * Servlet implementation class NuevoLoginController
 */
@WebServlet("/login-user")
public class LoginUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String view = "";
	private Alert alert = new Alert();

	private static final String USER = "admin";
	private static final String PASS = "admin";
	private static final int SESSION_EXPIRATION = -1; // 1 min

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	// Map<Integer, String> map = new HashMap<Integer, String>();
	// map.put(1, "joseba");
	// map.put(15, "Ramos");
	// map.put(3, "Pique");
	// map.put(5, "Puyol");
	// map.put(11, "Capdevila");
	// map.put(14, "Xabi Alonso");
	// map.put(16, "Busquets");
	// map.put(8, "Xavi Hernandez");
	// map.put(18, "Pedrito");
	// map.put(6, "Iniesta");
	// map.put(7, "Villa");
	// request.getRequestDispatcher("nuevologin.jsp").forward(request, response);
	// }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		private HashMap<Integer, String> usuarios = null;
		// Recoger parametros

		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");

		// Recoger usuarios_conectados del ServeletContext
		ServletContext ctx = request.getServletContext();

		if (ctx.getAttribute("usuarios_conectados") == null) {
			usuarios = new HashMap<Integer, String>();

		} else {

			usuarios = (HashMap<Integer, String>) ctx.getAttribute("usuarios_conectados");
		}

		// Guardar usuarios en el HashMap
		usuarios.put(id, nombre);
	}
}
