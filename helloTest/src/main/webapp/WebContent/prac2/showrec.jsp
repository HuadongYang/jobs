<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showrec.jsp' starting page</title>
    
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
  <h1>显示矩形</h1>
    <%
    	rec.Rectangle rect1=new rec.Rectangle();
    rect1.setHeight(100);
    rect1.setWidth(100);
    rect1.setBgcolor("#996600");
    pageContext.setAttribute("width1", rect1.getWidth());
    pageContext.setAttribute("height1", rect1.getHeight());
    pageContext.setAttribute("bgcolor1", rect1.getBgcolor());
    pageContext.setAttribute("area1", rect1.area());
    rec.Rectangle rect2 = new rec.Rectangle(200, 300, "#FF83FA");
    pageContext.setAttribute("width2", rect2.getWidth());
    pageContext.setAttribute("height2", rect2.getHeight());
    pageContext.setAttribute("bgcolor2", rect2.getBgcolor());
    pageContext.setAttribute("area2", rect2.area());
    %>

块1：面积为${area1}
<div style="width:${width1}px;height:${height1}px;background-color:${bgcolor1}"></div>
块2：面积为${area2}
<div style="width:${width2}px;height:${height2}px;background-color:${bgcolor2}"></div>
</body>
  </body>
</html>
