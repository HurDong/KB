<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
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
	String url = "";
	if (com_num == i) {
		url = "find_number_right.jsp";
	} else if (com_num < i) {
		url = "find_number_down.jsp";
	} else {
		url = "find_number_up.jsp";
	}
	%>
	<jsp:forward page="<%=url%>"></jsp:forward>
</body>
</html>