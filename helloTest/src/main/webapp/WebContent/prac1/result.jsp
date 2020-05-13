<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <% String user = request.getParameter("username");
    	String password = request.getParameter("password");
    	if("zhangsan".equals(user) && "123".equals(password)){
    		pageContext.setAttribute("word", "zhangsan,您好，欢迎登陆网上书店！");
    	} else {
    	pageContext.setAttribute("word", "用户名或口令不正确，请<a href='/Hello/index.jsp'>重新登陆</a>");
    	} 
     %>
     
     <div>${word}</div>
  </body>
</html>
