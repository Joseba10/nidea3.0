package com.ipartek.formacion.nidea.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
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

	private HashMap<Integer, String> usuarios = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		usuarios = new HashMap<Integer, String>();
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
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// recoger parametros
			int id = Integer.parseInt(request.getParameter("id"));
			String nombre = request.getParameter("usuario");

			// recoger usuarios_conectados del ServletContext
			ServletContext ctx = request.getServletContext();

			if (ctx.getAttribute("usuarios_conectados") == null) {
				usuarios = new HashMap<Integer, String>();
			} else {
				usuarios = (HashMap<Integer, String>) ctx.getAttribute("usuarios_conectados");
			}

			// guardar usuario en hashmap
			usuarios.put(id, nombre);

			// guardar hasmap en contexto Servlets
			ctx.setAttribute("usuarios_conectados", usuarios);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			request.getRequestDispatcher("frontoffice/index.jsp").forward(request, response);
		}

	}

}