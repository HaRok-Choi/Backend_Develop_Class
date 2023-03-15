<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String titleParam = request.getParameter("title");
	String title = "rok`s page";
	if(titleParam != null){
		title = "rok`s : " + titleParam;
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title><%=title %></title>
		<link rel="stylesheet" type="text/css" href="/home/layout/layout.css">
	</head>
	<body>
		<div align = "center">
			<div class = "header" align = "center">
			<a href = "/home/login/loginView.jsp">LOGIN</a> |
			LOGOUT | 
			<a href = "/home/join/joinView.jsp">JOIN</a> | 
			MY PAGE |
			BOARD |
			DOWNLOADS
			</div>
			<div class="main" align="center">
			

