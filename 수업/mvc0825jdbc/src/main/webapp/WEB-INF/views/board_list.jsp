<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
</head>
<body>
	<h1>게시물 목록</h1>
	<a href="board_insert_form">게시물 등록</a>
	<br>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
		</tr>
		<c:forEach items="${board_list}" var="brd">
			<tr>
				<td>${brd.no}</td>
				<td><a href="board_detail">${brd.title}</td>
				<td>${brd.writer}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>