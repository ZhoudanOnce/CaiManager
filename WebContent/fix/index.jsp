<%@page import="Bean.UserBean"%>
<%@page import="Bean.OrderBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Services.OrderServices"%>
<%@page import="Bean.OrderLimit"%>
<%@page import="Util.AppUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>工作人员后台</title>
<jsp:include page="../Template/AlertMsg.jsp" />
<jsp:include page="../Template/AllCssStyle.jsp" />
<jsp:include page="../Template/Shelf.jsp" />
</head>
<body>
	<jsp:include page="../Template/ShowUserInfo.jsp" />
	<br>
	<div id="my-order" class="fun-box">
		<table class="mytable">
			<tr>
				<td class="title" colspan="9">工作人员后台管理</td>
			</tr>
			<tr>
				<th>订单编号</th>
				<th>姓名</th>
				<th>电话</th>
				<th>产品名称</th>
				<th>需求</th>
				<th>地址</th>
				<th>上门时间</th>
				<th>状态</th>
				<th>备注</th>
			</tr>
			<%
				String order_page = null;
				if (request.getParameter("order_page") == null)
					order_page = "1";
				else
					order_page = request.getParameter("order_page");

				List<OrderBean> orders = OrderServices.GetPageAllOrder(Integer.parseInt(order_page));
				for (OrderBean o : orders) {
					out.print("<tr class='h'>");
					out.print("<td>" + o.getId() + "</td>");
					out.print("<td>" + o.getUser_name() + "</td>");
					out.print("<td>" + o.getUser_mobile() + "</td>");
					out.print("<td>" + o.getOrder_name() + "</td>");
					out.print("<td>" + o.getWant() + "</td>");
					out.print("<td>" + o.getUser_address() + "</td>");
					out.print("<td>" + o.getDate() + "</td>");
					switch (o.getStatus()) {
					case 1:
						out.print("<td>订单未审核</td>");
						break;
					case 2:
						out.print("<td>订单未付款</td>");
						break;
					case 3:
						out.print("<td>订单已完成</td>");
						break;
					default:
						out.print("<td>订单异常</td>");
					}
					out.print("<td>");
					switch (o.getStatus()) {
					case 1:
						out.print("等待管理员审核");
						break;
					case 2:
						out.print("");
						break;
					case 3:
						out.print("");
						break;
					default:
						out.print("订单异常");
					}
					out.print("</td>");
					out.print("</tr>");
				}
			%>
		</table>

		<div class="count">
			<%
				//本页所有行数
				int coun = orders.size();

				int coun_all = OrderServices.GetAllOrder().size();

				//当前页码
				int cpi = Integer.parseInt(order_page);
				//上一页
				int pcpi = ((cpi - 1) == 0) ? cpi : (cpi - 1);

				//尾页
				int lcpi = coun_all == AppUtil.fenye ? 1 :
						coun_all % AppUtil.fenye == 0 ? coun_all / AppUtil.fenye :
							(coun_all / AppUtil.fenye) + 1;
				//首页
				int icpi = 1;

				//下一页
				int ncpi = cpi == lcpi ? cpi : (cpi + 1);
				System.out.println("sahngyiye " + pcpi);
				//标准地址
				String cp = request.getRequestURI() + "?order_page=";

				out.print("共" + coun_all + "条记录，当前第 " + cpi + "页，共" + lcpi + "页");
			%>

			<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="<%out.print(cp + icpi);%>" aria-label="Previous">
							<span aria-hidden="true">首页</span>
					</a></li>
					<li><a href='<%out.print(cp + pcpi);%>'>上一页</a></li>
					<li><a href="<%out.print(cp + ncpi);%>">下一页</a></li>
					<li><a href="<%out.print(cp + lcpi);%>" aria-label="Next">
							<span aria-hidden="true">尾页</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
</body>
</html>