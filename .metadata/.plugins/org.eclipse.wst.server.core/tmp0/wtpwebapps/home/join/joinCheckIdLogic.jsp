<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "com.myhome.dao.MemberDao" %>

<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	
	MemberDao dao = new MemberDao();
	boolean result = dao.isExistId(id);
	response.sendRedirect("joinCheckIdView.jsp?id="+ id + "&result=" + result);
%>
