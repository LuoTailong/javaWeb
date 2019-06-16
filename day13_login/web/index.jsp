<%@ page import="domain.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/11
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆案例</title>
</head>
<body>
<%
    HttpSession hs = request.getSession();
    Cookie cookie = new Cookie("JSESSIONID", hs.getId());
    response.addCookie(cookie);

    User loginUser = (User) hs.getAttribute("loginUser");
    if (loginUser != null) {
%>
    <h3>欢迎, <%=loginUser.getNickname()%></h3>
    <a href="/login/invalidate.jsp">注销</a>
<%
    } else {
%>
    <a href="/login/login.jsp">请先登录, 然后操作</a>
<%
    }
%>
</body>
</html>
