<%--
  Created by IntelliJ IDEA.
  User: WB
  Date: 2020/1/16
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{

        }
        div{
        }
        #father{
            background: #c1b3ba;
        }
        .dh{
            margin: 15px 15px 0 15px;
        }
        .dh li{
            font-size: 22px;
            font-family: "Arial", "微软雅黑";
            font-weight: bold;
            display: block;
            width: 50px;
            margin-top: 25px;
            background: #ffe820;
        }
        .dh li a{
            color: black;
            font-size:25px;
            text-decoration: none;
            margin-left: 13px;
        }
    </style>
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="js/jquery-1.12.4.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

<script>
    $(document).ready(function () {
        $("#father").height($(window).height());
        $("#dhd").height($(window).height());
        $("#rBody").width($(window).width()-$("#dhd").width()*2);
        $("#rBody").height($(window).height()-100);
    });
    $(function () {
    })
</script>
<div id="father">
    <div>
        <img src="" alt="">

    </div>
    <div id="dhd" style="width: 100px;margin:0 10px 0 10px;float: left;">
        <ul class="dh">
            <li class="active"><a href="sy.jsp" target="aa">首<br>&nbsp;&nbsp;页</a></li>
            <li><a href="baoJiaSel?type=1&flag=3" target="aa" id="bj">报<br>&nbsp;&nbsp;价</a></li>
            <li><a href="work?type=3" target="aa" id="gd">工<br>&nbsp;&nbsp;单</a></li>
            <li><a href="rjlsz.jsp" target="aa" id="rjlsz">日<br>&nbsp;&nbsp;记<br>&nbsp;&nbsp;流<br>&nbsp;&nbsp;水<br>&nbsp;&nbsp;账</a></li>
            <li><a href="duiZhang?type=1" target="aa" id="dzcx">对<br>&nbsp;&nbsp;账<br>&nbsp;&nbsp;查<br>&nbsp;&nbsp;询</a></li>
        </ul>
    </div>
    <div style="float: left;" id="rBody">
        <iframe frameborder="0" scrolling="yes" style="width: 100%;height: 100%;" id="aa" name="aa">
        </iframe>
    </div>
</div>

</body>
</html>
