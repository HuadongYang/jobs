package com.practice.prac5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Prac5
 */
public class Prac5Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Prac5Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String html = "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" + 
				"<head>\n" + 
				"	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" + 
				"</head>\n" + 
				" <body> \n" + 
				"<form action=\"/prac5Portal\" method=\"get\">\n" + 
				"  用户名 <input type=\"text\" name=\"username\" /></p>\n" + 
				" 密码 <input type=\"password\" name=\"password\" /></p>\n" + 
				"  <input type=\"submit\" value=\"Submit\" />\n" + 
				"</form>\n" + 
				"   </body>\n" + 
				"</html>";
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
