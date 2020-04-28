<%@ page language="java" contentType="text/html;iso-8859-1" import="java.util.*" 
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

</head>
<body>

	每日水果供应 

<table style="width:100%;border:1px white solid"> 
    <tr bgcolor="#4F81BD"style="color: #fff;">  
    
    	<c:forEach items="${week}" var = "day" >
    		 
    		  <td style="text-align: center">${day}</td>
    			
    	</c:forEach>
       
    </tr>  
    <tr bgcolor="#4F81BD"style="color: #fff;">  
    	<c:forEach items="${fruit}" var="row">  
       
           <th style="text-align: center">${row}</th>  
    	</c:forEach>
    </tr>  
      
</table>
</body>
</html>