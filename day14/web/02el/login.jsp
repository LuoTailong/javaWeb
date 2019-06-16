<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/11
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
    <form method="post" action="/day14/02el/01.jsp">
        <table>
            <tr>
                <td colspan="2">
                    <font color="red">
                        <%--<%=request.getAttribute("message") == null?"":request.getAttribute("message") %>--%>
                        ${message==null?"":message }
                    </font>
                </td>
            </tr>
            <tr>
                <td>
                    用户名
                </td>
                <td>
                    <input type="text" name="username">
                </td>
            </tr>
            <tr>
                <td>
                    密码
                </td>
                <td>
                    <input type="password" name="password">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" name="登陆">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
