package test;
import java.sql.SQLException;
import java.util.List;

import Bean.OrderBean;
import Services.OrderServices;


public class OrderServicesTest {
	public static void main(String[] args) throws SQLException {
		List<OrderBean>  a = OrderServices.GetAllOrder();
		System.out.println(a.size());
		
		
		//OrderServices.DeleteOrder(4);
		
		OrderBean bean = new OrderBean();
		bean.setDate("java date");
		bean.setOrder_name("java");
		bean.setWant("java want");
		
		
		
		
	}
}