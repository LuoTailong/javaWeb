<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/17
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/day17/js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript">
        /* 通过jquery代码来操作ajax */
        //1. 因为所有的动作都是在窗体加载完毕之后实现的, 所以我们先编写: 页面加载事件.
        $(function () {
            /*//校验用户名, 其实就给是username文本框注册一个离焦时间
            $("input[name='username']").blur(function () {
                //1. 获取用户录入的用户名.
                var usernameVal = $(this).val();
                //2. 通过ajax(异步刷新技术), 来校验该用户名是否可用
                $.get("/day17/checkUsernameServlet", {"username": usernameVal},
                    function (data) {
                        $("#username_msg").html("jquery_ajax2..." + data);
                    });
            });


            //校验昵称
            $("input[name='nickname']").blur(function () {
                //1. 获取用户在浏览器录入的数据
                var nicknameVal = $(this).val();
                //alert(nicknameVal);

                //2. 通过ajax校验昵称是否存在
                $.post("/day17_ceshi/checkNicknameServlet", {"nickname": nicknameVal},
                    function (data) {
                        $("#nickname_msg").html("jquery_ajax2..." + data);
                    });
            });*/



            $("input[name='username']").blur(function () {
                var usernameval = $(this).val();
                $.get("/day17/checkUsernameServlet", {"username":usernameval},function (data) {
                     $("#username_msg").html(data);
                });
            });
            $("input[name='nickname']").blur(function () {
                var nicknameval = $(this).val();
                $.get("/day17/checkNicknameServlet", {"nickname":nicknameval},function (data) {
                     $("#nickname_msg").html(data);
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
