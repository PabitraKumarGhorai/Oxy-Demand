package net.oxy_demand.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.oxy_demand.registration.dao.Servicesdao;
import net.oxy_demand.registration.model.Services;

/**
 * Servlet implementation class Services_servlets
 */
@WebServlet("/register")
public class Services_servlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Servicesdao servicesdao = new Servicesdao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Services_servlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/servicesjsp.jsp");
		dispatcher.forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullname=request.getParameter("fullname");
		String add1=request.getParameter("add1");
		String add2=request.getParameter("add2");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		String adhar=request.getParameter("adhar");
		String mobile=request.getParameter("mobile");
		
		Services services = new Services();
		services.setFullname(fullname);
		services.setAdd1(add1);
		services.setAdd2(add2);
		services.setState(state);
		services.setCity(city);
		services.setAdhar(adhar);
		services.setMobile(mobile);
		
		try {
			servicesdao.registration(services);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/servicesdetails.jsp");
		dispatcher.forward(request, response);
		
		 
	}

}
