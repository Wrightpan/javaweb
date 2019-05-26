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

import util.DataSourceUtils;

/*
 * 鐢ㄦ埛绫绘搷浣滅被
 * @author: luoxn28
 * @date: 2016.5.13
 */
public class UserDao {
	/*
	 * 寰�user琛ㄤ腑鎻掑叆涓�涓敤鎴�
	 * @param User
	 * @return void
	 */
	public void addUser(User user) {
		try {
			 Connection connection = null;
	         PreparedStatement preparedStatement = null;
			//String sql = "SELECT * from products where id=" + id;
			 String url = "jdbc:mysql://127.0.0.1:3306/book_store?useSSL=false&serverTimezone=CTT";
             String user1 = "root";
             String password = "030909";


             Class.forName("com.mysql.cj.jdbc.Driver");
             connection = (Connection) DriverManager.getConnection(url,user1,password);
		//	Connection connection = DataSourceUtils.getConnection();
			String sql = "INSERT user (username, password, gender, email, phone, introduce, activeCode, state, role, registTime)"
					+ "value(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getGender());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getPhone());
			statement.setString(6, user.getIntroduce());
			statement.setString(7, user.getActiveCode());
			statement.setInt(8, user.getState());
			statement.setString(9, user.getRole());
			statement.setString(10, user.getRegistTime());
			statement.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 鏍规嵁鐢ㄦ埛鍚嶈幏鍙栨暟鎹簱涓鐢ㄦ埛璁板綍
	 * @param username
	 * @return User 鏈壘鍒版椂杩斿洖null
	 */
	public User getUser(String username) {
		User user = null;
		
		try {
			 Connection connection = null;
	         //String sql = "SELECT * from products where id=" + id;
			 String url = "jdbc:mysql://127.0.0.1:3306/book_store?useSSL=false&serverTimezone=CTT";
             String user1 = "root";
             String password = "030909";


             Class.forName("com.mysql.cj.jdbc.Driver");
             connection = (Connection) DriverManager.getConnection(url,user1,password);
			//Connection connection = DataSourceUtils.getConnection();
			String sql = "SELECT * from user where username='" + username + "'";
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setGender(resultSet.getString("gender"));
				user.setEmail(resultSet.getString("email"));
				user.setPhone(resultSet.getString("phone"));
				user.setIntroduce(resultSet.getString("introduce"));
				user.setActiveCode(resultSet.getString("activeCode"));
				user.setState(resultSet.getInt("state"));
				user.setRole(resultSet.getString("role"));
				user.setRegistTime(resultSet.getString("registTime"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	/*
	 * 鏍规嵁鐢ㄦ埛id鑾峰彇鏁版嵁搴撲腑璇ョ敤鎴疯褰�
	 * @param id 鐢ㄦ埛id
	 * @return User 璇ョ敤鎴峰搴旓紝鏈壘鍒拌繑鍥瀗ull
	 */
	public User getUser(int id) {
		User user = null;
		
		try {
			 Connection connection = null;
	         PreparedStatement preparedStatement = null;
			//String sql = "SELECT * from products where id=" + id;
			 String url = "jdbc:mysql://127.0.0.1:3306/book_store?useSSL=false&serverTimezone=CTT";
             String user1 = "root";
             String password = "030909";


             Class.forName("com.mysql.cj.jdbc.Driver");
             connection = (Connection) DriverManager.getConnection(url,user1,password);
			//Connection connection = DataSourceUtils.getConnection();
			String sql = "SELECT * from user where id=" + id;
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setGender(resultSet.getString("gender"));
				user.setEmail(resultSet.getString("email"));
				user.setPhone(resultSet.getString("phone"));
				user.setIntroduce(resultSet.getString("introduce"));
				user.setActiveCode(resultSet.getString("activeCode"));
				user.setState(resultSet.getInt("state"));
				user.setRole(resultSet.getString("role"));
				user.setRegistTime(resultSet.getString("registTime"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	/*
	 * 鑾峰彇鎵�鏈夌敤鎴�
	 * @param void
	 * @return User 鎵�鏈夌敤鎴�
	 */
	public List<User> getAllUser() {
		List<User> users = null;
		
		try {
			 Connection connection = null;
	         PreparedStatement preparedStatement = null;
			//String sql = "SELECT * from products where id=" + id;
			 String url = "jdbc:mysql://127.0.0.1:3306/book_store?useSSL=false&serverTimezone=CTT";
             String user1 = "root";
             String password = "030909";


             Class.forName("com.mysql.cj.jdbc.Driver");
             connection = (Connection) DriverManager.getConnection(url,user1,password);
			//Connection connection = DataSourceUtils.getConnection();
			String sql = "SELECT * from user";
			
			users = new ArrayList<User>();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setGender(resultSet.getString("gender"));
				user.setEmail(resultSet.getString("email"));
				user.setPhone(resultSet.getString("phone"));
				user.setIntroduce(resultSet.getString("introduce"));
				user.setActiveCode(resultSet.getString("activeCode"));
				user.setState(resultSet.getInt("state"));
				user.setRole(resultSet.getString("role"));
				user.setRegistTime(resultSet.getString("registTime"));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}
}
