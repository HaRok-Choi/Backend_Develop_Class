<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>
	<%
		int n1 = (int)(Math.random() * 8) + 2;	// 2 ~ 9	
		int n2 = (int)(Math.random() * 9) + 1;	// 1 ~ 9
		int result = n1 * n2;
	%>
		
	<form action="gugudan_result.jsp" method="get">
		<%= n1 %> X <%= n2 %> = <input type="number" name="user_answer">
		<input type="hidden" name="result" value="<%=result%>">
		<input type="submit" value="결과보기">
	</form>
</body>
</html>