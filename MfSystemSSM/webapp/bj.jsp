<%--
  Created by IntelliJ IDEA.
  User: WB
  Date: 2020/1/16
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="js/jquery-1.12.4.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bjCss.css">
    <script src="js/bjJs.js"></script>
    <title>报价</title>
    <style>
        a{
            float: left;
            display: block;
            margin-top: 25px;
            margin-left: 25px;
            text-decoration: none;
        }
         .tb1{
             font-size: 22px;
         }
        .tb1 tr th,td{
            width: 150px;
            height: 35px;
            text-align: center;
        }
        .tb1 tr:hover{
            background-color: orange;
        }
        #pageQieHuan{
            margin: 0 auto;
            height: 35px;
            text-align: center;
        }

    </style>
    <script>
        $(document).ready(function () {
            $("#dh").width($(window).width());
            $("#dh").height(80);
        });
    </script>
</head>
<body>
<div id="dh">
<a href="hcbj.jsp" target="aa">
    <h2>画册</h2>
</a>
<a href="scbj.jsp" target="aa">
    <h2>书刊</h2>
</a>
<a href="csdy.jsp" target="aa">
    <h2>彩色单页</h2>
</a>
<a href="hb.jsp" target="aa">
    <h2>黑白单页</h2>
</a>
<a href="wt.jsp" target="aa">
    <h2>无碳复写</h2>
</a>
    <a href="dunJia?type=1" target="aa">
        <h2>吨价设置</h2>
    </a>
</div>
<div style="text-align: center">
        <h1 align="center">全部报价记录</h1>
        <div class="btn-group" style="margin: 0 auto;">
            <a href="baoJiaSel?type=1&flag=1"><button type="button" class="btn btn-info">未生产工单查询</button></a>
            <a href="baoJiaSel?type=1&flag=2"><button type="button" class="btn btn-info">已生产工单查询</button></a>
        </div>
    <table border="1" align="center" class="tb1" style="position: relative;">
        <tr>
            <th>编号</th>
            <th id="date">日期

            </th>
            <th id="cName">客户名称
                <div id="jCName" style="position: absolute;" hidden>
                    <ul></ul>
                </div>
            </th>
            <th id="pName">产品名称
                <div id="jPName" style="position: absolute;" hidden>
                    <ul></ul>
                </div>
            </th>
            <th id="count">成品数量</th>
            <th id="resultMoney">总金额</th>
            <th id="v" value="${flag}">其他操作</th>
        </tr>
        <c:forEach items="${page.list}" var="ll">
            <tr>
                <td>${ll.id}</td>
                <td>${ll.date}</td>
                <td>${ll.cName}</td>
                <td>${ll.pName}</td>
                <td>${ll.count}</td>
                <td>${ll.resultMoney}</td>
                <td><button id="h${ll.id}f${ll.flag}">查询</button></td>
            </tr>
        </c:forEach>
    </table>
    <script>
        $(function () {
           $(".tb1 button").click(function (e) {
            var id=  $(e.target).attr("id");
            location.href="baoJiaSel?id="+id+"&type=2";
           });
        });
    </script>
    <div id="pageQieHuan">
        <ul class="pagination">
            <li>
                <a href="baoJiaSel?pageNum=${page.pageNumber-1}&type=1&flag=${flag}" <c:if test="${page.pageNumber==1}">onclick="javascript:return false;" </c:if> >上一页</a>
            </li>
            <li>
                <a href="baoJiaSel?pageNum=${page.pageNumber+1}&type=1&flag=${flag}" <c:if test="${page.pageNumber>=page.total}">onclick="javascript:return false;"</c:if> > 下一页</a>
            </li>
        </ul>
    </div>
    <script>
        $(document).ready(function () {
           $("#pageQieHuan").width($(".tb1").width());
        });
    </script>
</div>
</body>
</html>
