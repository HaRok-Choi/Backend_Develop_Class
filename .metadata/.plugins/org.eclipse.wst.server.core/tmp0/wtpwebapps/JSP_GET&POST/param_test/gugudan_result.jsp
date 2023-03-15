<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	int answer = Integer.parseInt(request.getParameter("user_answer")); 
	int result = Integer.parseInt(request.getParameter("result"));
	String calculationResult = answer == result ? "정답" : "틀림";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과</title>
</head>
<body>
	<%= calculationResult %>
</body>
</html>