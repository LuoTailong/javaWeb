<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/8
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的第一个JSP页面</title>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
    <div>1</div>
    <hr>
    <h1>脚本表达式</h1>
    <%="abc" %>     <br>
    <%=10 %>        <br>
    <%=false %>
    <hr>
    <h1>脚本片段</h1>
    <%--在控制台上打印1-10数字--%>
    <%
        for (int i = 1; i <= 10; i++){
            System.out.println(i);
        }

    %>
    <%--在页面上,打印1-10之间的所有数字--%>
    <%
        for (int i = 1; i<= 10; i++){
    %>
            <%=i%>
    <%
        }
    %>
    <br>
    <h1>脚本声明</h1>
    <%!
        String name = "fm";
        int age = 31;
        public int getSum(int a, int b){
            return a + b;
        }
        //内部类
        class InnerClass{}
    %>
    name变量的值是: <%=name%>     <br>
    age变量的值是: <%=age%>       <br>
    3 + 5的值是: <%=getSum(3,5)%> <br>
</body>
</html>
