<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/17
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript">
        function sdfdsaff() {
            alert("aaaaaaaa");
        }

        //给函数起名
        sdfdsaff();

        //给函数起别名
        var a = sdfdsaff;
        a();

        //给函数起别名
        var a = sdfdsaff();
        a;

        //给函数起别名
        var $ = sdfdsaff();
        $;
    </script>
</head>
<body>

</body>
</html>
