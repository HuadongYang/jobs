package com.practice.prac7;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckServlet
 */
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Map<String, String> users = new HashMap<String, String>();
	
	
	
	static{
		users.put("admin", "admin");
	}
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		if(isUser(userName, password)) {
			request.setAttribute("content", "欢迎你，"+ userName);
            request.getRequestDispatcher("/WebContent/prac7/check.jsp").forward(request, response);

//			response.sendRedirect("/WebContent/prac7/check.jsp");
		}else {
			request.setAttribute("content", "登录失败");
			request.getRequestDispatcher("/WebContent/prac7/check.jsp").forward(request, response);
//			response.sendRedirect("/WebContent/prac7/check.jsp");
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
