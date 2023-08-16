<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!int com_num = new java.util.Random().nextInt(100) + 1;%>
<%
String num = request.getParameter("num");
int i = Integer.parseInt(num);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숫자 맞추기 게임 결과</title>
</head>
<body>
	<%
	if ((com_num) == i) {
	%>
	<h1>추카추카, 정답입니다</h1>
	<%
	} else if (com_num > i) {
	%>
	<h1><%=i%>
		올려주세요
	</h1>
	<%
	} else {
	%>
	<h1><%=i%>내려주세요
	</h1>
	<%
	}
	%>
</body>
</html>