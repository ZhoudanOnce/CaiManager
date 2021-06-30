package test;

import java.sql.SQLException;
import java.util.List;

import Bean.UserBean;
import Services.UserSerices;

public class UserSericesTest {

	public static void main(String[] args) {

		List<UserBean> users = null;

		try {
			users = UserSerices.GetAllUsers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(users.size());

	}

}
