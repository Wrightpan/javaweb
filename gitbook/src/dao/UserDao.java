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
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import db.DataSourceUtils;
import domain.User;
public class UserDao {
	
	public void addUser(User user) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "INSERT user (username, password, gender, email, phone, introduce, activeCode, state, role, registTime)"
				+ "value(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {user.getUsername(),user.getPassword(),user.getGender(),user.getEmail(),user.getPhone(),user.getIntroduce(),user.getActiveCode(),user.getState(),user.getRole(),user.getRegistTime()};
		try {
			runner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		/*try {
			 
	         PreparedStatement preparedStatement = null;
			
			
			Connection connection = DataSourceUtils.getConnection();
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
		} */
	}
	public void deleteUser(User user) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "DELETE FROM user WHERE ID = ?";
		try {
			runner.update(sql, user.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			// Connection connection = null;
	         PreparedStatement preparedStatement = null;
			
		    Connection connection = DataSourceUtils.getConnection();
			String sql = "DELETE FROM user WHERE ID = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, user.getId());
			
			statement.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} */
	}
	
	public void updateUser(User user) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "UPDATE user SET username = ?,password = ? ,email = ?,phone = ?,introduce = ?,activecode = ?,state = ?,role = ?,RegistTime=? WHERE id =?";
		Object[] params = {user.getUsername(),user.getPassword(),user.getEmail(),user.getPhone(),user.getIntroduce(),user.getActiveCode(),user.getState(),user.getRole(),user.getRegistTime()};
		try {
			runner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			 Connection connection = null;
	         PreparedStatement preparedStatement = null;
			
		   connection = DataSourceUtils.getConnection();
			String sql = "UPDATE user SET username = ?,password = ? ,email = ?,phone = ?,introduce = ?,activecode = ?,state = ?,role = ?,RegistTime=? WHERE id =?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			//statement.setString(3, user.getGender());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPhone());
			statement.setString(5, user.getIntroduce());
			statement.setString(6, user.getActiveCode());
			statement.setInt(7, user.getState());
			statement.setString(8, user.getRole());
			statement.setString(9, user.getRegistTime());
			statement.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}*/
	}
	
public List<User> getAllUser() {
		
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user";
		List<User> users = null;
		try {
			 users = runner.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
		
	}

	
	/*	List<User> users = null;
		
		try {
			 Connection connection = null;
	         PreparedStatement preparedStatement = null;
		
			connection = DataSourceUtils.getConnection();
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
	} */
	
	
	public User getUser(String username) {
	/*	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "SELECT * from user where username='" + username + "'";
		Object[] params = {username};
		try {
			User user = runner.query(sql, params, new BeanHandler<User>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/	
		User user = null;
		
		try {
			 Connection connection = null;
	        
		 connection = DataSourceUtils.getConnection();
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
	
	
	public User getUser(int id) {
		
	/*	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "SELECT * from user where id=" + id;
		
		try {
			 //@SuppressWarnings("deprecation")
			User user = runner.query(sql, id, new BeanHandler<User>(User.class));
		return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		User user = null;
		
		try {
			 Connection connection = null;
	         PreparedStatement preparedStatement = null;
			
		connection = DataSourceUtils.getConnection();
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
	
	
	public Set<User> getUserById(int id) {
		Set<User> set = null;
		
		try {
			
			 Connection connection = null;
	         PreparedStatement preparedStatement = null;
			
			
			connection = DataSourceUtils.getConnection();
             String sql = "SELECT * from user where id=" + id;
			Statement statement = connection.createStatement();

			set = new LinkedHashSet<User>();
			ResultSet resultSet = statement.executeQuery(sql);
			
			if (resultSet.next()) {
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
				set.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return set;
	} 
}
	
	
	
	

