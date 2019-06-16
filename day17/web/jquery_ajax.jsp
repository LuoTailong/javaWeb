<%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2018/7/25
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JQuery版本的ajax代码</title>
    <!--引入JQuery文件-->
    <script type="text/javascript" src="/day17/js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript">
        /* 通过jquery代码来操作ajax */
        //1. 因为所有的动作都是在窗体加载完毕之后实现的, 所以我们先编写: 页面加载事件.
        $(function () {
            //校验用户名, 其实就给是username文本框注册一个离焦时间
            $("input[name='username']").blur(function () {
                //1. 获取用户录入的用户名.
                var usernameVal = $(this).val();
                //2. 通过ajax(异步刷新技术), 来校验该用户名是否可用
                $.ajax({
                    type: "get",
                    url: "/day17/checkUsernameServlet",
                    data: "username=" + usernameVal,	//这个data是浏览器给服务器发送的数据
                    success: function (data) {		//这个data是服务器给浏览器响应的数据
                        $("#username_msg").html(data);
                    }
                });
            });

            /*$("input[name='username']").blur(function () {
                var usernameVal = $(this).val();
                $.ajax({
                    type: "get",
                    url: "/day17/checkUsernameServlet",
                    data: "username="+ usernameVal,
                    success: function (data) {
                        $("#username_msg").html(data);
                    }
                });
            });*/

            $("input[name='nickname']").blur(function () {
                var nicknameVal = $(this).val();
                $.ajax({
                    type: "POST",
                    url: "/day17/checkNicknameServlet",
                    data: "nickname=" + nicknameVal,
                    success: function (data) {
                        $("#nickname_msg").html(data);
                    }
                });
            });
        });
    </script>
</head>
<body>
<form action="" method="get">
    <table>
        <tr>
            <td>用户名(get):</td>
            <td>
                <input type="text" name="username">
            </td>
            <td>
                <span id="username_msg"></span>
            </td>
        </tr>

        <tr>
            <td>昵称(post):</td>
            <td>
                <input type="text" name="nickname">
            </td>
            <td>
                <span id="nickname_msg"></span>
            </td>
        </tr>

        <tr>
            <td>年龄:</td>
            <td>
                <input type="text" name="age">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="提交">
            </td>
        </tr>

    </table>
</form>
</body>
</html>
