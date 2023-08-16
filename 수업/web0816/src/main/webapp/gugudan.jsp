<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error_gugudan.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String sdan = request.getParameter("dan");
	int dan = Integer.parseInt(sdan);
	for (int i = 1; i < 10; i++) {
	%>
	<%=dan%>
	*
	<%=i%>
	=
	<%=dan * i%><br>
	<%
	}
	%>
</body>
</html>