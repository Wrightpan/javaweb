package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class OrderDao {
	
	public void addOrder(Order order) {
		try {
			//Connection connection = DataSourceUtils.getConnection();
			Connection connection = null;
            PreparedStatement preparedStatement = null;
			String sql = "INSERT orders (id, money, receiveAddress, receiveName, receivePhone, paystate, orderTime, user_id)"
					+ "value(?, ?, ?, ?, ?, ?, ?, ?)";
			 String url = "jdbc:mysql://127.0.0.1:3306/book_store?useSSL=false&serverTimezone=CTT";
             String user = "root";
             String password = "030909";


             Class.forName("com.mysql.cj.jdbc.Driver");
             connection = (Connection) DriverManager.getConnection(url,user,password);
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, order.getId());
			statement.setDouble(2, order.getMoney());
			statement.setString(3, order.getReceiceAddress());
			statement.setString(4, order.getRecviceName());
			statement.setString(5, order.getRecvicePhone());
			statement.setDouble(6, order.getPaystate());
			statement.setString(7, order.getOrderTime());
			statement.setInt(8, order.getUserId());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}