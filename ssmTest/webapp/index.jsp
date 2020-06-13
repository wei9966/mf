<%--
  Created by IntelliJ IDEA.
  User: WB
  Date: 2020/2/3
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="account/findAll">测试查询</a>

    <form method="post" action="account/save">
        姓名:<input type="text" name="name"> <br/>
        金额:<input type="text" name="money"><br/>
        <button type="submit">保存</button>
    </form>
</body>
</html>
