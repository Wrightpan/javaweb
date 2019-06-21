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

import com.mchange.v2.c3p0.ComboPooledDataSource;

import db.DataSourceUtils;
import domain.User;
public interface  Userdao2 {
	
	public void addUser(User user);
	public void deleteUser(Integer id);
	public void updateUser(User user);
	public User getUser(String username);
	public User getUser(Integer id);
	
	
	public Set<User> getUserById(int id);
	
	public List<User> getAllUser();
	
}

