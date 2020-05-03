<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.practice.prac6.CalculateBean" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.3.2.min.js">
	
</script>
<script type="text/javascript">
	function cal() {
		<%
		String var1 = request.getParameter("var1");
		String var2 = request.getParameter("var2");
		String operator = request.getParameter("operator");
		CalculateBean cal = new CalculateBean();
		%>
	}
</script>


</head>
<body>

	<h1>计算器的实现</h1>
	<br />
	<form >
		<input id="var1" name="var1" type="text" value="<%=request.getParameter("var1")==null?"":request.getParameter("var1")%>"> 
		
		<select name="operator" 
			id="operator" ">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>
		</select> 
		<input id="var2" name="var2" type="text" value="<%=request.getParameter("var2")==null?"":request.getParameter("var2")%>">
		<button id="calculate" name="calculate" value="=" onclick="cal()">=</button>
		<input id="result" type="text" value="<%=cal.calculate(var1, var2, operator)%>">
</form>
</body>
</html>