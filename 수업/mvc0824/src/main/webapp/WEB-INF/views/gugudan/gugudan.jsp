<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 게임</title>
</head>
<body>

	<form action="gugudan_view">
		<fieldset>
			2~9사이 숫자를 입력 : <input type="number" min="2" max="9" name="num">
			<br> <input type="submit" value="구구단 출력">
		</fieldset>
	</form>
	<div id="result">${result }</div>
	empty param.num = ${ empty param.num }	<br>
	not empty param.num = ${ not empty param.num }	<br>
	<c:if test="${ not empty param.num }">
	
		<c:forEach begin="1" end="9" var="i">
		${param.num} * ${i} = ${ param.num * i } <br>
		</c:forEach>
	
	</c:if>
</body>
	

</html>