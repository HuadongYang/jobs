<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>案件类型</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

    <script type="text/javascript">

        function queryContent(){
            $.ajax({
                url: "/content/level/category",
                type: "get",
                async: false,
                success: function (returnValue) {
                    console.log(returnValue);
                    showData(returnValue);
                }
            });
        }


        function showData(map) {
            var conlist = '<ul class="list-box">';
            for (var table in map) {
                conlist += '<li>' + table + '</li>';

                var contents = map[table];
                for (var i = 0; i < contents.length; i++) {
                    var content = contents[i];
                    conlist += '<pre id="jsonShow" class="resJson">'+content+'</pre>';
                }
            }
            conlist += '</ul>';
            $('.list-wrap').html(conlist);
        }
    </script>

</head>
<body onload="queryContent()">
<div class="container" style="padding-top:70px">
<div class="list-wrap">

</div>
</div>

</body>
</html>
