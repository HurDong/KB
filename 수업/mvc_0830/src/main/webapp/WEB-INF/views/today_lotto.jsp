<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘의 로또번호 추천</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#lotto").click(function() {
			var options = {
				url : "today_lotto",
				success : function(data) {
					$.each(data, function() {
						console.log(this)
						$("#msg").append(this + " ")
					})
				},
				error : function() {
				}
			}
			$.ajax(options)
		})
	})
</script>
</head>
<body>
	<button id="lotto">로또번호 추천</button>
	<div id="msg"></div>
</body>
</html>