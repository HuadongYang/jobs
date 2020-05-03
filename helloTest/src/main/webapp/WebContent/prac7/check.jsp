<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>prac7s</title>

<script type="text/javascript"> 
function countDown(secs,surl){ 
 //alert(surl); 
 var jumpTo = document.getElementById('jumpTo');
 jumpTo.innerHTML=secs; 
 if(--secs>0){ 
  setTimeout("countDown("+secs+",'"+surl+"')",1000); 
 }
 else
 {  
  location.href=surl; 
 } 
} 
</script>
</head>
<body>
<span id="jumpTo">5</span>秒钟后跳转至登录界面！
<br/>
<%= request.getAttribute("content") %>

<script type="text/javascript">
countDown(5,'/WebContent/prac7/login.jsp');
</script> 
</body>
</html>