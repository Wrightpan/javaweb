package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import db.DataSourceUtils;
import domain.User;

public class Userdaoimpl2 extends DAO<User> implements Userdao2{
	public void addUser(User user) {
		String sql = "INSERT user (username, password, gender, email, phone, introduce, activeCode, state, role, registTime)"
				+ "value(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		update(sql,user.getUsername(),user.getPassword(),user.getGender(),user.getEmail(),user.getPhone(),user.getIntroduce(),user.getActiveCode(),user.getState(),user.getRole(),user.getRegistTime());
		
	}
	public void deleteUser(Integer id) {
		String sql = "DELETE FROM user WHERE ID = ?";
		update(sql,id);
		
	}
	
	public void updateUser(User user) {
		String sql = "UPDATE user SET username = ?,password = ? ,email = ?,phone = ?,introduce = ?,activecode = ?,state = ?,role = ?,RegistTime=? WHERE id =?";
		update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getPhone(),user.getIntroduce(),user.getActiveCode(),user.getState(),user.getRole(),user.getRegistTime());
	}
	public User getUser(String username) {
		String sql = "SELECT * from user where username='" + username + "'";
		return getForValue(sql, username);
		
	}
	
	
	public User getUser(Integer id) {
		String sql = "SELECT * from user where id=" + id;
		return get(sql, id); 
			 
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
	
	
	
	public List<User> getAllUser() {
		
		String sql = "SELECT * from user";
		return getForList(sql);
		
	}


	
}
