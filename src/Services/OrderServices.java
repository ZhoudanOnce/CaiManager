package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Bean.OrderBean;
import Bean.OrderLimit;
import Util.AppUtil;

public class OrderServices {

	// 添加订单
	public static boolean AddOrder(String name, String date, String want, int userid) throws SQLException {
		String sql = "insert into sale_order(order_name,date,want,userid) \r\n" + "VALUES (\"" + name + "\",\"" + date
				+ "\",\"" + want + "\"," + userid + ")";

		System.out.println(sql);
		Connection con = AppUtil.GetConnection();// 获取数据库连接
		Statement st = con.createStatement();// 提供了向数据库发送执行语句和获取结果的方法
		return st.executeUpdate(sql) == 1;// executeUpdate 的返回值是一个整数，指示受影响的行数（即更新计数）
	}

	// 删除订单
	public static boolean DeleteOrder(int orderid) throws SQLException {
		String sql = "delete from sale_order where id = " + orderid;
		Connection con = AppUtil.GetConnection();
		Statement st = con.createStatement();
		return st.executeUpdate(sql) == 1;
	}

	// 付款
	public static boolean OrderSetMoney(int orderid) throws SQLException {
		String sql = "update sale_order set order_status = 3 where id =" + orderid;
		Connection con = AppUtil.GetConnection();
		Statement st = con.createStatement();
		return st.executeUpdate(sql) == 1;
	}

	// 查询所有订单
	public static List<OrderBean> GetAllOrder() throws SQLException {
		String sql = "select a.id,a.order_name,a.date,a.want,a.order_status,"
				+ "b.USER_NAME,b.USER_MOBILE,b.USER_ADDRESS from sale_order a inner"
				+ " join sale_user b on a.userid = b.USER_ID";
		System.out.println(sql);
		Connection con = AppUtil.GetConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		List<OrderBean> orders = new ArrayList<>();
		while (rs.next()) {
			orders.add(new OrderBean(rs.getInt("id"), rs.getString("order_name"), rs.getString("date"),
					rs.getString("want"), rs.getInt("order_status"), rs.getString("USER_NAME"),
					rs.getString("USER_MOBILE"), rs.getString("USER_ADDRESS")));
		}
		rs.close();
		st.close();
		con.close();
		System.out.println("666:"+orders.size());
		return orders;
	}

	// 根据用户id查询订单
	public static List<OrderBean> GetOrder(int userid) throws SQLException {
		String sql = "select a.id,a.order_name,a.date,a.want,a.order_status" + " from sale_order a inner"
				+ " join sale_user b on a.userid = b.USER_ID WHERE b.USER_ID = " + userid;

		System.out.println(sql);

		Connection con = AppUtil.GetConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		List<OrderBean> orders = new ArrayList<>();
		while (rs.next()) {
			OrderBean sOrderBean = new OrderBean();
			sOrderBean.setId(rs.getInt("id"));
			sOrderBean.setOrder_name(rs.getString("order_name"));
			sOrderBean.setDate(rs.getString("date"));
			sOrderBean.setWant(rs.getString("want"));
			sOrderBean.setStatus(rs.getInt("order_status"));
			orders.add(sOrderBean);
		}
		rs.close();
		st.close();
		con.close();
		return orders;
	}

	// 根据维修设备名称查询订单
	public static List<OrderBean> GetOrderWant(String orderwant) throws SQLException {
		String sql = "select a.id,a.order_name,a.date,a.want,a.order_status,\r\n"
				+ "			b.USER_NAME,b.USER_MOBILE,b.USER_ADDRESS from sale_order a inner\r\n"
				+ "				 join sale_user b on a.userid = b.USER_ID where a.want = \"" + orderwant + "\"";

		System.out.println(sql);

		Connection con = AppUtil.GetConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		List<OrderBean> orders = new ArrayList<>();
		while (rs.next()) {
			orders.add(new OrderBean(rs.getInt("id"), rs.getString("order_name"), rs.getString("date"),
					rs.getString("want"), rs.getInt("order_status"), rs.getString("USER_NAME"),
					rs.getString("USER_MOBILE"), rs.getString("USER_ADDRESS")));
		}
		rs.close();
		st.close();
		con.close();
		return orders;
	}
	// 根据 “维修 保养 还是 安装”和“空调 。。。”查询订单
	public static List<OrderBean> GetOrderWant(String orderwant, String ordername) throws SQLException {
		String sql = "select a.id,a.order_name,a.date,a.want,a.order_status,\r\n"
				+ "			b.USER_NAME,b.USER_MOBILE,b.USER_ADDRESS from sale_order a inner\r\n"
				+ "				 join sale_user b on a.userid = b.USER_ID where a.want = \"" + orderwant + "\" "
				+ "and a.order_name like \"%" + ordername + "%\"";

		System.out.println(sql);

		Connection con = AppUtil.GetConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		List<OrderBean> orders = new ArrayList<>();
		while (rs.next()) {
			orders.add(new OrderBean(rs.getInt("id"), rs.getString("order_name"), rs.getString("date"),
					rs.getString("want"), rs.getInt("order_status"), rs.getString("USER_NAME"),
					rs.getString("USER_MOBILE"), rs.getString("USER_ADDRESS")));
		}
		rs.close();
		st.close();
		con.close();
		return orders;
	}

