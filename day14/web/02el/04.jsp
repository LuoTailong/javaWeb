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
    <%--request和ServletContext能拿到Path--%>
    path: <%=request.getContextPath()%> <br>
    path: <%=((HttpServletRequest)pageContext.getRequest()).getContextPath()%> <br>

    path: <%=request.getServletContext().getContextPath()%> <br>
    path: <%=((HttpServletRequest)pageContext.getRequest()).getServletContext().getContextPath()%>

    <h3>EL写法</h3>
    path: ${pageContext.request.contextPath} <br>
    path: ${pageContext.request.servletContext.contextPath} <br>
    path: ${pageContext.servletContext.contextPath} <br>
</body>
</html>
