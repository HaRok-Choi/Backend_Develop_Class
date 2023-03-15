<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영역별 재저장후 페이지</title>
</head>
<body>
	<%
		String s1_1 = (String)pageContext.getAttribute("tmp");
		String s2_1 = (String)request.getAttribute("tmp");
		String s3_1 = (String)session.getAttribute("tmp");
		String s4_1 = (String)application.getAttribute("tmp");
	%>
	Test02 도착!<br>
	page : <%=s1_1 %><br>
	request : <%=s2_1 %><br>
	session : <%=s3_1 %><br>
	application : <%=s4_1 %><br>
	
	<a href="Test03.jsp">Test03으로 이동</a>	
	<!-- ↑ redirect된다(아예 다른 페이지로 이동) -->
	<!-- Test02와 Test03은 아무런 연관 관계가 없다 -->
</body>
</html>