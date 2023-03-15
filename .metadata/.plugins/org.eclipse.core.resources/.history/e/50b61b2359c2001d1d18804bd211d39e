<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>아이디 중복 확인</title>
	<script type="text/javascript" src="script.js"></script>
</head>
<%
	String id = request.getParameter("id");
	boolean result = Boolean.parseBoolean(request.getParameter("result"));
%>
<body>
	<!-- &qout; -> 쌍따옴표 -->
	
	<form action="joinCheckIdLogic.jsp" method="post">
	<% if(result) {%>
		&quot;<%= id %>&qout;(은)는 사용중입니다. <br><br>
		ID <input type="text" name ="id">
		<input type="submit" value="중복체크">
	<%} else {%>
		사용 가능한 아이디입니다. <br><br>
		<input type="button" value="사용" onclick="checkIdFormClose('<%=id%>')">
	<%} %>		
		
	</form>
</body>
</html>