<%--
  Created by IntelliJ IDEA.
  User: WB
  Date: 2020/2/3
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>测试成功</h1>
    <c:forEach items="${list}" var="account">
        ${account.toString()}
    </c:forEach>
</body>
</html>
