<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션을 종료 할때</title>
</head>
<body>
	<%
		session.invalidate(); // 클라-서버 간의 세션을 종료	
		session = request.getSession(); // 세션 다시 시작
		
		String s1_3 = (String)pageContext.getAttribute("tmp");
		String s2_3 = (String)request.getAttribute("tmp");
		String s3_3 = (String)session.getAttribute("tmp");
		String s4_3 = (String)application.getAttribute("tmp");
	%>
	Test04 도착! (세션 재시작)<br>
	page : <%=s1_3 %><br>
	request : <%=s2_3 %><br>
	session : <%=s3_3 %><br>
	application : <%=s4_3 %><br>
	
</body>
</html>