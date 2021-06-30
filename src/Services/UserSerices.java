package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Bean.UserBean;
import Util.AppUtil;

public class UserSerices {

	// 获取所有普通用户
	public static List<UserBean> GetAllUsers() throws SQLException {
		Connection conn = AppUtil.GetConnection();
		Statement st = conn.createStatement();
		String sql = "select * from sale_user where USER_TYPE = '2'";
		ResultSet rs = st.executeQuery(sql);
		List<UserBean> users = new ArrayList<UserBean>();
		//遍历数据库
		while (rs.next()) {
			UserBean user = new UserBean();
			user.setUser_id(rs.getInt("USER_ID"));
			user.setUser_name(rs.getString("USER_NAME"));
			user.setUser_sex(rs.getString("USER_SEX"));
			user.setUser_birthday(rs.getString("USER_BIRTHDAY"));
			user.setUser_email(rs.getString("USER_EMAIL"));
			user.setUser_mobile(rs.getString("USER_MOBILE"));
			user.setUser_address(rs.getString("USER_ADDRESS"));
			users.add(user);
		}
		rs.close();
		st.close();
		conn.close();
		return users;
	}
	


	// 模糊查询 用户
	public static List<UserBean> GetAllUsers(String user_name) throws SQLException {
		Connection conn = AppUtil.GetConnection();
		Statement st = conn.createStatement();
		String sql = "select * from sale_user where USER_TYPE = '2' and USER_NAME like '%" + user_name + "%'";
		ResultSet rs = st.executeQuery(sql);
		List<UserBean> users = new ArrayList<UserBean>();
		while (rs.next()) {
			UserBean user = new UserBean();
			user.setUser_id(rs.getInt("USER_ID"));
			user.setUser_name(rs.getString("USER_NAME"));
			user.setUser_sex(rs.getString("USER_SEX"));
			user.setUser_birthday(rs.getString("USER_BIRTHDAY"));
			user.setUser_email(rs.getString("USER_EMAIL"));
			user.setUser_mobile(rs.getString("USER_MOBILE"));
			user.setUser_address(rs.getString("USER_ADDRESS"));
			users.add(user);
		}
		rs.close();
		st.close();
		conn.close();
		return users;
	}

	// 删除用户 危险操作 这时候也把该用户的订单删了
	public static void DeleteUser(int Userid) throws SQLException {
		Connection conn = AppUtil.GetConnection();
		Statement st = conn.createStatement();
		String sql = "delete from sale_user  where USER_ID = " + Userid;
		st.execute(sql);
		sql = "delete from sale_order where userid = " + Userid;
		st.execute(sql);
		st.close();
		conn.close();
	}

	// 修改用户信息
	public static void Update(UserBean u) throws SQLException {
		Connection conn = AppUtil.GetConnection();
		Statement st = conn.createStatement();
		String sql = "update sale_user set USER_SEX = '" + u.getUser_sex() + "' where USER_ID = '" + u.getUser_id() + "'";
		st.executeUpdate(sql);
		sql = "update sale_user set USER_PASSWORD = '" + u.getUser_password() + "' where USER_ID = '" + u.getUser_id()+"'";
		System.out.println(sql);
		st.executeUpdate(sql);
		sql = "update sale_user set USER_BIRTHDAY = '" + u.getUser_birthday() + "' where USER_ID = '" + u.getUser_id()+"'";
		System.out.println(sql);
		st.executeUpdate(sql);
		sql = "update sale_user set USER_EMAIL = '" + u.getUser_email() + "' where USER_ID = '" + u.getUser_id()+"'";
		st.executeUpdate(sql);
		sql = "update sale_user set USER_MOBILE = '" + u.getUser_mobile() + "' where USER_ID = '" + u.getUser_id()+"'";
		st.executeUpdate(sql);
		sql = "update sale_user set USER_ADDRESS = '" + u.getUser_address() + "' where USER_ID = '" + u.getUser_id()+"'";
		st.executeUpdate(sql);
		st.close();
		conn.close();
	}

}
