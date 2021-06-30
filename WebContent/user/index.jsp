<%@page import="Bean.UserBean"%>
<%@page import="Bean.OrderBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Services.OrderServices"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>用户界面</title>
<jsp:include page="../Template/AlertMsg.jsp" />
<jsp:include page="../Template/AllCssStyle.jsp" />
<jsp:include page="../Template/Shelf.jsp" />
</head>

<body>
	<jsp:include page="../Template/ShowUserInfo.jsp" />
	<div id="user-body">
		<div id="user-body">
			<div id="user-title">请选择您需要的服务</div>
			<div id="user-function" class="fun-box">
				<a href="infoadd.jsp?order_name=维修"><img src="../access/维修.png" height="50" width="50">维修</a>
				<a href="infoadd.jsp?order_name=安装"><img src="../access/安装.png" height="50" width="50">安装</a>
				<a href="infoadd.jsp?order_name=保养"><img src="../access/保养.png" height="50" width="50">保养</a>
			</div>
			<div id="my-order" class="fun-box">
				<table class="mytable">
					<tr>
						<td class="title" colspan="6">我的订单</td>
					</tr>
					<tr>
						<th>订单编号</th>
						<th>产品名称</th>
						<th>需求</th>
						<th>上门时间</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
					<%
						List<OrderBean> orders = OrderServices.GetOrder(((UserBean) session.getAttribute("user")).getUser_id());
						for (OrderBean o : orders) {
							out.print("<tr class='h'>");
							out.print("<td>" + o.getId() + "</td>");
							out.print("<td>" + o.getOrder_name() + "</td>");
							out.print("<td>" + o.getWant() + "</td>");
							out.print("<td>" + o.getDate() + "</td>");
							switch (o.getStatus()) {
							case 1:
								out.print("<td>订单未审核</td>");
								break;
							case 2:
								out.print("<td>订单未付款</td>");
								break;
							case 3:
								out.print("<td>订单已完成</td>");
								break;
							default:
								out.print("<td>订单异常</td>");
							}
							out.print("<td>");
							switch (o.getStatus()) {
							case 1:
								out.print("等待管理员审核");
								break;
							case 2:
								out.print("<a href='../Servlet/OrderSetMoney?orderid=" + o.getId() + "'>付款</a>");
								break;
							case 3:
								out.print("<a href='../Servlet/DeleteOrder?orderid=" + o.getId() + "'>删除订单</a>");
								break;
							default:
								out.print("订单异常");
							}
							out.print("</td>");
							out.print("</tr>");
						}
					%>
				</table>
				<div class="count">
					共计<%
						out.print(orders.size());
					%>条订单
				</div>
			</div>
		</div>
	</div>
	<style>
.fun-box {
	margin: 0 100px;
	border-radius: 5px;
	background-color: white;
	padding: 10px;
	margin-bottom: 30px;
}

#user-body {
	background-color: #212529;
	background-image: url("../access/bg-user.jpg");
	background-repeat: no-repeat;
	background-size: 100% 100%;
}

#user-title {
	font-weight: bolder;
	font-size: 4rem;
	color: white;
	text-align: center;
	padding: 100px;
}

#user-function {
	background-color: white;
	padding: 0 200px;
	height: 200px;
	display: flex;
	align-items: center;
	justify-content: space-around;
}

#user-function>* {
	color: #007bff;
	font-size: 4rem;
	font-weight: bolder;
	text-align: center;
}

#user-function div:hover {
	text-decoration: underline;
	cursor: pointer;
}

#my-order {
	padding-top: 30px;
	padding-bottom: 30px;
}
</style>
</body>

</html>