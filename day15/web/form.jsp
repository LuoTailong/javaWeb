<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/14
  Time: 8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>案例2: 解决请求和相应的乱码问题</title>
</head>
<body>
    <h3>post方式</h3>
    <form method="post" action="${pageContext.request.contextPath}/demo2Servlet">
        请输入您的大名：<input type="text" name="username"> <br>
        请输入您的小名：<input type="text" name="nickname"> <br>
        <input type="submit" name="点我提交" >
    </form>
    <h3>get方式</h3>
    <form method="get" action="${pageContext.request.contextPath}/demo2Servlet">
        请输入您的大名：<input type="text" name="username"> <br>
        请输入您的小名：<input type="text" name="nickname"> <br>
        <input type="submit" name="点我提交" >
    </form>
</body>
</html>
