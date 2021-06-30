
<%@page import="Bean.UserBean"%>
<%@page import="Services.UserSerices"%>
<%@page import="Bean.OrderBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Services.OrderServices"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../Template/AlertMsg.jsp" />
<jsp:include page="../Template/AllCssStyle.jsp" />
<style>
body {
	margin: 0;
	padding: 10px;
}
</style>

<%
	System.out.println(request.getParameter("order_name"));
%>

<table class="mytable">
	<tr>
		<td colspan="9" class="title">用户管理</td>
	</tr>
	<tr>
		<td>用户名</td>
		<td colspan="8"><form type="GET" style="margin: 0">
				<input name="user_name" /> <input value="查询" type="submit" />
			</form></td>
	</tr>
	<tr>
		<th>用户ID</th>
		<th>用户名</th>
		<th>性别</th>
		<th>出生日期</th>
		<th>邮箱</th>
		<th>电话</th>
		<th>地址</th>
		<th>操作</th>
	</tr>
	<%
		List<UserBean> users = null;
		if (request.getParameter("user_name")==null)
			users = UserSerices.GetAllUsers();
		else
			users = UserSerices.GetAllUsers(request.getParameter("user_name"));
		for (UserBean o : users) {
			out.print("<tr class='h'>");
			out.print("<td>" + o.getUser_id() + "</td>");
			out.print("<td>" + o.getUser_name() + "</td>");
			if (o.getUser_sex() == null) {
				out.print("<td>未知性别</td>");
			} else {
				switch (o.getUser_sex()) {
				case "1":
					out.print("<td>男</td>");
					break;
				case "2":
					out.print("<td>女</td>");
					break;
				default:
					out.print("<td>未知性别</td>");
				}
			}
			out.print("<td>" + o.getUser_birthday() + "</td>");
			out.print("<td>" + o.getUser_email() + "</td>");
			out.print("<td>" + o.getUser_mobile() + "</td>");
			out.print("<td>" + o.getUser_address() + "</td>");
			out.print("<td><a href='../Servlet/DeleteUser?userid=" + o.getUser_id() + "'>删除</a></td>");
			out.print("</tr>");
		}
	%>
</table>

<div class="count1">
	共<%
		out.print(users.size());
	%>个用户
</div>