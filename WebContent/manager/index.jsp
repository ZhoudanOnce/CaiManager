<%@page import="Bean.OrderLimit"%>
<%@page import="Bean.OrderBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Services.OrderServices"%>
<%@page import="Util.AppUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>后台管理</title>
<jsp:include page="../Template/AlertMsg.jsp" />
<jsp:include page="../Template/AllCssStyle.jsp" />
<jsp:include page="../Template/Shelf.jsp" />
<%
	session.setAttribute("orderlimit", new OrderLimit());
%>
<style>
#manager-body {
	display: flex;
	height: 100%;
	overflow: hidden;
}

#ce {
	flex-basis: 200px;
	background-color: rgb(243, 242, 242);
	flex-shrink: 0;
	display: flex;
	flex-direction: column;
	border-right: 1px rgb(231, 230, 230) solid;
}

#ce>div {
	flex-basis: 40px;
	background-color: white;
	border-bottom: 1px rgb(231, 230, 230) solid;
	padding-left: 10px;
	display: flex;
	align-items: center;
}

.menu>a {
	text-decoration: none;
	color: black;
}

.menu>a:hover {
	color: rgb(25, 99, 170);
}

#caidan {
	font-size: 24px;
}

#manager-body>:nth-child(2) {
	height: 100%;
	width: 100%;
	overflow: auto;
}
</style>
</head>

<body>
	<jsp:include page="../Template/ShowUserInfo.jsp" />
	<div id="manager-body">
		<div id="ce">
			<div id="caidan">菜单</div>
			<div class="menu">
				<a href='<%out.print(request.getRequestURI() + "?type=user");%>'>用户管理</a>
			</div>
			
			<div class="menu">
				<a href='<%out.print(request.getRequestURI() + "?type=weixiu");%>'>维修管理</a>
			</div>
			<div class="menu">
				<a href='<%out.print(request.getRequestURI() + "?type=anzhuang");%>'>安装管理</a>
			</div>
			<div class="menu">
				<a href='<%out.print(request.getRequestURI() + "?type=baoyang");%>'>保养管理</a>
			</div>
		</div>
		<div>
			<%
				switch (request.getParameter("type")) {

				case "user":
			%><iframe frameborder="0"
				src='UserManager.jsp?type=<%out.print(request.getParameter("type"));%>'></iframe>
			<%
				break;
				default:
			%><iframe frameborder="0"
				src='OrderManager.jsp?type=<%out.print(request.getParameter("type"));%>'></iframe>
			<%
				break;
				}
			%>
		</div>
	</div>
</body>

</html>