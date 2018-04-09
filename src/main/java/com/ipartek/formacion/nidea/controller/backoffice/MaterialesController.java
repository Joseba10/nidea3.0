package com.ipartek.formacion.nidea.controller.backoffice;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.model.MaterialDAO;
import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Material;

/**
 * Servlet implementation class MaterialesController
 */
@WebServlet("/backoffice/materiales")
public class MaterialesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VIEW_INDEX = "materiales/index.jsp";
	private static final String VIEW_FORM = "materiales/form.jsp";
	private RequestDispatcher dispatcher;
	private Alert alert;



	public static final int OP_MOSTRAR_FORMULARIO = 1;
	public static final int OP_BUSQUEDA = 14;
	public static final int OP_ELIMINAR = 13;
	public static final int OP_GUARDAR = 2;

	// PARAMETROS

	// Parametros Comunes
	private String search; // Buscador por Nombre del Material
	private int op; // Operacion a realizar

	// Parametros de Material
	private int id;
	private String nombre;
	private float precio;
	Material material = new Material();
	private MaterialDAO dao;

	@Override
	public void init(ServletConfig config) throws ServletException {

		/**
		 * Se ejecuta una sola vez con la primera ejecucion que se realiza
		 */
		super.init(config);
		dao = MaterialDAO.getInstance();
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
	public MaterialesController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	// Unimos las peticiones doGet y doPost,van a hacer lo mismo
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		alert=null;
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

		ArrayList<Material> materiales = new ArrayList<Material>();

		materiales = dao.getAll();
		request.setAttribute("materiales", materiales);
		dispatcher = request.getRequestDispatcher(VIEW_INDEX);

	}

	private void guardar(HttpServletRequest request) {
		
		Material material = new Material();
		material.setNombre(nombre);
		material.setPrecio(precio);
		material.setId(id);
		
	if(dao.save(material)) {
		
		alert=new Alert("Material Guardado",Alert.TIPO_PRIMARY);
		
		
	}else {
		
		alert=new Alert("Lo sentimos pero no hemos podido guardar el material",Alert.TIPO_WARNING);
	}
	
	

		request.setAttribute("material", material);
		dispatcher = request.getRequestDispatcher(VIEW_FORM);
	}

	private void buscar(HttpServletRequest request) {
		Material material = new Material();
		material.setId(id);
		material.setNombre(nombre);
		material.setPrecio(precio);

		if (dao.save(material)) {

			alert = new Alert("Material guardado", Alert.TIPO_PRIMARY);
		} else {
			alert = new Alert("Lo sentimos pero no hemos podido guardar el material", Alert.TIPO_WARNING);
		}

		request.setAttribute("material", material);
		dispatcher = request.getRequestDispatcher(VIEW_FORM);

	}

	private void eliminar(HttpServletRequest request) {
		if (dao.delete(id)) {
			alert = new Alert("Material Eliminado id " + id, Alert.TIPO_PRIMARY);
		} else {
			alert = new Alert("Error Eliminando, sentimos las molestias ", Alert.TIPO_WARNING);
		}
		listar(request);
		
	}

	private void mostrarFormulario(HttpServletRequest request) {

	
		if (id > -1) {
			// TODO recuperar de la BBDD que es un material que existe
			alert = new Alert("Mostramos Detalle id:" + id + " Nombre:" + nombre + " Precio:" + precio, Alert.TIPO_WARNING);
			material= dao.getById(id);
		
		}

		else {
			alert = new Alert("Nuevo Producto", Alert.TIPO_WARNING);
		}
		request.setAttribute("material", material);
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

		search = (request.getParameter("search") != null) ? request.getParameter("search") : "";

		if (request.getParameter("id") != null) {

			id = Integer.parseInt(request.getParameter("id"));
		}else {
			
			id=-1;
		}

		if (request.getParameter("nombre") != null) {

			nombre = request.getParameter("nombre");
		}else {
			
			nombre="";
		}

		if (request.getParameter("precio") != null) {

			precio = Float.parseFloat(request.getParameter("precio"));
		}else {
			
			precio=0;
		}

	}

}
