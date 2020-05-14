<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>基于裁判文书网的聚合案例分析平台</title>
    <!-- mycss -->
    <link type="text/css" rel="stylesheet" href="static/mycss.css">
    <!-- Bootstrap core CSS -->
    <link type="text/css" rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css">
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="static/jquery.min.js" type="text/javascript"></script>
    <script src="static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- <script src="static/extend/echarts/dist/echarts.min.js" type="text/javascript"></script> -->

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>


    <!--     <script type="text/javascript" src="static/js/index.js"></script>
     -->
    <style type="text/css">
        pre {
            white-space: pre-wrap;
            word-wrap: break-word;
        }

    </style>

    <script type="text/javascript">
        function changeFrameHeight() {
            var ifm = document.getElementById("iframepage");
            ifm.height = document.documentElement.clientHeight;
        }

        window.onresize = function () {
            changeFrameHeight();
        }
    </script>

</head>
<body>
<!--导航栏-->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">案例聚合分析平台</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/info_plat">Home</a></li>
                <%--                <li><a href="#about">About</a></li>--%>
                <%--                <li><a href="#contact">Contact</a></li>--%>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">分类查询 <span class="caret"></span></a>
                    <ul class="dropdown-menu">

                        <li><a href="case_category.jsp" target="iframe_a">案件类型</a></li>
                        <li><a href="time_category.jsp" target="iframe_a">裁判时间</a></li>
                        <li><a href="level_category.jsp" target="iframe_a">法院层级</a></li>
                        <%--                        <li><a href="#">Something else here</a></li>--%>
                        <%--                        <li role="separator" class="divider"></li>--%>
                        <%--                        <li class="dropdown-header">Nav header</li>--%>
                        <%--                        <li><a href="#">Separated link</a></li>--%>
                        <%--                        <li><a href="#">One more separated link</a></li>--%>
                    </ul>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<iframe src="query.jsp" name="iframe_a" id="iframepage" width="800" onload="changeFrameHeight()" frameborder="0">
</iframe>
</body>
</html>
