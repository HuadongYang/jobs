<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%@ page language="java" contentType="text/html;iso-8859-1"
	import="java.util.*" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
.all-box {
	border: 1px dashed #000;
	height: 250px;
	width: 350px;
}

.all-input {
	float: left;
}
</style>
<script type="text/javascript">
		function isValidate(){
			var user = document.getElementById("user").value; 
			var password = document.getElementById("password").value; 
			var repassword = document.getElementById("repassword").value; 
			var email = document.getElementById("email").value; 
			var birthday = document.getElementById("birthday").value; 

			isNull(user,"用户名");
			isNull(password,"密码");
			isNull(repassword,"重置密码");
			ispassword(password,repassword);
			isNull(email,"邮箱");
			isEmail(email);
			isNull(birthday,"生日");
			isDate(birthday);
			isNumber(birthday);
			}	
function isNull(value,name){
	if(value.length==0)
		 alert("请输入"+name);
}
function ispassword(password,repassword){
	if(repassword != password)
		alert("密码必须一致！");
	}
function isEmail(email){
  if (!email.value == "") {
          var reg ="/^/w+([-+.]/w+)*@/w+([-.]/w+)*/./w+([-.]/w+)*$/";
            var bool = reg.test(email.value);
           if (bool == false) {
             alert("邮箱格式错误，请重新输入！");
       }
   }    
}
function isDate(date){
alert("date日期不正确！");
}
function isNumber(value){
    var r = value.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
    if(r==null)
		alert("日期不正确！");
}		

	</script>
</head>
<body>

		<div>
			<table width="900px" height="500px" align="center" cellpadding="0px"
				cellspacing="0px">
		
				<tr>
					<td colspan="2">
						<h1 align="center">用户注册</h1>&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td>用户名：</td>
					<td><input id="user" type="text" name="user" size="35px" /></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input id="password" type="password" name="password" size="35px" /></td>
				</tr>
				<tr>
					<td>重复密码：</td>
					<td><input id="repassword" type="password" name="repassword" size="35px" /></td>
				</tr>

				<tr>
					<td>性别：</td>
					<td><input  type="radio" name="sex" value="男" />男
					 	<input  type="radio" name="sex" value="女" />女</td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td><input id="email" type="text" name="email" size="35px" /></td>
				</tr>
				<tr>
					<td>出生日期：</td>
					<td><input id="birthday" type="text" name="birthday" size="35px" /></td>
				</tr>
				<tr>
					<td>籍贯：</td>
					<td><select id="province" name="province" lay-filter="province">
							<option value="北京">北京市</option>
							<option value="青海省">青海省</option>
							<option value="浙江省">浙江省</option>
							<option value="天津市">天津市</option>
							<option value="安徽省">安徽省</option>
							<option value="上海市">上海市</option>
							<option value="福建省">福建省</option>
							<option value="重庆市">重庆市</option>
							<option value="江西省">江西省</option>
							<option value="山东省">山东省</option>
							<option value="河南省">河南省</option>
							<option value="湖北省">湖北省</option>
							<option value="湖南省">湖南省</option>
							<option value="广东省">广东省</option>
							<option value="海南省">海南省</option>
							<option value="山西省">山西省</option>
							<option value="江苏省">江苏省</option>
							<option value="辽宁省">辽宁省</option>
							<option value="吉林省">吉林省</option>
							<option value="台湾省">台湾省</option>
							<option value="河北省">河北省</option>
							<option value="贵州省">贵州省</option>
							<option value="四川省">四川省</option>
							<option value="云南省">云南省</option>
							<option value="陕西省">陕西省</option>
							<option value="甘肃省">甘肃省</option>
							<option value="黑龙江省">黑龙江省</option>
							<option value="香港特别行政区">香港特别行政区</option>
							<option value="澳门特别行政区">澳门特别行政区</option>
							<option value="广西壮族自治区">广西壮族自治区</option>
							<option value="宁夏回族自治区">宁夏回族自治区</option>
							<option value="新疆维吾尔自治区">新疆维吾尔自治区</option>
							<option value="内蒙古自治区">内蒙古自治区</option>
							<option value="西藏自治区">西藏自治区</option>
					</select></td>
				</tr>
				<tr>
					<td></td>
					<td>
					<input type="submit" value="提交" onclick="isValidate()"/> 
					<input type="reset" value="重置" /></td>
				</tr>
			
			</table>
		</div>
</body>
</html>