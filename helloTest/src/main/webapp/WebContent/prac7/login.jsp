<%@ page language="java" contentType="text/html; charset=UTF-8" import = "java.util.*"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
 <body> 
 <%!
 	private static Set<String> sessionSet = new HashSet<String>();
	private static int counter = 0;
 %>
 <%
 	String sessionId = request.getRequestedSessionId();
 	System.out.println("sessionId: " + sessionId);
 	if (!sessionSet.contains(sessionId)) {
 		counter ++;
 		sessionSet.add(sessionId);
	}
 	System.out.println("set : " + sessionSet);
 %>
 
 
<form action="/checkServlet" method="get">
  用户名<input type="text" name="username" /></p>
 密码<input type="password" name="password" /></p>
  <input type="submit" value="Submit" />
  <br/>
  您是第<%=counter%>个访问者
</form>
   </body>
</html>