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
    <%
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                out.print(cookie.getName()+"--"+cookie.getValue());
            }
        }
    %>
    <hr>

    <h3>EL表达式写法</h3>
    Cookie对象: ${cookie.JSESSIONID} <br>
    cookie的键: ${cookie.JSESSIONID.name} <br>
    cookie的值: ${cookie.JSESSIONID.value}
</body>
</html>
