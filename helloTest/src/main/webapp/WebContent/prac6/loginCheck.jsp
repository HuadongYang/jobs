<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%@ page import="com.practice.prac6.User" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">

</head>
<body>
<%
	String userName = request.getParameter("username");
	String password = request.getParameter("password");
	
	User user = new User();
	user.setUserName(userName);
	user.setPassword(password);
	
	
	if (user.check()) {
		pageContext.setAttribute("content", userName + " 欢迎你");
	}else {
		pageContext.setAttribute("content", "您的输入有误，请<a href='/WebContent/prac6/login'>重新输入！");
	}
%>

<div>现在是 <% 
out.print((new  java.util.Date()).toLocaleString());
%> </div>
<br/>
<div> ${content}</div>

</body>
</html>