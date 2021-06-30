<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//判断 alert有没有 有就show
	if (session.getAttribute("alert") != null)
		out.print("<script>alert('" + (String) session.getAttribute("alert") + "')</script>");
	session.setAttribute("alert", null);
%>