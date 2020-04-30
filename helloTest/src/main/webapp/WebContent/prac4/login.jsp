<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">


<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
        #log{
            border: 1px #8d8c8c;
       
        }
        
    </style>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.3.2.min.js"></script>
        <script charset="gbk" type="text/javascript">
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
                    url: "/prac4?username="+username+"&password="+password,
                    type: "get",
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

			<br />
			<br />

             <input id="password" type="password" autocomplete="off" placeholder="口令">

			<br />
			<br />
			<button onclick="reset()">重置</button>
			
			<button onclick="submit()">提交</button>
         

</body>

     </html>