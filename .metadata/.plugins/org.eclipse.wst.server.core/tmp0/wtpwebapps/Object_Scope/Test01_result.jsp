<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String s1 = request.getParameter("page_test");
	String s2 = request.getParameter("request_test");
	String s3 = request.getParameter("session_test");
	String s4 = request.getParameter("application_test");
	
	// 영역 별 속성으로 재저장
	pageContext.setAttribute("tmp", s1);
	// 이 페이지 안에서만 쓸 수 있음(pageContext객체는 페이지마다 1개씩 존재)
	// 마지막에 클로즈가 되어서 이 페이지에서 선언된 pageContext는 사용을 못함
	
	request.setAttribute("tmp", s2);
	// forword되는 다음 페이지까지 쓸 수 있음(request객체는 포워딩 된 도착페이지가 끝나면 사라짐)
	
	session.setAttribute("tmp", s3);
	// 클라-서버 통신을 유지하는 동안 가능(session객체는 클라(세션)1개 당 1개씩)
	
	application.setAttribute("tmp", s4);
	// 서버가 살아있는 동안(application객체는 서버 통틀어 1개만 존재)
	
	// 속성 저장 후 Test02.jsp로 forword
	pageContext.forward("Test02.jsp");
%>