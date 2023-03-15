<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "/layout/header.jsp"%>

<% 
	boolean result = Boolean.parseBoolean(String.valueOf(request.getAttribute("result"))); 
	// String.valueOf : 자동으로 String으로 형변환
	String message = result ? "회원 탈퇴를 완료하였습니다." : "아이디, 비밀번호를 다시 확인해주세요.";
%>

<script>
	alert('<%= message%>');
	location.href='/home/index.jsp';
</script>

<%@ include file = "/layout/footer.jsp"%>