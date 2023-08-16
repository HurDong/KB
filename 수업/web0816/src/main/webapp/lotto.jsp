<%@page import="java.util.TreeSet"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!TreeSet<Integer> lotto = new TreeSet<>();

	public void prn() {
		System.out.println("** JSP INIT **");
	}%>
<%
for (; lotto.size() < 6;) {
	int r = new java.util.Random().nextInt(45) + 1;
	lotto.add(r);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>오늘의 로또번호</h1>
	<h2><%=lotto.toString()%></h2>
	<h2><%=prn()%></h2>
</body>
</html>
