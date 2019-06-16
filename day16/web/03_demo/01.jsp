<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/j	query-1.11.0.min.js"></script>

		<script type="text/javascript">
			$(function() {
				// 全选
				$("#checkall").click(function () {
					$("input[name='items']").prop("checked",true);
                });

				//全不选
				$("#checkallNo").click(function () {
					$("input[name='items']").prop("checked",false);
                });

				//反选
				$("#check_revsern").click(function () {
					$("input[name='items']").each(function () {
						$(this).prop("checked",!$(this).prop("checked"));
                    })
                });

				//全选或全不选
				$("#checkAllOrNot").click(function () {
				    //js写法
					var status = this.checked;
					//jQuery写法
					//var status = $(this).prop("checked");
					$("input[name='items']").prop("checked",status);
                });

			});
		</script>
	</head>

<body>
		您的爱好很广泛!!!
		<br>
		<input type="checkbox" id="checkAllOrNot" />全选/全不选<br/>
		<input type="checkbox" name="items" value="足球" />足球
		<input type="checkbox" name="items" value="篮球" />篮球
		<input type="checkbox" name="items" value="游泳" />游泳
		<input type="checkbox" name="items" value="唱歌" />唱歌
		<br>
		<input type="button" name="checkall" id="checkall" value="全选" />
		<input type="button" name="checkall" id="checkallNo" value="全不选" />
		<input type="button" name="checkall" id="check_revsern" value="反选" />
	</body>

</html>