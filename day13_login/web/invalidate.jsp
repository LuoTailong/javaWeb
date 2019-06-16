<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/11
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注销</title>
</head>
<body>
    <%
        //清除session
        session.invalidate();
        //请求转发到登陆页面
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    %>
</body>
</html>
