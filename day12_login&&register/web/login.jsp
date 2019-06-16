<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/10
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form method="post" action="/loginServlet">
        <font color="red">
            <%--<%=request.getAttribute("message") == null?"":request.getAttribute("message") %>--%>
            ${message==null?"":message }
        </font><br>
        用户名: <input type="text" name="username"><br>
        密&nbsp;&nbsp;&nbsp;&nbsp;码: <input type="password" name="password"><br>
        <input type="submit" value="登陆">
    </form>
</body>
</html>
