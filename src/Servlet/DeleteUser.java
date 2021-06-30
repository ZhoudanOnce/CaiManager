package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.UserSerices;
import Util.AppUtil;

@WebServlet("/Servlet/DeleteUser")
public class DeleteUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			DeleteAction(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			DeleteAction(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void DeleteAction(HttpServletRequest request, HttpServletResponse response)
			throws NumberFormatException, SQLException, IOException {
		String userid = request.getParameter("userid");
		if (userid.equals("")) {
			AppUtil.SetMessage(request.getSession(), "用户删除失败！");
			return;
		}
		UserSerices.DeleteUser(Integer.parseInt(userid));
		AppUtil.SetMessage(request.getSession(), "用户删除成功！");
		response.sendRedirect(request.getHeader("Referer"));
	}

}
