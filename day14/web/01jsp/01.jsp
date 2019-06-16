<%@ page import="java.awt.*" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/12
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>脚本表达式</h3>
<%="abc"%> <br>
<%=true%> <br>
<%=10%>

<hr>
<h3>脚本片段</h3>
<%
    for (int i = 1; i < 10; i++) {
        if (i % 2 == 0) {
            //偶数
%>
<font color="red"><%=i%>
</font>
<%
} else {
    //奇数
%>
<font color="blue"><%=i%>
</font>
<%
        }
    }
%>

<hr>
<h3>脚本声明</h3>
<%!
    String name = "郭达";
    int age = 55;

    public int getMax(int a, int b) {
        return a > b ? a : b;
    }
%>
name: <%=name%> <br>
age: <%=age%> <br>
3和5d的最大值为: <%=getMax(3,5)%>
</body>
</html>
