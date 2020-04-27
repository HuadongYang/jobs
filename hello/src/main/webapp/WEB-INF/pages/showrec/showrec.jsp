<%@ page import="com.practice.service.Rectangle" pageEncoding="utf-8"%>
<html>
<head></head>
<body>
<%
Rectangle rect1=new Rectangle();
rect1.setHeight(100);
rect1.setWidth(100);
rect1.setBgcolor("#996600");
pageContext.setAttribute("width1", rect1.getWidth());
pageContext.setAttribute("height1", rect1.getHeight());
pageContext.setAttribute("bgcolor1", rect1.getBgcolor());
pageContext.setAttribute("area1", rect1.area());

Rectangle rect2 = new Rectangle(200, 300, "#FF83FA");
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

</html>