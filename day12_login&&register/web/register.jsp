<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/10
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form method="post" action="/registerServlet">
        用户名:&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="username"><br>
        密码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="password" name="password"><br>
        确认密码: <input type="password" name="repassword"><br>
        昵称:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="nickname"><br>
        <input type="submit" value="注册">
    </form>
</body>
</html>
