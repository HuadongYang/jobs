package com.practice.prac5;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Prac5PortalServlet
 */
public class Prac5PortalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Map<String, String> users = new HashMap<String, String>();
	
	static{
		users.put("admin", "admin");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prac5PortalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		if(isUser(userName, password)) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("prac5Welcome");
			requestDispatcher.forward(request, response);
		}else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("prac5Login");
			requestDispatcher.include(request, response);
		}
		
		
	}
	
	private boolean isUser(String userName, String password) {
		if(userName == null || password == null) {
			return false;
		}
		if(password.equals(users.get(userName))) {
			return true;
		}
		return false;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
