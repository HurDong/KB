<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숫자를 올려주세요.</title>
</head>
<body>
	<%String num = request.getParameter("num"); %>
	<h1><%= num %>숫자를 올려주세요
	</h1>
</body>
</html>