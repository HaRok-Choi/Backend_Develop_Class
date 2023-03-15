<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// String food = request.getParameter("food");
	String[] arr = request.getParameterValues("food");
	// 여러개를 받을때는 getParameterValues를 쓰고 배열 타입임
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getParameterValues</title>
</head>
<body>
	좋아하는 음식은<br>	
	<% for(int i = 0; i < arr.length; i++) { %> 
		<%= arr[i] %><br>
	<% } %>
	입니다.
	
</body>
</html>