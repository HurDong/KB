<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>action_include.jsp</title>
</head>
<body>
	<%
	String name = "홍길동";
	%>
	<h1>Include Action</h1>
	<%@include file="top_menu.jsp"%>
	<hr>
	<jsp:include page="top_menu.jsp"></jsp:include>
</body>
</html>