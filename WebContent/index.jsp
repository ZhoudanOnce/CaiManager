<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>采暖设备维修管理系统</title>
<jsp:include page="Template/AlertMsg.jsp" />
<jsp:include page="Template/AllCssStyle.jsp" />
<style>
body {
	background-color: #F7F7F7;
	margin: 0;
	display: flex;
	height: 80vh;
	justify-content: center;
	align-items: center;
}

form {
	background-color: white;
	padding: 40px;
	border-radius: 5px;
}

input {
	font-size: 20px;
	width: 380px;
	padding: 10px;
	border-radius: 5px;
}

input[type='text'], input[type='password'], form {
	border: 1px solid #dbdbdb;
}

input[type='button'], input[type='submit'] {
	border: none;
	color: white;
	background-color: #C10000;
	cursor: pointer;
}

a {
	color: #262626;
}
</style>
</head>

<body>
	<form method="POST" action="./Servlet/Login">
		<img src="access/网络设备.png" height="70" width="100" style="vertical-align:middle;">
		<font size="4">&nbsp;&nbsp;采暖设备维修管理系统登录界面</font>
		<p>
			<input type="text" name="userName" placeholder="用户名/姓名">
		</p>
		<p>
			<input type="password" name="passWord" placeholder="密码">
		</p>
		<p>
			<input type="submit" name="" value="登  录">
		</p>
		<p>
			<a href="user/reg.jsp">没有账号？点击注册账号</a>
		</p>
	</form>
</body>
</html>