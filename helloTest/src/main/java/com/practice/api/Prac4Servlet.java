package com.practice.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Prac4Servlet
 */
public class Prac4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Map<String, String> users = new HashMap<>();
	
	static{
		users.put("admin", "admin");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prac4Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doget");
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		if (password!= null && password.equals(users.get(name))) {
			HttpSession session=request.getSession(); 
			session.setAttribute("userName",name);
			response.sendRedirect("WebContent/prac4/loginSuccess.html");
		}else {
			response.sendRedirect("WebContent/prac4/LoginFailure.html");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
