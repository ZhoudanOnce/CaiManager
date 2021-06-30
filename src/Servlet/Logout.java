package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.UserBean;
import Util.AppUtil;

@WebServlet("/Servlet/Logout")
public class Logout extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LogoutAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LogoutAction(request, response);
	}

	// 退出系统
	public static void LogoutAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().setAttribute("user", null);
		AppUtil.SetMessage(request.getSession(), "退出登录成功！");
		response.sendRedirect("../");
	}

}
