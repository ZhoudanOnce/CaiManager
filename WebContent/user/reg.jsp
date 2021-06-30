<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
body {
	margin: 0;
	height: 100vh;
	background: url("../access/bg_reg.jpg") no-repeat;
	background-size: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
}

form {
	background-color: rgba(255, 255, 255, .8);
	padding: 10px 50px;
	border-radius: 5px;
	border: 1px solid #dbdbdb;
	width: 400px;
	margin-left: 600px;
}

h1 {
	padding: 0px;
	margin: 0px;
	font-size: 30px;
	background: #3344AA;
	text-align: center;
	line-height: 60px;
	color: #FFFFFF
}

a {
	color: #262626;
}

input[type='submit'], input[type='button'] {
	border: none;
	color: white;
	background-color: #C10000;
	cursor: pointer;
}

input {
	padding: 10px;
	border-radius: 5px;
	border: 1px solid #dbdbdb;
}

input, span {
	font-size: 15px;
}
</style>
<jsp:include page="../Template/AlertMsg.jsp" />
</head>

<body>
	<div id="a" style="background-color: wheat;"></div>
	<form action="../Servlet/Register" method="POST">
		<h1>用户注册</h1>
		<p>
			<font size="1" color=red>*</font> <span>姓名：</span> <input type="text" name="userName"
				placeholder="请输入姓名"><font size="1" color=red>&nbsp;&nbsp;姓名不能为空</font>
		</p>
		<p>
		<font size="1" color=red>*</font>	<span>密码：</span> <input type="password" name="passWord"
				placeholder="请输入密码"><font size="1" color=red>&nbsp;&nbsp;数字加字母长度大于6位</font>
		</p>
		<p>
			<font size="1" color=red>*</font> <span>重复：</span> <input type="password" name="passWord2"
				placeholder="请再次输入密码"><font size="1" color=red>&nbsp;&nbsp;两次密码 输入一致</font>
		</p>
		<p>
			<font size="1" color=red>*</font> <span>性别：</span> <label><input type="radio" name="sex"
				checked value="1">男</label> <label><input type="radio"
				name="sex" value="2">女</label><font size="1" color=red>&nbsp;&nbsp;性别不能为空</font>
		</p>
		<p>
			
			 <font size="1" color=red>*</font> <span>生日：</span> <input type="date" name="birthday" value='1999-08-08'><font size="1" color=red>&nbsp;&nbsp;生日不能为空</font>
		</p>
		<p>
			<font size="1" color=red>*</font>
			<span>邮箱：</span> <input type="text" name="email" placeholder="请输入邮箱"><font size="1" color=red>&nbsp;&nbsp;请输入正确的邮箱格式</font>
		</p>
		<p>
			<font size="1" color=red>*</font>
			<span>手机：</span> <input type="text" name="mobile"
				placeholder="请输入手机号码"><font size="1" color=red>&nbsp;&nbsp;请输入正确的邮箱格式</font>
		</p>
		<p>
			<font size="1" color=red>*</font>
			<span>住址：</span> <input type="text" name="address"
				placeholder="请输入地址 "><font size="1" color=red>&nbsp;&nbsp;地址不能为空</font>
		</p>
		<p>
			<input type="submit" value="注册 ">
		</p>
		<p>带*为必填信息</p>
		<p>
			<a href="../ ">已有账号登录</a>
		</p>
	</form>
</body>

</html>