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

    </script>
</head>
<body>
<form action="" method="get">
    <table>
        <tr>
            <td>用户名(get):</td>
            <td>
                <input type="text" name="username" onblur="checkUsername(this)"/><%--this代表input--%>
                <script type="text/javascript">
                    function checkUsername(usernameObj) {
                        //1. 获取用户填写的用户名.
                        var usernameVal = usernameObj.value;
                        //2. 创建ajax对象.	//通过CV大法实现
                        var xmlhttp;
                        if (window.XMLHttpRequest) {
                            xmlhttp = new XMLHttpRequest();
                        } else {
                            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                        }
                        //3. 建立连接.
                        //第一个参数: 请求方式: get,post
                        //第二个参数: 请求的路径
                        //第三个参数: true表示异步, false:表示同步
                        xmlhttp.open("GET","/day17/checkUsernameServlet?username=" + usernameVal,true);
                        //4. 发送请求
                        xmlhttp.send();

                        //5. 处理响应
                        xmlhttp.onreadystatechange=function()
                        {
                            if (xmlhttp.readyState==4 && xmlhttp.status==200){
                                document.getElementById("username_msg").innerHTML=xmlhttp.responseText;
                            }
                        }
                    }
                </script>
            </td>
            <td>
                <span id="username_msg"></span>
            </td>
        </tr>

        <tr>
            <td>昵称(post):</td>
            <td>
                <input type="text" name="nickname" onblur="checkNickname(this)"/>
                <script type="text/javascript">
                    function checkNickname(nicknameObj) {
                        //1. 获取用户填写的用户名.
                        var nicknameVal = nicknameObj.value;
                        //2. 创建ajax对象.	//通过CV大法实现
                        var xmlhttp;
                        if (window.XMLHttpRequest) {
                            xmlhttp = new XMLHttpRequest();
                        } else {
                            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                        }
                        //3. 建立连接.
                        //第一个参数: 请求方式: get,post
                        //第二个参数: 请求的路径
                        //第三个参数: true表示异步, false:表示同步
                        xmlhttp.open("POST","/day17/checkNicknameServlet",true);
                        xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");

                        //4. 发送请求
                        xmlhttp.send("nickname="+nicknameVal);

                        //5. 处理响应
                        xmlhttp.onreadystatechange=function()
                        {
                            if (xmlhttp.readyState==4 && xmlhttp.status==200){
                                document.getElementById("nickname_msg").innerHTML=xmlhttp.responseText;
                            }
                        }
                    }
                </script>
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
