<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showtable.jsp' starting page</title>
    
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
  <h1>每日水果供应</h1>
  <jsp:useBean id="mylist" scope="application" class="rec.WeekAndFruitTable" >
	</jsp:useBean>
	<%
  rec.WeekAndFruitTable table =new rec.WeekAndFruitTable();
  %> 
    <table style="width:100%;border:1px white solid"> 
    <tr bgcolor="#4F81BD"style="color: #fff;">  
    
    	<c:forEach items="${table.getWeek()}" var = "week"  >
    		 
    		  <td style="text-align: center">${week}</td>
    			
    	</c:forEach>
   
       
    </tr>  
    <tr bgcolor="#4F81BD"style="color: #fff;">  
    	<c:forEach items="${table.getFruits()}" var="fruit" >  
       
           <th style="text-align: center">${fruit}</th>  
    	</c:forEach>
    </tr>  
      
</table>
  </body>
</html>
