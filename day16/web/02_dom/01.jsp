<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/j	query-1.11.0.min.js"></script>
<script type="text/javascript">
$(function(){
	//设置和获取属性用attr(),其他用prop()
	$("#btn1").click(function () {
		// $("a").prop("href","http://www.baidu.com")
		$("a").attr("href","http://www.baidu.com")
    });
	$("#btn2").click(function () {
        // $("a").prop("aaaaa","aaaa");//只能设置标签存在的属性
		$("a").attr("aaaaa","aaaa");
    });

	$("#btn3").click(function () {
		$("input[name='sex']").each(function () {
			var chk = $(this).attr("checked");
			console.info("att=="+chk);
        })
    });//会出现undefined

	$("#btn4").click(function () {
		$("input[name='sex']").each(function () {
			var chk = $(this).prop("checked");
			console.info("att=="+chk);
        })
    });

});
</script>
</head>
<body>
	<a>百度</a> <br/>
	<input type="button" id="btn1" value="设置标签存在的属性"/> <br/>
	<input type="button" id="btn2" value="设置标签不存在的属性"/> <br/>
	<hr/>
	
	<input type="radio" name="sex" value="女"/>女
	<input type="radio" name="sex" value="男" checked="checked"/>男 <br/>
	<input type="button" id="btn3" value="通过attr获取选中状态"/> <br/>
	<input type="button" id="btn4" value="通过prop获取选中状态"/>
</body>
</html>