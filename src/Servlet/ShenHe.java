package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.OrderServices;
import Util.AppUtil;

@WebServlet("/Servlet/ShenHe")
public class ShenHe extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ShenAction(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ShenAction(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void ShenAction(HttpServletRequest request, HttpServletResponse response)
			throws NumberFormatException, SQLException, IOException {
		OrderServices.ShenHe(Integer.parseInt(request.getParameter("orderid")));
		AppUtil.SetMessage(request.getSession(), "审核成功！");
		response.sendRedirect(request.getHeader("Referer"));
	}

}
