<%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2018/7/25
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>省市区三级联动</title>
    <!--引入JQuery文件-->
    <script type="text/javascript" src="/day17/js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript">
        //页面加载事件
        $(function () {
            $.ajax({
                type: "post",
                url: "/day17/findPcdListServlet",
                data: "pid=-1",
                success: function (data) {
                    console.info(data);
                    var str = "<option value='none'>--请选择省--</option>";
                    for (var i = 0; i < data.length; i++) {
                        str += "<option value='" + data[i].id + "'>" + data[i].name + "</option>";
                    }
                    $("#province").html(str);
                }
            });


            $("#province").change(function () {
                $("#city").html("<option value='null'>--请选择市--</option>");
                $("#district").html("<option value='null'>--请选择区--</option>");

                var provinceId = this.value;
                $.post("/day17/findPcdListServlet", {"pid": provinceId}, function (data) {
                    var str = "<option value='null'>--请选择市--</option>";
                    for (var i = 0; i < data.length; i++) {
                        str += "<option value='" + data[i].id + "'>" + data[i].name + "</option>";
                    }
                    $("#city").html(str);
                });
            });


            $("#city").change(function () {
                var districtId = this.value;
                $.post("/day17/findPcdListServlet", {"pid": districtId}, function (data) {
                    var str = "<option value='null'>--请选择区--</option>";
                    for (var i = 0; i < data.length; i++) {
                        str += "<option value='" + data[i].id + "'>" + data[i].name + "</option>";
                    }
                    $("#district").html(str);
                });
            });
        });
        //value不要写错,str要写在代码块中,province变city写,city变district写
    </script>
</head>
<body>
<select id="province">
    <option value="null">--请选择省--</option>
</select>
<select id="city">
    <option value="null">--请选择市--</option>
</select>
<select id="district">
    <option value="null">--请选择县区--</option>
</select>

</body>
</html>
