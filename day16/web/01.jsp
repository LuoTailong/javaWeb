<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/17
  Time: 8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript">
        window.onload = function () {
            alert("js--111111111");//js中alert("js222222222222")会覆盖alert("js--111111111")jQuery不会
        }

        window.onload = function () {
            alert("js222222222222");
            var myDivObj = document.getElementById("myDiv");
            console.info(myDivObj);
            /*myDivObj.onclick = function () {
                myDivObj.style.background = "blue";
            }*/

            //js转jQuery对象：jQuery(js对象)
            jQuery(myDivObj).click(function () {
                jQuery(myDivObj).css("background", "blue");
            });
        }
    </script>
</head>
<body>
<div id="myDiv" style="color: red; width: 300px; height: 500px;">大数据16期生龙活虎!!</div>
</body>
</html>
