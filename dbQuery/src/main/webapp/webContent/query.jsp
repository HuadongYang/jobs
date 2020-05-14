<%--
  Created by IntelliJ IDEA.
  User: yanghd
  Date: 2020/5/14
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>



    <style type="text/css">
        pre {
            white-space: pre-wrap;
            word-wrap: break-word;
        }

    </style>
</head>
<body>

<div class="container" style="padding-top:70px">
    <div class="row">

        <div class="col-lg-12">
            <label for="form0" class="lable0">关键字搜索</label>
            <form class="form-inline" id="form0" target="form1" action="/content">
                <div class="input-group">
                    <input type="text" class="form-control" name="key">
                    <div class="input-group-btn">
                        <input type="submit" class="btn btn-primary" value="搜索"/>
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
                <div class="list-wrap">

                </div>

<%--                <pre id="jsonShow" class="resJson"></pre>--%>
            </div>


        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {

        $("#form1").load(function(){

            var text = $(this).contents().find("body").text();      //获取到的是json的字符串

            var contents = $.parseJSON(text);                                         //json字符串转换成json对象

            var conlist = '';
            for (var i = 0; i < contents.length; i++) {
                var content = contents[i];
                conlist += '<pre id="jsonShow" class="resJson">'+content+'</pre>';
            }
            $('.list-wrap').html(conlist);
            /*$("#jsonShow").text(j);*/

        })

    })
</script>


</body>
</html>
