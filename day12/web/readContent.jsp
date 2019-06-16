<%@ page import="domain.Product" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/8
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>通过JSP读取域容器中的数据</title>
</head>
<body>
    <%--需求1: 往request域容器中设置一个属性(类型是JDK提供的类型),然后读取--%>
    <%
        request.setAttribute("money", 30000);
    %>
    money属性的值为:<%=request.getAttribute("money")%>
    <hr>
    <%--需求2: 往request域容器中设置一个属性(自定义类型), 然后读取--%>
    <%
        //往域容器中放一个: 商品对象
        Product p = new Product("娃娃", 3000);
        request.setAttribute("product", p);
    %>
    商品的name属性值是: <%=((Product)request.getAttribute("product")).getName()%>
    商品的price属性值是: <%=((Product)request.getAttribute("product")).getPrice()%>
    <hr>

    <h1>EL表达式</h1>
    <h2>简写版</h2>
    商品的name属性值是: ${product.name} <br>
    商品的price属性值是:${product.price}
    <hr>

    <h2>完整版</h2>
    商品的name属性值是: ${requestScope.product.name} <br>
    商品的price属性值是:${requestScope.product.price}
</body>
</html>
