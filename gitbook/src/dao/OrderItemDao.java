package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import util.DataSourceUtils;

/*
 * 璁㈠崟涓潯鐩被鎿嶄綔绫�
 * @author: luoxn28
 * @date: 2016.5.18
 */
public class OrderItemDao {
	/*
	 * 寰�璁㈠崟鏉＄洰orderitem琛ㄤ腑鎻掑叆涓�鏉¤鍗曟潯鐩�
	 * @param OrderItem
	 * @return void
	 */
	public void addOrderItem(OrderItem orderItem) {
		try {
			 Connection connection = null;
	         PreparedStatement preparedStatement = null;
			//String sql = "SELECT * from products where id=" + id;
			 String url = "jdbc:mysql://127.0.0.1:3306/book_store?useSSL=false&serverTimezone=CTT";
             String user = "root";
             String password = "030909";


             Class.forName("com.mysql.cj.jdbc.Driver");
             connection = (Connection) DriverManager.getConnection(url,user,password);
			//Connection connection = DataSourceUtils.getConnection();
			String sql = "INSERT orderitem (order_id, product_id, buynum)"
					+ "value(?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, orderItem.getOrderId());
			statement.setInt(2, orderItem.getProductId());
			statement.setInt(3, orderItem.getBuyNum());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
