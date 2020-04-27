<%@ page language="java" contentType="text/html;iso-8859-1" import="java.util.*" 
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

</head>
<body>

<table style="width:100%;border:1px white solid">  
    <tr bgcolor="#4F81BD"style="color: #fff;">  
        <th style="text-align: center">星期一</th>  
        <th style="text-align: center">星期二</th>  
    </tr>  
    <c:forEach items="${list}" var="row"varStatus="status">  
        <tr bgcolor="${status.index%2 == 0?'#D0D8E8':'#E9EDF4'}">  
            <td align="center">${status.current.key}</td>  
            <td align="center">${row.value}</td>  
        </tr>  
    </c:forEach>  
</table>
</body>
</html>