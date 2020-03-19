<%--
  Created by IntelliJ IDEA.
  User: WB
  Date: 2020/1/18
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>吨价设置</title>
    <script src="js/jquery-1.12.4.js"></script>
    <style>
        .dj_tb1 tr th,td{
            text-align: center;
            width: 300px;
            height: 60px;
        }
    </style>
    <script>
        $(function () {
            $("button").click(function (e) {
                var id=$(e.target).attr("id");
                var b=  window.prompt("请输入你要修改的吨价","");
                var a=parseInt(b);
                if (b>0){
                    location.href="dunJia?type=2&id="+id+"&price="+a;
                }else {
                    alert("请输入正确的吨价");
                }
            });
        });
    </script>
</head>
<body>
    <%--<a href="dunJia?type=3"><h1>新增吨价</h1></a>--%>
    <table class="dj_tb1" border="1" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <th>纸型</th>
            <th>吨价</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${dunJia}" var="d">
            <tr>
                <td>${d.ptype}</td>
                <td>${d.price}</td>
                <td>
                    <button id="d${d.id}">修改吨价</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
