package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

//import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DataSourceUtils {
	private static Properties MyDB = new Properties();
	     private static DataSource dataSource;
	     
	     static{
	         try{
	            FileInputStream is = null;  
	            String path = Thread.currentThread().getContextClassLoader().getResource  ("dbcp.properties").getPath();
                is = new FileInputStream(path);
	            MyDB.load(is);
	         }catch(IOException e){
	             e.printStackTrace();
	         }
	         
	       
	         try{
	             dataSource = BasicDataSourceFactory.createDataSource(MyDB);
	         }catch(Exception e){
	             e.printStackTrace();
	         }
	     }
	 	public static DataSource getDataSource() {
			return dataSource;
		}
	     
	     public static Connection getConnection(){
	         Connection connection = null;
	         try{
	             connection = dataSource.getConnection();
	         }catch(SQLException e){
	             e.printStackTrace();
	         }
	         try {
	             connection.setAutoCommit(false);
	         } catch (SQLException e) {
	             e.printStackTrace();
	         }
	         return connection;
	     }
	     
	    
	     public static void releaseConnection(Connection connection){
	 		try {
	 			if(connection != null){
	 				connection.close();
	 			}
	 		} catch (Exception e) {
	 			e.printStackTrace();
	 		}
	 	}
	
}
