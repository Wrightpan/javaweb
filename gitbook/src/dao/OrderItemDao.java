package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;

import db.DataSourceUtils;
import domain.OrderItem;
//import util.DataSourceUtils;


public class OrderItemDao {

	public void addOrderItem(OrderItem orderItem) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "INSERT orderitem (order_id, product_id, buynum)"
				+ "value(?, ?, ?)";
		Object[] params = {orderItem.getOrderId(),orderItem.getProductId(),orderItem.getBuyNum()};
		try {
			runner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		/*try {
			
			// Connection connection = null;
	         PreparedStatement preparedStatement = null;		
			
			Connection connection = DataSourceUtils.getConnection();

			String sql = "INSERT orderitem (order_id, product_id, buynum)"
					+ "value(?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery(sql);			
			statement.setString(1, orderItem.getOrderId());
			statement.setInt(2, orderItem.getProductId());
			statement.setInt(3, orderItem.getBuyNum());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} */
}
