package com.ipartek.formacion.nidea.controller.backoffice;

import java.io.IOException;
import java.util.ArrayList;

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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaterialesController() {
        super();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Material> materiales = new ArrayList<Material>();
		Alert alert=null;
		try {
			String search = request.getParameter("search");
			System.out.println("Filtro busqueda= "+ search);
			
		MaterialDAO dao = MaterialDAO.getInstance();
 		materiales= dao.getAll();
 		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			request.setAttribute("alert", alert);
			request.setAttribute("materiales", materiales);
			request.getRequestDispatcher("materiales/materiales.jsp").forward(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
