<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/12
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
    .jsp底层是一个Servlet, 有内置的9大内置对象.
        page(当前页面), request(本次请求), session(本次会话), application(ServletContext类型的体现,当前项目的配置信息)
        response, config(ServletConfig类型的体现, 当前servlet的配置信息)
        out, exception, pageContext(作用：相当于管家, 用来管理其他8大对象)
    --%>

    <%
        Object page1 = pageContext.getPage();
        ServletRequest request1 = pageContext.getRequest();
        HttpSession session1 = pageContext.getSession();
        ServletContext sc = pageContext.getServletContext();

        //怎么证明通过pageContext获取的对象和.jsp内置的request对象是一个呢?
        //一个设置属性, 一个获取属性
        request.setAttribute("money", 50000);
    %>
    我的月薪是：<%=request1.getAttribute("money")%>
</body>
</html>
