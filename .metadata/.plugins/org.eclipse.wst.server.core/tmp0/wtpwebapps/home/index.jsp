<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 액션태그로 보낼땐 글자가 깨지기 때문에 UTF-8로 인코딩 해줘야 한다. -->
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:include page = "/layout/header.jsp" >
	<jsp:param value="메인페이지!" name="title"/>
</jsp:include>

<H2>Welcome!</H2>
<h3>나의 홈페이지!</h3>
<h5>이곳은 메인페이지입니다.</h5>

<%@ include file = "/layout/footer.jsp" %>