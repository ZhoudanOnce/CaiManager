<%@page import="Bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<div id="user_info">
		<a href='../user/edit_user_info.jsp'>
		<img src="../access/用户中心.png" height="30" width="40">
		<%
		out.print(((UserBean)session.getAttribute("user")).getUser_name());
		%>
		</a>
		<a href="../Servlet/Logout" >退出</a>
	</div>
	<style>
	#user_info {
		display: flex;
		font-size: 23px;
		display: flex;
		height: 100%;
		align-items: center;
		justify-content: space-between;
		padding:10px 50px;
	}
	#user_info a{
		color:white;
		text-decoration: none;
	}
	</style>
</div>