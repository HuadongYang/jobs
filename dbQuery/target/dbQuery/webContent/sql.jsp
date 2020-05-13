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

                        <li><a href="area_search">案件类型</a></li>
                        <li><a href="area_search">裁判时间</a></li>
                        <li><a href="area_search">法院层级</a></li>
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

<div class="container">
    <div class="row">

        <div class="col-lg-12">
            <label for="form0" class="lable0">关键字搜索</label>
            <form class="form-inline" id="form0" target="form1" action="/content">
                <div class="input-group">
                    <input type="text" class="form-control" name="key">
                    <div class="input-group-btn">
                        <input type="submit" value="搜索"/>
                        <%--<button type="button" class="btn btn-default mybutton0"><span class="glyphicon glyphicon-search"></span></button>--%>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <iframe name="form1" id="form1" style="display:none"></iframe>
    <label for="mydiv1" class="lable1">文书展示</label>
    <div id="mydiv1">
        <div class="row">
            <!-- 文书展示区 -->
            <div class="col-md-6 mydiv0" id="heat">
                <pre id="jsonShow" class="resJson"></pre>
            </div>


        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {

        $("#form1").load(function(){

            var text = $(this).contents().find("body").text();      //获取到的是json的字符串

            var j = $.parseJSON(text);                                         //json字符串转换成json对象

            $("#jsonShow").text(j);

        })

    })
</script>


</body>
</html>
