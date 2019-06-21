package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import db.DataSourceUtils;
import domain.Order;
//import com.mchange.v2.c3p0.ComboPooledDataSource;

public class OrderDao {
	
	public void addOrder(Order order) {
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "INSERT orders (id, money, receiveAddress, receiveName, receivePhone, orderTime, user_id)"
				+ "value(?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {order.getId(),order.getMoney(),order.getReceiveAddress(),order.getReceiveName(),order.getReceivePhone(),order.getOrderTime(),order.getUserId()};
		try {
			runner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			Connection connection = DataSourceUtils.getConnection();
			//Connection connection = null;
            PreparedStatement preparedStatement = null;
			String sql = "INSERT orders (id, money, receiveAddress, receiveName, receivePhone, orderTime, user_id)"
					+ "value(?, ?, ?, ?, ?, ?, ?)";
			           
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, order.getId());
			statement.setDouble(2, order.getMoney());
			statement.setString(3, order.getReceiveAddress());
			statement.setString(4, order.getReceiveName());
			statement.setString(5, order.getReceivePhone());
		
			statement.setString(6, order.getOrderTime());
			statement.setInt(7, order.getUserId());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}   */
	}
	
	
	public Set<Order> getOrderById(int id) {
		Set<Order> set = null;
		
		try {
			
			 Connection connection = null;
	         PreparedStatement preparedStatement = null;
			
			//String sql = "SELECT * FROM products WHERE name LIKE '%" + bookName + "%'";
			 connection = DataSourceUtils.getConnection();
             String sql = "SELECT * from orders where user_id=" + id;
			Statement statement = connection.createStatement();

			set = new LinkedHashSet<Order>();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				Order order = new Order();
				order.setId(resultSet.getString("id"));
				order.setMoney(resultSet.getDouble("money"));
				order.setReceiveAddress(resultSet.getString("receiveAddress"));
				order.setReceiveName(resultSet.getString("receiveName"));
				order.setReceivePhone(resultSet.getString("receivePhone"));
				order.setOrderTime(resultSet.getString("orderTime"));
				//order.setDescription(resultSet.getString("description"));
				set.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return set;
	}
	
}