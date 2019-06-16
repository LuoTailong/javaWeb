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
        pageContext.setAttribute("city","北京1",PageContext.PAGE_SCOPE);
        pageContext.setAttribute("city","北京2",PageContext.REQUEST_SCOPE);
        pageContext.setAttribute("city","北京3",PageContext.SESSION_SCOPE);
        pageContext.setAttribute("city","北京4",PageContext.APPLICATION_SCOPE);
    %>

        <%=pageContext.getAttribute("city",1)%> <br>
        <%=pageContext.getAttribute("city",2)%> <br>
        <%=pageContext.getAttribute("city",3)%> <br>
        <%=pageContext.getAttribute("city",4)%>
    <hr>

    <h3>EL表达式</h3>
        ${pageScope.city} <br>
        ${requestScope.city} <br>
        ${sessionScope.city} <br>
        ${applicationScope.city}
</body>
</html>
