<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: WB
  Date: 2020/1/16
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <style>
        ul{
            margin: 0 0 0 25px;
            list-style-type: none;
            padding: 0;
            text-align: center;
        }

        .duiZhang>ul{
            float: left;
            width: 200px;
            height: 200px;
            border: 1px solid red;
        }
        ul li{
            margin-left: 50px;
            margin-top: 50px;
        }
        ul li:nth-of-type(1){
            font-size: 30px;
            color: black;
        }
        ul li:nth-of-type(2){
            font-size: 22px;
            color: red;
        }
    </style>
    <script src="js/jquery-1.12.4.js"></script>
    <script src="js/duiZhangJs.js"></script>
    <script>
        $(function () {
            $(".duiZhang>ul").click(function (e) {
                var cName=$(e.target).attr("id");
                if (typeof(cName)=="undefined"){
                    cName=$(e.target).parent().attr("id");
                }
                location.href="duiZhang?type=2&cName="+cName;
            });
        });
    </script>
    <title>对账</title>
</head>
<body>
    <div class="duiZhang">
        <c:forEach items="${list}" var="dz">
            <ul id="${dz.cName}">
                <li>
                ${dz.cName}
                </li>
                <li>
                ${dz.money}
                </li>
            </ul>
        </c:forEach>
    </div>
</body>
</html>
