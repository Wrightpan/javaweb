package mvc_1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Lianjie {

private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&serverTimezone=CTT";
	// 用户名
	private static String dbUserName = "root";
	// 密码}
	private static String dbPassword = "030909";
	// 驱动名称
	private static String jdbcName = "com.mysql.cj.jdbc.Driver";
 
	public static void main(String[] args) {
		try {
			Class.forName(jdbcName);
			System.out.println("加载驱动成功！");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("加载驱动失败！");
		}
 
		Connection con = null;
		try {
			// 获取数据库连接
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			System.out.println("获取数据库连接成功！");
			System.out.println("进行数据库操作！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("获取数据库连接失败！");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
 
	

