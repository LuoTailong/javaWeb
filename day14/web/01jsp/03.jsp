<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/12
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    buffer="0kb"
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        out.print("out输出1 <br>");
        //先打印response原因：有缓冲区默认8kb,满了之后发送给response
        //解决：设置buffer="0kb"
        response.getWriter().println("response输出1 <br>");
    %>
</body>
</html>
