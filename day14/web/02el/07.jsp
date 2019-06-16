<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/12
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>需求: 将a和b保存到page域中, 使用el计算a+b</h1>
    <%
        pageContext.setAttribute("a",10,1);
        pageContext.setAttribute("b",20,1);
        pageContext.setAttribute("c",30,1);
    %>

    a+b=${a+b}
    <h1>将abc保存到page域中,使用el计算a+b+c</h1>
    a+b+c = ${a+b+c}

    <h1>使用el表达式 判断集合是否为空</h1>
    <%
        ArrayList<String> list = new ArrayList<String>();//JDK 1.7新特性 菱形泛型
        list.add("a");
        request.setAttribute("list1",list);
    %>
        empty list: ${empty list1} <br>
        not empty list: ${not empty list1}
    <h1>需求2：使用el表达式 判断用户是否存在</h1>
    <%
//        User user = new User("zhangsan",23);
        User user = null;
        request.setAttribute("user1",user);
    %>
        empty user1: ${empty user1} <br>
        not empty user1: ${not empty user1}

</body>
</html>
