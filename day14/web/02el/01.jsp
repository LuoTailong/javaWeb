<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/12
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Java写法</h3>
        username: <%=request.getParameter("username")%> <br>
        city: <%=request.getParameter("city")%>
    <hr>
    <h3>EL表达式写法</h3>
        username: ${param.username} <br>
        city: ${param.city}
</body>
</html>
