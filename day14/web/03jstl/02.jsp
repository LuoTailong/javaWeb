<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/12
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach begin="1" end="10" var="i" step="1">
        <c:if test="${i%2==0}">
            <font color="red">${i}</font>
        </c:if>
        <c:if test="${i%2!=0}">
            <font color="blue">${i}</font>
        </c:if>
    </c:forEach>
</body>
</html>
