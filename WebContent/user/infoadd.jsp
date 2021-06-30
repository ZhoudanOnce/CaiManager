<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<jsp:include page="../Template/AlertMsg.jsp" />
<jsp:include page="../Template/AllCssStyle.jsp" />
<jsp:include page="../Template/Shelf.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>提交订单</title>
</head>
<body>
	<jsp:include page="../Template/ShowUserInfo.jsp" />
	
	<form class="myform" action="../Servlet/OrderAdd" method="POST">
		<table class="mytable">
			<tr>
				<td>需求</td>
				<td><input name="want" type="text"
					value='<%switch (request.getParameter("order_name")) {
			case "维修":				
				out.print("维修");
				break;
			case "安装":
				out.print("安装");
				break;
			case "保养":
				out.print("保养");
				break;
			}%>' /></td>
			</tr>
			<tr>
				<td>产品名称</td>
				<td><select name="order_name">
						<option value="空调" selected>空调</option>
						<option value="壁挂炉">壁挂炉</option>
						<option value="暖气片">暖气片</option>
						<option value="地暖">地暖</option>
						<option value="热水器">热水器</option>
				</select></td>
			</tr>
			<tr>
				<td>上门时间</td>
				<td><input type="date" name="date"
					value='<%Date now = new Date();
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			out.print(f.format(now));%>' /></td>
			</tr>
			<tr>
				<td><a href="../user">返回上一页</a></td>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>
	<style>
form {
	margin-top: 200px;
}
</style>
</body>
</html>