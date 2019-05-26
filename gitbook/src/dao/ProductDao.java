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

import util.DataSourceUtils;

/*
 * 鍟嗗搧鎿嶄綔绫�
 * @author luoxn28
 * @date 2016.5.15
 */
public class ProductDao {
	/*
	 * 寰�鍟嗗搧products琛ㄤ腑鎻掑叆涓�鏉″晢鍝佽褰�
	 * @param Product
	 * @return void
	 */
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
	
	/*
	 * 鏍规嵁鍟嗗搧id鏌ユ壘璇ュ晢鍝佷俊鎭�
	 * @param id: 鍟嗗搧id
	 * @return Product锛屾湭鎵惧埌鏃惰繑鍥瀗ull
	 */
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
	
	/*
	 * 鏇存柊鏁版嵁琛ㄤ腑producct浣欓噺
	 * @param id: 鍟嗗搧id锛宯um:鍟嗗搧浣欓噺
	 * @return void
	 */
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
	
	/*
	 * 鏍规嵁鍟嗗搧绉嶇被鑾峰彇鍟嗗搧
	 * @param category 鍟嗗搧绉嶇被
	 * @return Set 璇ョ绫诲晢鍝侀泦鍚�
	 */
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

			if (!category.equals("鍏ㄩ儴鍟嗗搧")) {
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
	
	/*
	 * 鏍规嵁鍚嶇О鏌ユ壘鍟嗗搧锛屾湭鎵惧埌杩斿洖null
	 * @param bookName 鍟嗗搧鍚�
	 * @return 鍖呭惈璇ュ晢鍝佸悕鐨勫晢鍝侀泦鍚�
	 */
	public Set<Product> getProductBySearchName(String bookName) {
		Set<Product> set = null;
		
		try {
			// 浣跨敤閫氶厤绗︼紝鏁堢巼杈冧綆
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
	
	/*
	 * 鑾峰彇鎵�鏈夊晢鍝�
	 * @param void
	 * @return 鎵�鏈夊晢鍝丩ist
	 */
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
