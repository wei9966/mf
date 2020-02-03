<%--
  Created by IntelliJ IDEA.
  User: WB
  Date: 2020/1/16
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>日记</title>
    <style>
        .t1 tr th,td{
            width: 150px;
            height: 35px;
            text-align: center;
        }
        div{
        }
    </style>
    <script src="js/jquery-1.12.4.js"></script>
</head>
<body>
<script>
    $(function () {
        $(".dd").width($(".t1").width());
        $(".dd").height(40);

    });
</script>
<h1 align="center">日记流水账</h1>
<div class="f" style="position: relative;">
    <div style="position: relative;margin: 0 auto;" class="dd">
        <button style="position: absolute;right: 100px;width: 100px;height:40px;font-weight: bold;background: red;border: none;">收</button>
        <button style="position: absolute;right: 0px;width: 100px;height:40px;font-weight: bold;background: #00ff1a;border: none;">支</button>
    </div>
    <table border="1" align="center" cellspacing="0" cellpadding="0" class="t1">
        <tr>
            <th>日期</th>
            <th>客户名称</th>
            <th>科目</th>
            <th>事件内容</th>
            <th>收</th>
            <th>支</th>
            <th>收支方式</th>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td>5</td>
            <td>6</td>
            <td>7</td>
        </tr>
    </table>
</div>
</body>
</html>
