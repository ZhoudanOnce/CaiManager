package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Enumeration;

import javax.servlet.http.HttpSession;

public class AppUtil {

	// 数据库连接字符串
	public static final String DriverClassName = "com.mysql.jdbc.Driver";
	public static final String DBIP = "106.13.105.44";
	public static final String DBURL = "jdbc:mysql://" + DBIP
			+ ":3306/saleservice?useUnicode=true&characterEncoding=UTF-8";
	public static final String DBUser = "root";
	public static final String DBPassword = "sdbixx";
	
	public static final int fenye = 6;

	// 获取数据库连接
	// 这个地方连接用完需要关闭
	public static Connection GetConnection() {
		System.out.println("正在连接:" + DBURL);
		try {
			Class.forName(DriverClassName);
			Connection connect = DriverManager.getConnection(DBURL, DBUser, DBPassword);
			return connect;
		} catch (Exception e) {
			return null;
		}
	}
	// 获取图片方法

	// session设置错误信息
	public static void SetMessage(HttpSession session, String msg) {
		session.setAttribute("alert", msg);
	}

	// 遍历清空所有session
	public static void RemoveAllSessionAttr(HttpSession session) {
	}
}