<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숫자맞추기 게임 for Spring FW</title>
</head>
<body>
	<form action="number_check">
		<fieldset>
			1~100사이 숫자를 입력 : <input type="number" min="1" max="100" name="num">
			<br> <input type="submit" value="정답 확인">
		</fieldset>
	</form>
	<div id="result">${result}</div>
</body>
</html>