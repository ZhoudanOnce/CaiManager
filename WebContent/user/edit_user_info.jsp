<%@page import="Bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../Template/AlertMsg.jsp" />
<jsp:include page="../Template/AllCssStyle.jsp" />
<jsp:include page="../Template/Shelf.jsp" />
<style>
.myform {
	margin: 0 auto;
	width: 400px;
	padding: 10px 0;
}

.myform>div {
	display: flex;
	align-items: center;
}

.form-group {
	margin: 0;
	display: contents;
}

.myform input {
	width: 100%;
}

.form-title {
	flex-basis: 50px;
	margin: 10px 0;
}

.frombutton {
	justify-content: space-evenly;
}

#form-title {
	font-weight: bolder;
	font-size: 3rem;
	margin: 10px 0;
}
</style>
</head>
<body>
	<%
		UserBean u = (UserBean) session.getAttribute("user");
		System.out.println(u.getUser_name());
	%>
	<jsp:include page="../Template/ShowUserInfo.jsp" />
	<form class="myform" method="POST" action="../Servlet/UpdateUser">
		<div id="form-title">修改个人信息</div>
		<div>
			<div class="form-title">账号</div>
			<div class="form-group">
				<input type="text" disabled class="form-control"
					value='<%out.print(u.getUser_name());%>' placeholder="请输入账号">
			</div>
		</div>
		<div>
			<div class="form-title">密码</div>
			<div class="form-group">
				<input type="text" name="passWord" class="form-control"
					value='<%out.print(u.getUser_password());%>' placeholder="请输入密码">
			</div>
		</div>
		<div>
			<div class="form-title">生日</div>
			<div class="form-group">
				<input type="date" name="birthday" class="form-control"
					value='<%out.print(u.getUser_birthday());%>' placeholder="请输入生日">
			</div>
		</div>
		<div>
			<div class="form-title">邮箱</div>
			<div class="form-group">
				<input type="text" name="email" class="form-control"
					value='<%out.print(u.getUser_email());%>' placeholder="请输入邮箱">
			</div>
		</div>
		<div>
			<div class="form-title">手机</div>
			<div class="form-group">
				<input type="text" name="mobile" class="form-control"
					value='<%out.print(u.getUser_mobile());%>' placeholder="请输入手机">
			</div>
		</div>
		<div>
			<div class="form-title">住址</div>
			<div class="form-group">
				<input type="text" name="address" class="form-control"
					value='<%out.print(u.getUser_address());%>' placeholder="请输入住址">
			</div>
		</div>
		<div class="frombutton">
			<button type="button" class="btn btn-default navbar-btn"
				onclick="<%if (u.getUser_type().equals("1"))
				out.print("window.location.href='../manager/index.jsp?type=weixiu';");
			else
				out.print("window.location.href='../user'");%>">返回</button>
			<button type="submit" class="btn btn-default navbar-btn btn-primary">修改</button>
		</div>
	</form>
</body>
</html>