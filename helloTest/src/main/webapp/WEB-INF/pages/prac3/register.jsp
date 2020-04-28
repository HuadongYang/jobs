<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%@ page language="java" contentType="text/html;iso-8859-1" import="java.util.*" 
    pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
        .all-box{
            border:1px dashed #000; 
            height:250px;width:350px;
        }
        .all-input{
        	float:left;
        	}
        
    </style>
</head>
<body>
	<div class = "all-box">
	<div class="title" style="text-align: center">用户注册</div>
	<div  class="all-input">
		用户名：<input id="username" class="all-input" type="text" autocomplete="off" placeholder="用户名" >
		<br />
	
		密码：<input id="password" class="all-input" type="password" autocomplete="off" placeholder="密码">
		<br />
		重复密码：<input id="password" class="all-input" type="password" autocomplete="off" placeholder="重复密码">
		<br />	
		
		性别<input name="boy" type="radio" class="all-input" value=""placeholder= "男">
		<input name="girl" type="radio" value=""placeholder= "女">
		<br />
		邮箱：<input id="birthday" type="text" class="all-input" autocomplete="off" placeholder="邮箱">
		<br />
		出生日期：<input id="native" type="text" class="all-input" autocomplete="off" placeholder="出生日期">
		<br />
	
	<button onclick="submit()">提交</button>
	<button onclick="reset()">重置</button>
	</div>
	</div>
</body>
</html>