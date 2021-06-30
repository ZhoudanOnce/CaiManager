package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.UserBean;
import Services.UserSerices;
import Util.AppUtil;

@WebServlet("/Servlet/UpdateUser")
public class UpdateUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UpdateAction(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UpdateAction(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void UpdateAction(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		request.setCharacterEncoding("UTF-8");
		UserBean userBean = new UserBean();
		// 开始交验
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
		userBean.setUser_password(request.getParameter("passWord"));
		if (request.getParameter("birthday").equals("")) {
			AppUtil.SetMessage(request.getSession(), "生日不能为空！");
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}
		userBean.setUser_birthday(request.getParameter("birthday"));
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
		userBean.setUser_email(request.getParameter("email"));
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
		userBean.setUser_mobile(request.getParameter("mobile"));
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
		userBean.setUser_address(request.getParameter("address"));
		UserBean old = ((UserBean) request.getSession().getAttribute("user"));
		userBean.setUser_id(old.getUser_id());
		userBean.setUser_type(old.getUser_type());
		userBean.setUser_name(old.getUser_name());
		UserSerices.Update(userBean);
		request.getSession().setAttribute("user", userBean);
		AppUtil.SetMessage(request.getSession(), "个人信息修改成功！");
		response.sendRedirect(request.getHeader("Referer"));
	}
}