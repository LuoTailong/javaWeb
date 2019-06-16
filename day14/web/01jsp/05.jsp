<%@ page import="domain.Category" %>
<%@ page import="domain.Product" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/12
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("city", "北京1", PageContext.PAGE_SCOPE);
    pageContext.setAttribute("city", "北京2", PageContext.REQUEST_SCOPE);
    pageContext.setAttribute("city", "北京3", PageContext.SESSION_SCOPE);
    pageContext.setAttribute("city", "北京4", PageContext.APPLICATION_SCOPE);

    //不写序号是默认往page里设置的
    pageContext.setAttribute("city", "北京5");

    pageContext.removeAttribute("city", 1);
    pageContext.removeAttribute("city", 4);

    //不写序号是是默认从page里获取的
    out.print(pageContext.getAttribute("city"));
    out.print(pageContext.getAttribute("city", 1));
    out.print(pageContext.getAttribute("city", 2));
    out.print(pageContext.getAttribute("city", 3));
    out.print(pageContext.getAttribute("city", 4));

    //不写序号是按照默认的域容器顺序：page,request,session,application从里获取的
    out.print(pageContext.findAttribute("city"));

    Category c = new Category("c111", "汽车分类");
    Product p = new Product("p666", "G63", 165, c);

    pageContext.setAttribute("product", p, 2);
%>
    商品的名字：<%=((Product)pageContext.getRequest().getAttribute("product")).getPname()%>
    商品的分类名：<%=((Product)pageContext.getRequest().getAttribute("product")).getCategory().getCname()%>

    <hr>
    <%--
        EL表达式是用来简化java代码的

    --%>

    商品的名字：${requestScope.product.pname}
    商品的分类名：${requestScope.product.category.cname}

    <hr>

    商品的名字：${product.pname}
    商品的分类名：${product.category.cname}
</body>
</html>
