<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String s= request.getParameter("aa");
	// 썼던 문장이 변수 s에 반환됨 ["aa"-내용]
	String ss= request.getParameter("Aa");
	// 없는 파라미터명이므로 null이 반환됨
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getParameter</title>
</head>
<body>
	입력받은 값은 : <%= s %><br>
	입력받은 값은 : <%= ss %>
</body>
</html>