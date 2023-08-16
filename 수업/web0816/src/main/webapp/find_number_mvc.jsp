<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>결과</title>
</head>
<body>
    <h1><%= request.getAttribute("message") %></h1>
    <a href="find_number_mvc.html">다시 시도</a>
</body>
</html>
