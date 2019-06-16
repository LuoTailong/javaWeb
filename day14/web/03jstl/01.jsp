<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/12
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        /*遍历数组*/
        int[] arr = {11,22,33};
        request.setAttribute("arr1",arr);
    %>
    <c:forEach items="${arr1}" var="i">
        ${i} <br>
    </c:forEach>
    <hr>

    <%
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        request.setAttribute("list1",list);
    %>
    <c:forEach items="${list1}" var="e">
        ${e} <br>
    </c:forEach>

    <hr>
    <%
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("张三",23);
        hm.put("李四",24);
        hm.put("王五",25);
        request.setAttribute("hm1",hm);
    %>
    <c:forEach items="${hm1}" var="entry">
        ${entry.key}--${entry.value} <br>
    </c:forEach>
</body>
</html>
