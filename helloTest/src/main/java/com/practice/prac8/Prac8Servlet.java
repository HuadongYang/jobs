package com.practice.prac8;

import java.io.IOException;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Prac8Servlet
 */
public class Prac8Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String url = "jdbc:mysql://127.0.0.1/user?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";  
    public static final String name = "com.mysql.cj.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "root";  
    public static final String sql = "select * from user";  
	private static Map<String, String> users = new HashMap<String, String>();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prac8Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) {
		// TODO Auto-generated method stub
		try {
			Class.forName(name);//指定连接类型  
			Connection conn = DriverManager.getConnection(url, user, password);//获取连接  
			PreparedStatement pst = conn.prepareStatement(sql);//准备执行语句
			ResultSet re = pst.executeQuery();
			while(re.next()) {
				users.put(re.getString("name"), re.getString("password"));
			}
			System.out.println("users: " + users);
		}catch(Exception e) {
			e.printStackTrace();
		}
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String[]> parameterMap = request.getParameterMap();
		
		String userName = parameterMap.get("username")[0];
		String password = parameterMap.get("password")[0];
		if(isUser(userName, password)) {
			request.setAttribute("content", "��ӭ�㣬"+ userName);
            request.getRequestDispatcher("/WebContent/prac8/check.jsp").forward(request, response);

//			response.sendRedirect("/WebContent/prac7/check.jsp");
		}else {
			request.setAttribute("content", "��¼ʧ��");
			request.getRequestDispatcher("/WebContent/prac8/check.jsp").forward(request, response);
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


}
