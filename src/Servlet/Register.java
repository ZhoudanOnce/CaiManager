package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.AppUtil;

@WebServlet("/Servlet/Register")
public class Register extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			RegisterAction(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			RegisterAction(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void RegisterAction(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 开始交验
		if (request.getParameter("userName").equals("")) {
			AppUtil.SetMessage(request.getSession(), "账号不能为空！");
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}

		if (request.getParameter("passWord").equals("")) {
			AppUtil.SetMessage(request.getSession(), "密码不能为空！");
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}

		// 密码匹配正则表达式
		if (!Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$", 
				request.getParameter("passWord"))) {
			AppUtil.SetMessage(request.getSession(), "密码必须是包含字母和数字且长度达于6位！");
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}

		if (!request.getParameter("passWord").equals(request.getParameter("passWord2"))) {
			AppUtil.SetMessage(request.getSession(), "两次输入的密码不一致！");
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}
		if (request.getParameter("birthday").equals("")) {
			AppUtil.SetMessage(request.getSession(), "生日不能为空！");
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}
		if (request.getParameter("email").equals("")) {
			AppUtil.SetMessage(request.getSession(), "邮箱不能为空！");
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}
		if (!Pattern.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", 
				request.getParameter("email"))) {
			AppUtil.SetMessage(request.getSession(), "请输入正确邮箱地址！");
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}
		if (request.getParameter("mobile").equals("")) {
			AppUtil.SetMessage(request.getSession(), "手机号不能为空！");
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}
		if (request.getParameter("mobile").length() != 11) {
			AppUtil.SetMessage(request.getSession(), "手机号位数不是11位！");
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}
		if (request.getParameter("address").equals("")) {
			AppUtil.SetMessage(request.getSession(), "住址不能为空！");
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}
		if (!Pattern.matches("[\\u4e00-\\u9fa5]+", request.getParameter("address"))) {
			AppUtil.SetMessage(request.getSession(), "住址不是全中文！");
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}

		Connection conn = AppUtil.GetConnection();
		Statement st = conn.createStatement();

		// 先去查一遍有没有该账号
		String sql = "select USER_ID from sale_user where USER_NAME = '" + request.getParameter("userName") + "'";
		ResultSet rs = st.executeQuery(sql);
		System.out.println(sql);
		System.err.println(rs.getRow());
		if (rs.next()) {
			rs.close();
			st.close();
			conn.close();
			AppUtil.SetMessage(request.getSession(), "注册失败！该账号已存在！");
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}

		sql = "INSERT INTO sale_user(USER_NAME,USER_PASSWORD,USER_SEX,USER_BIRTHDAY,"
				+ "USER_EMAIL,USER_MOBILE,USER_ADDRESS)" + "VALUES (\"" + request.getParameter("userName") + "\",\""
				+ request.getParameter("passWord") + "\",\"" + request.getParameter("sex") + "\",\""
				+ request.getParameter("birthday") + "\",\"" + request.getParameter("email") + "\",\""
				+ request.getParameter("mobile") + "\",\"" + request.getParameter("address") + "\")";
		System.out.println("执行SQL:" + sql);
		st.executeUpdate(sql);
		st.close();
		conn.close();
		AppUtil.SetMessage(request.getSession(), "注册成功！");
		response.sendRedirect("../");
	}
}