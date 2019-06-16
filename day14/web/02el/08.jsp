<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
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
    <%
        int[] arr = {11,22,33};
        request.setAttribute("arr1",arr);
    %>
        数组对象: ${arr1} <br>
        数组中的元素:
            ${arr1[0]} ${arr1[1]} ${arr1[2]} ${arr1[222]}
    <hr>
    <%
        //后面的泛型String要写，不写报错
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        request.setAttribute("list1", list);
    %>
        集合对象: ${list1} <br>
        集合中的元素:
            ${list1[0]} ${list1[1]} ${list1[2]} ${list1[222]}
    <hr>
    <%
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("张三",23);
        map.put("李四",24);
        map.put("王五",25);

        request.setAttribute("map1",map);

    %>
        集合对象: ${map1} <br>
        集合中的元素: <br>
        &nbsp;&nbsp;&nbsp;&nbsp;张三--${map1.张三}<br>
        &nbsp;&nbsp;&nbsp;&nbsp;李四--${map1.李四}<br>
        &nbsp;&nbsp;&nbsp;&nbsp;王五--${map1.王五}
</body>
</html>
