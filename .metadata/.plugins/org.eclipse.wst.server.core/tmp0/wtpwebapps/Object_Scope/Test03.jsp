<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test02와 관계가 없는 페이지</title>
</head>
<body>
	<%
		String s1_2 = (String)pageContext.getAttribute("tmp");
		String s2_2 = (String)request.getAttribute("tmp");
		String s3_2 = (String)session.getAttribute("tmp");
		String s4_2 = (String)application.getAttribute("tmp");
	%>
	Test02 도착!<br>
	page : <%=s1_2 %><br>
	request : <%=s2_2 %><br>
	session : <%=s3_2 %><br>
	application : <%=s4_2 %><br>
	
	<a href="Test04.jsp">Test04으로 이동</a>	
</body>
</html>