<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세</title>
</head>
<body>
	<h1>게시물 상세 정보</h1>
	<table>
		<tr>
			<th>번호</th>
			<td>${board.no}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.title}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writer}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${board.content}</td>
		</tr>
	</table>
	<a href="board_list">목록으로 돌아가기</a>
</body>
</html>
