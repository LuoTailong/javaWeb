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
        Accept:<%=request.getHeader("Accept")%> <br>
        User-Agent: <%=request.getHeader("User-Agent")%>
    <hr>

    <h3>EL表达式</h3>
    Accept: ${header["Accept"]} <br>
    User-Agent: ${header["User-Agent"]}
    <hr>

    <%--EL优化版 只针纯字母组成的属性名有效--%>
    Accept:${header.Accept} <br>
    User-Agent: ${header.User-Agent}

</body>
</html>
