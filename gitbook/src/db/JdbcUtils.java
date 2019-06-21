package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

//import db.DBManager;
//import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * JDBC 操作的工具类
 */
public class JdbcUtils {
	private static final String configFile = "dbcp.properties";
	/**
	 * 释放 Connection 连接
	 * @param connection
	 */
	public static void releaseConnection(Connection connection){
		try {
			if(connection != null){
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static DataSource dataSource = null;
	
	static{
		Properties MyDB = new Properties();
		try {
			dataSource = BasicDataSourceFactory.createDataSource(MyDB);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 返回数据源的一个 Connection 对象
	 * @return
	 * @throws SQLException  
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}

}
