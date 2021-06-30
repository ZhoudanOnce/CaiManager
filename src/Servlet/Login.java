package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.OrderBean;
import Bean.UserBean;
import Services.OrderServices;
import Util.AppUtil;

@WebServlet("/Servlet/Login")
public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			LoginAction(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			LoginAction(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 这个方法需要去判断是管理员还是用户
	// 管理员跳转到管理员界面 用户跳转到用户界面
	private void LoginAction(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException {
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("userName") == "") {
			response.sendRedirect("../index.jsp");
			AppUtil.SetMessage(request.getSession(), "请填写账号！");
			return;
		}
		Connection conn = AppUtil.GetConnection();
		Statement stmt = conn.createStatement();
		String sql = "select * from sale_user where USER_NAME = " + "\""
				+ request.getParameter("userName") + "\"";
		System.out.println("执行SQL语句："+sql);
		ResultSet rs = stmt.executeQuery(sql);
		if (!rs.next()) {
			response.sendRedirect("../index.jsp");
			AppUtil.SetMessage(request.getSession(), "用户不存在在！");
			conn.close();
			return;
		}
		if (!rs.getString("USER_PASSWORD").equals(request.getParameter("passWord"))) {
			response.sendRedirect("../index.jsp");
			AppUtil.SetMessage(request.getSession(), "密码错误！");
			return;
		}
		
		UserBean ub = new UserBean();
		ub.setUser_id(rs.getInt("USER_ID"));
		ub.setUser_name(rs.getString("USER_NAME"));
		ub.setUser_sex(rs.getString("USER_SEX"));
		ub.setUser_email(rs.getString("USER_EMAIL"));
		ub.setUser_mobile(rs.getString("USER_MOBILE"));
		ub.setUser_address(rs.getString("USER_ADDRESS"));
		ub.setUser_type(rs.getString("USER_TYPE"));
		ub.setUser_password(rs.getString("USER_PASSWORD"));
		ub.setUser_birthday(rs.getString("USER_BIRTHDAY"));
		request.getSession().setAttribute("user", ub);
		
		//1是管理员 2是普通用户
		switch (rs.getInt("USER_TYPE")) {
			case 1:
				response.sendRedirect("../manager/index.jsp?type=weixiu");
				break;
			case 2:
				response.sendRedirect("../user");
				AppUtil.SetMessage(request.getSession(), "登录成功！");
				break;
			case 3:
				response.sendRedirect("../fix");
				AppUtil.SetMessage(request.getSession(), "登录成功！");
				break;
			default:
				response.sendRedirect("../");
				AppUtil.SetMessage(request.getSession(), "用户类型错误！");
				break;
		}
		rs.close();
		conn.close();
	}
}