	// 只查询 关于页面的限制条件的订单
	public static List<OrderBean> GetPageAllOrder(int page) throws SQLException {
		String sql = " select a.*,b.* from sale_order a inner join sale_user b on a.userid = b.USER_ID  ORDER BY date desc limit " + AppUtil.fenye + " OFFSET "
				+ (page-1) * AppUtil.fenye;
		System.err.println(sql);
		Connection con = AppUtil.GetConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		List<OrderBean> orders = new ArrayList<>();
		while (rs.next()) {
			orders.add(new OrderBean(rs.getInt("id"), rs.getString("order_name"), rs.getString("date"),
					rs.getString("want"), rs.getInt("order_status"), rs.getString("USER_NAME"),
					rs.getString("USER_MOBILE"), rs.getString("USER_ADDRESS")));
		}
		rs.close();
		st.close();
		con.close();
		return orders;
	}

	// 查询符合限制条件的订单
	public static List<OrderBean> GetOrderLimit(OrderLimit limit) throws SQLException {

		String want = "维修";
		switch (limit.order_type) {
		case "weixiu":
			want = "维修";
			break;
		case "anzhuang":
			want = "安装";
			break;
		case "baoyang":
			want = "保养";
			break;
		}

		System.err.println(limit.order_page + " 666");

		String sql = "select a.id,a.order_name,a.date,a.want,a.order_status,\r\n"
				+ "			b.USER_NAME,b.USER_MOBILE,b.USER_ADDRESS from sale_order a inner\r\n"
				+ "				 join sale_user b on a.userid = b.USER_ID where a.want = \"" + want + "\" "
				+ "and a.order_name like \"%" + limit.order_name + "%\"" + "LIMIT 6 OFFSET "
				+ (6 * (Integer.parseInt(limit.order_page) - 1));

		System.err.println(sql);

		Connection con = AppUtil.GetConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		List<OrderBean> orders = new ArrayList<>();
		while (rs.next()) {
			orders.add(new OrderBean(rs.getInt("id"), rs.getString("order_name"), rs.getString("date"),
					rs.getString("want"), rs.getInt("order_status"), rs.getString("USER_NAME"),
					rs.getString("USER_MOBILE"), rs.getString("USER_ADDRESS")));
		}
		rs.close();
		st.close();
		con.close();
		return orders;
	}

	// 查询 限制条件下所有行数
	public static int GetOrderLimitAllCount(OrderLimit limit) throws SQLException {
		String want = "维修";
		switch (limit.order_type) {
		case "weixiu":
			want = "维修";
			break;
		case "anzhuang":
			want = "安装";
			break;
		case "baoyang":
			want = "保养";
			break;
		}
		String sql = "select count(a.id)  from sale_order a inner\r\n"
				+ "				 join sale_user b on a.userid = b.USER_ID where a.want = \"" + want + "\" "
				+ "and a.order_name like \"%" + limit.order_name + "%\"";

		System.err.println(sql);

		Connection con = AppUtil.GetConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		rs.next();
		int count = rs.getInt(1);
		rs.close();
		st.close();
		con.close();
		return count;
	}

	/*
	 * // 查询订单 查询本页下所有的行数 public static List<OrderBean>
	 * GetOrderLimitCount(OrderLimit limit) throws SQLException {
	 * 
	 * String want = "维修"; switch (limit.order_type) { case "weixiu": want = "维修";
	 * break; case "anzhuang": want = "安装"; break; case "baoyang": want = "保养";
	 * break; }
	 * 
	 * String sql = "select a.id,a.order_name,a.date,a.want,a.order_status,\r\n" +
	 * "			b.USER_NAME,b.USER_MOBILE,b.USER_ADDRESS from sale_order a inner\r\n"
	 * + "				 join sale_user b on a.userid = b.USER_ID where a.want = \""
	 * + want + "\" " + "and a.order_name like \"%" + limit.order_name + "%\"";
	 * 
	 * System.out.println(sql);
	 * 
	 * Connection con = AppUtil.GetConnection(); Statement st =
	 * con.createStatement(); ResultSet rs = st.executeQuery(sql); List<OrderBean>
	 * orders = new ArrayList<>(); while (rs.next()) { orders.add(new
	 * OrderBean(rs.getInt("id"), rs.getString("order_name"), rs.getString("date"),
	 * rs.getString("want"), rs.getInt("order_status"), rs.getString("USER_NAME"),
	 * rs.getString("USER_MOBILE"), rs.getString("USER_ADDRESS"))); } rs.close();
	 * st.close(); con.close(); return orders; }
	 */

	// 审核
	public static boolean ShenHe(int orderid) throws SQLException {
		String sql = "update sale_order set order_status = 2 where id = " + orderid;
		Connection con = AppUtil.GetConnection();
		Statement st = con.createStatement();
		return st.executeUpdate(sql) == 1;
	}
}
