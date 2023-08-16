<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추카추카, 정답입니다.</title>
</head>
<body>
	<%String num = request.getParameter("num"); %>
	<h1><%= num %>추카추카 정답입니다
	</h1>
</body>
</html>