<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%@ page language="java" contentType="text/html;iso-8859-1"
	import="java.util.*" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
#log {
	border: 1px #8d8c8c;
}
</style>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.3.2.min.js"></script>
<script type="text/javascript">
        	 var curentEnv = "${curentEnv}"; 
        	 function reset(){
         		document.getElementById("username").value;
        		document.getElementById("password").value= "";
        	
        	}
        	 function submit(){
          		var username = document.getElementById("username").value;
         		var password = document.getElementById("password").value;
          		var isLoginSuccess = "false";
         		$.ajax({
                    url: curentEnv + "/hello/login?username="+username+"&password="+password,
                    type: "post",
                    async:false,
                    success: function (returnValue) {
                    	document.write(returnValue);
                    }
                });
         		
         		
         		
         	}
        </script>


</head>
<body>
	<div id="log">欢迎登陆</div>
	<br />

	<input id="username" type="text" autocomplete="off" placeholder="用户名">

		<br /> <br /> <input id="password" type="password"
		autocomplete="off" placeholder="口令"> <br /> <br />
			<button onclick="reset()">重置</button>

			<button onclick="submit()">提交</button>
</body>

</html>