<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/17
  Time: 8:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript">
        jQuery(function () {
            alert("jQuery--111111111");
        });

        jQuery(function () {
            alert("jQuery--222222222");
            var $myDivObj = jQuery("#myDiv");

            console.info($myDivObj);
            /*$myDivObj.click(function () {
                $myDivObj.css("background", "blue");
            });*/


            //jQuery转成js对象：jQuery对象[0]
            $myDivObj[0].onclick = function () {
                $myDivObj[0].style.background = "green";
            }

            //把html文本转成jQuery对象.
            $("body").append(jQuery("<a href='http://www.itheima.com'>黑马程序员</a> <br>"));//<br>是js标签所以不能放外面

            //这个只是给页面增加一个超链接, 没有把html转成jQuery对象
            $("body").append("<a href='http://www.itheima.com'>黑马程序员</a>");
        });


    </script>
</head>
<body>
<div id="myDiv" style="color: red; width: 300px; height: 500px;">大数据16期生龙活虎!!</div>
</body>
</html>
