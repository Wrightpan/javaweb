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




public class ProductDao {
	
	public void addProduct(Product product) {
		 Connection connection = null;
         PreparedStatement preparedStatement = null;
 		String sql = "INSERT products (name, price, category, num, imgurl, description)"
				+ "value(?, ?, ?, ?, ?, ?)";
		try {
			//Connection connection = DataSourceUtils.getConnection();
			 String url = "jdbc:mysql://127.0.0.1:3306/book_store?useSSL=false&serverTimezone=CTT";
             String user = "root";
             String password = "030909";


             Class.forName("com.mysql.cj.jdbc.Driver");
             connection = (Connection) DriverManager.getConnection(url,user,password);
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, product.getName());
			statement.setDouble(2, product.getPrice());
			statement.setString(3, product.getCategory());
			statement.setInt(4, product.getNum());
			statement.setString(5, product.getImgurl());
			statement.setString(6, product.getDescription());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public Product getProduct(int id) {
		Product product = null;
		 //Connection connection = null;
         //PreparedStatement preparedStatement = null;
		try {
			//Connection connection = DataSourceUtils.getConnection();
			 Connection connection = null;
	         PreparedStatement preparedStatement = null;
			String sql = "SELECT * from products where id=" + id;
			 String url = "jdbc:mysql://127.0.0.1:3306/book_store?useSSL=false&serverTimezone=CTT";
             String user = "root";
             String password = "030909";


             Class.forName("com.mysql.cj.jdbc.Driver");
             connection = (Connection) DriverManager.getConnection(url,user,password);
           //  preparedStatement = connection.prepareStatement(sql);

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				product = new Product();
				product.setId(id);
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setCategory(resultSet.getString("category"));
				product.setNum(resultSet.getInt("num"));
				product.setImgurl(resultSet.getString("imgurl"));
				product.setDescription(resultSet.getString("description"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return product;
	}
	
	
	public void updateProductNum(int id, int num) {
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
			String sql = "UPDATE products set num=" + num + " where id=" + id;
			
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Set<Product> getProductByCategory(String category) {
		Set<Product> set = null;
		
		try {
			 Connection connection = null;
	         PreparedStatement preparedStatement = null;
			
			 String url = "jdbc:mysql://127.0.0.1:3306/book_store?useSSL=false&serverTimezone=CTT";
             String user = "root";
             String password = "030909";


             Class.forName("com.mysql.cj.jdbc.Driver");
             connection = (Connection) DriverManager.getConnection(url,user,password);
			String sql = "SELECT * FROM products";
			//Connection connection = DataSourceUtils.getConnection();
			Statement statement = connection.createStatement();

			if (!category.equals("閸忋劑鍎撮崯鍡楁惂")) {
				sql += " where category='" + category + "'";
			}
			set = new LinkedHashSet<Product>();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setCategory(resultSet.getString("category"));
				product.setNum(resultSet.getInt("num"));
				product.setImgurl(resultSet.getString("imgurl"));
				product.setDescription(resultSet.getString("description"));
				set.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return set;
	}
	
	
	public Set<Product> getProductBySearchName(String bookName) {
		Set<Product> set = null;
		
		try {
			
			 Connection connection = null;
	         PreparedStatement preparedStatement = null;
			//String sql = "SELECT * from products where id=" + id;
			 String url = "jdbc:mysql://127.0.0.1:3306/book_store?useSSL=false&serverTimezone=CTT";
             String user = "root";
             String password = "030909";


             Class.forName("com.mysql.cj.jdbc.Driver");
             connection = (Connection) DriverManager.getConnection(url,user,password);
			String sql = "SELECT * FROM products WHERE name LIKE '%" + bookName + "%'";
			//Connection connection = DataSourceUtils.getConnection();
			Statement statement = connection.createStatement();

			set = new LinkedHashSet<Product>();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setCategory(resultSet.getString("category"));
				product.setNum(resultSet.getInt("num"));
				product.setImgurl(resultSet.getString("imgurl"));
				product.setDescription(resultSet.getString("description"));
				set.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return set;
	}

	public List<Product> getAllProdut() {
		List<Product> lists = null;
		
		try {
			 Connection connection = null;
	         PreparedStatement preparedStatement = null;
			//String sql = "SELECT * from products where id=" + id;
			 String url = "jdbc:mysql://127.0.0.1:3306/book_store?useSSL=false&serverTimezone=CTT";
             String user = "root";
             String password = "030909";


             Class.forName("com.mysql.cj.jdbc.Driver");
             connection = (Connection) DriverManager.getConnection(url,user,password);
			String sql = "SELECT * FROM products";
			//Connection connection = DataSourceUtils.getConnection();
			Statement statement = connection.createStatement();

			lists = new ArrayList<Product>();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setCategory(resultSet.getString("category"));
				product.setNum(resultSet.getInt("num"));
				product.setImgurl(resultSet.getString("imgurl"));
				product.setDescription(resultSet.getString("description"));
				lists.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lists;
	}
}
