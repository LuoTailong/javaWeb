<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.0.min.js"></script>

<script type="text/javascript">
$(function(){
	$("#btn1").click(function () {
		//方式一：
		// $("div").css("background","yellow");
		//方式二：
		// $("div").attr("style","background:yellow");
		//方式三：
		// $("div").addClass("changeBackYellow");
		// $("div").removeClass("changeBackYellow");
		//方式四：
		$("div").toggleClass("changeBackYellow");
    });

	$("#btn2").click(function () {
		$("div").toggleClass("changeFontBlue");
    });
});
</script>
<style type="text/css">
	.changeBackYellow {
		background : yellow;
	}
	
	.changeFontBlue {
		color : blue;
	}
</style>
</head>
<body>
	<div>心情不错！</div>
	<input type="button" value="背景变黄" id="btn1"/>
	<input type="button" value="字体变蓝" id="btn2"/>
</body>
</html>