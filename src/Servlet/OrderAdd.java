package Servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.OrderBean;
import Bean.UserBean;
import Services.OrderServices;
import Util.AppUtil;

@WebServlet("/Servlet/OrderAdd")

public class OrderAdd extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			AddAction(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/* 对应表单的get请求方式
	 * HttpServletRequest：请求对象
	 * HttpServletResponse：响应对象
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			AddAction(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private void AddAction(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, SQLException, IOException{
		request.setCharacterEncoding("UTF-8");//设定请求的字符集
		HttpSession session = request.getSession();//获取HttpSession对象
		/*getParameter 读取提交的表单中的值
		 *     
		 *     获取request.getSession().setAttribute()的值是：
　　   		request.getSession().getAttribute("属性名称");
			语法案例：
　　			对象类型Type 对象名name = (对象类型Type)request.getSession().getAttribute("属性名称");
		 * *///获取user的实体类 获取当前session中的实体类的id
		OrderServices.AddOrder(request.getParameter("order_name"),request.getParameter("date"),request.getParameter("want"), ((UserBean)session.getAttribute("user")).getUser_id());
		AppUtil.SetMessage(session, "订单添加成功！");//工具类中的发送浏览器alert提示 通过记录到session中 网页打开时读取这个message 并alert弹出来
		response.sendRedirect("../user");//实现重定向，页面跳转
		
	}
}