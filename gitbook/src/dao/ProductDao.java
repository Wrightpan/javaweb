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

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import db.DataSourceUtils;
import domain.Product;
import domain.User;



public class ProductDao {
	
	public void addProduct(Product product) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "INSERT products (name, price, category, num, imgurl, description)"
				+ "value(?, ?, ?, ?, ?, ?)";
		Object[] params = {product.getName(), product.getPrice(),product.getCategory(),product.getNum(),product.getImgurl(),product.getDescription()};
		try {
			runner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*  PreparedStatement preparedStatement = null;
 		String sql = "INSERT products (name, price, category, num, imgurl, description)"
				+ "value(?, ?, ?, ?, ?, ?)";
		try {
			Connection connection = DataSourceUtils.getConnection();
			
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
		} */
	}
	
	public void updateProduct(Product product) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "UPDATE  products SET name = ?,price = ?,category = ?,num = ?,imgurl = ?,description = ? WHERE id =?";
		Object[] params = {product.getName(),product.getPrice(),product.getCategory(),product.getNum(),product.getImgurl(),product.getDescription(),product.getId()};
		try {
			runner.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*		 Connection connection = null;
        PreparedStatement preparedStatement = null;
		String sql = "UPDATE  products SET name = ?,price = ?,category = ?,num = ?,imgurl = ?,description = ? WHERE id =?";
				
		try {
			 connection = DataSourceUtils.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, product.getName());
			statement.setDouble(2, product.getPrice());
			statement.setString(3, product.getCategory());
			statement.setInt(4, product.getNum());
			statement.setString(5, product.getImgurl());
			statement.setString(6, product.getDescription());
			statement.setInt(7, product.getId());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}  */
	}
	
	
	public void deleteProduct(Product product) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "DELETE FROM products WHERE id = ?";
		try {
			runner.update(sql, product.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	/*	 Connection connection = null;
        PreparedStatement preparedStatement = null;
		String sql = "DELETE FROM products WHERE id = ?";
		try {
			 connection = DataSourceUtils.getConnection();
			 
			
			PreparedStatement statement = connection.prepareStatement(sql);
		
			statement.setInt(1, product.getId());
			
			statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} */
	}
	

	public List<Product> getAllProdut() {
		
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "SELECT * FROM products";
		List<Product> lists = null;
		try {
			 lists = runner.query(sql, new BeanListHandler<Product>(Product.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lists;
		/*List<Product> lists = null;
		
		try {
			 Connection connection = null;
	         PreparedStatement preparedStatement = null;
			
			String sql = "SELECT * FROM products";
			 connection = DataSourceUtils.getConnection();
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
		
		return lists;*/
	}
	
	
	public void updateProductNum(int id, int num) {
	/*	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "UPDATE products set num=" + num + " where id=" + id;
		try {
			runner.update(sql, product.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	try {
			 Connection connection = null;
	         PreparedStatement preparedStatement = null;
			
		 connection = DataSourceUtils.getConnection();
			String sql = "UPDATE products set num=" + num + " where id=" + id;
			
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public Product getProduct(int id) {
		Product product = null;
		 //Connection connection = null;
         //PreparedStatement preparedStatement = null;
		try {
			Connection connection = DataSourceUtils.getConnection();
			
	         PreparedStatement preparedStatement = null;
			String sql = "SELECT * from products where id=" + id;
			
            // connection = (Connection) DriverManager.getConnection(url,user,password);
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
	
	
	public Set<Product> getProductByCategory(String category) {
		Set<Product> set = null;
		
		try {
			 Connection connection = null;
	         PreparedStatement preparedStatement = null;
			
		
			String sql = "SELECT * FROM products";
			 connection = DataSourceUtils.getConnection();
			Statement statement = connection.createStatement();

			if (!category.equals("全部商品")) {
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
			
			String sql = "SELECT * FROM products WHERE name LIKE '%" + bookName + "%'";
			 connection = DataSourceUtils.getConnection();
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
	
	
	public Set<Product> getProductById(int id) {
		Set<Product> set = null;
		
		try {
			
			 Connection connection = null;
	         PreparedStatement preparedStatement = null;
			
			 connection = DataSourceUtils.getConnection();
             String sql = "SELECT * from products where id=" + id;
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
	



	
}
