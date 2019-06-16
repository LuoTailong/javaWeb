<%@ page import="domain.Category" %>
<%@ page import="domain.Product" %><%--
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
    <h3>Java写法</h3>
    <%
        Category c = new Category("c111", "汽车分类");
        Product p = new Product("p666", "G63", 165, c);

        pageContext.setAttribute("product",p,2);
    %>

    商品名字: <%=((Product)pageContext.getAttribute("product",2)).getPname()%>
    商品分类名字: <%=((Product)pageContext.getAttribute("product",2)).getCategory().getCname()%>
    <hr>


    <h3>EL表达式的写法</h3>
    商品的名字: ${requestScope.product.pname} <br>
    商品分类的名字: ${requestScope.product.category.cname} <br>
    <hr>

    <h3>EL表达式的写法</h3>
    商品的名字: ${product.pname} <br>
    商品分类的名字: ${product.category.cname} <br>
</body>
</html>
