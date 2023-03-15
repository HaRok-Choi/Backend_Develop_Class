<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp"%>

<%
	String nickname = (String)request.getAttribute("nickname");
					// nickname 속성(attribuye)이 없으면, null이 리턴됨
%>
	
<% if(nickname != null) {%>
	<h3>환영합니다. <%=nickname %>님!</h3>
	<br>
	<h5><a href="/home/signout/signoutView.jsp" >회원탈퇴</a></h5>
<%} else {%>
	<h3>아이디 혹은 비밀번호를 확인해주세요.</h3>
<%} %>

<input type="button" value="메인으로" onclick="location.href='/home/index.jsp'">

<%@ include file="/layout/footer.jsp"%>