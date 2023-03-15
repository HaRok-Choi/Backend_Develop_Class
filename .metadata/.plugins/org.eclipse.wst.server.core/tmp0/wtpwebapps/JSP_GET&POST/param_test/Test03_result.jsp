<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 파라미터 이름을 얻어오고 싶을때
	Enumeration <String> names = request.getParameterNames();
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getParameterNames</title>
</head>
<body>
	<%while(names.hasMoreElements()) {%>
		<%= names.nextElement() %><br>
	<%} %>
</body>
</html>