<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
</head>
<body>
	<div ${errmsg}></div>
	<form action="login_action" method="post">
		아이디 : <input type="text" name="mid"><br> 비밀번호 : <input
			type="password" name="passwd"><br> <input type="submit"
			value="로 그 인">
	</form>
</body>
</html>