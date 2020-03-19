<%--
  Created by IntelliJ IDEA.
  User: WB
  Date: 2020/2/4
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        #father{
            text-align: center;
        }
        .t1 tr th,td{
            font-size: 22px;
            width: 120px;
            height: 25px;
        }
    </style>
    <title>个人对账页面</title>
</head>
<body>
<div id="father" >
<h1>${cName}的所有工单</h1>
<table border="1" align="center" class="t1" cellspacing="0" cellpadding="5">
    <tr>
        <th>编号</th>
        <th>日期</th>
        <th>客户名称</th>
        <th>产品名称</th>
        <th>封面纸张</th>
        <th>内芯纸张</th>
        <th>成品数量</th>
        <th>成品尺寸</th>
        <th>印刷颜色</th>
        <th>加工要求</th>
        <th>总价</th>
        <th>备注</th>
    </tr>
    <c:forEach items="${work.list}" var="w">
        <tr>
            <td>${w.w_id}</td>
            <td>${w.w_kDate}</td>
            <td>${w.w_cName}</td>
            <td>${w.w_pName}</td>
            <td>${w.w_fmKs}${w.w_fmPage}</td>
            <td>${w.w_nxKs}${w.w_nxPage}</td>
            <td>${w.w_count}</td>
            <td>${w.w_pSize}</td>
            <td>${w.w_fmYellow}</td>
            <td>${w.w_hjg}</td>
            <td>${w.w_result}</td>
            <td>${w.w_other}</td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
