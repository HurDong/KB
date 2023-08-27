<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<title>Hangman Game</title>
</head>
<body>
	<h1>Hangman Game</h1>
	<h2>Attempts left: ${attempts}</h2>
	<h2>Word: ${displayWord}</h2>

	<c:forEach var="i" begin='65' end='90'>
		<form action="hangman_check" method="get" style="display: inline;">
			<input type="hidden" name="letter"
				value="${fn:toUpperCase(fn:substring('abcdefghijklmnopqrstuvwxyz', i-65, i-64))}" />
			<input type="submit"
				value="${fn:toUpperCase(fn:substring('abcdefghijklmnopqrstuvwxyz', i-65, i-64))}"
				style="font-size: 24px; margin: 5px;" />
		</form>
	</c:forEach>

	<c:if test="${not empty param.popupMessage}">
		<script>
			alert('${param.popupMessage}');
			window.location.href = "/kb04/hangman_form";
		</script>
	</c:if>
</body>
</html>
