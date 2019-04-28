package MVCCases;
 
import com.mchange.v2.c3p0.ComboPooledDataSource;
 
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
 
public class jdbcUtils {
 
    public static void release(Connection connection){
 
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
 
    private static DataSource dataSource = null;//数据源
 
    static {
        //数据源只能被创建一次
        dataSource = new ComboPooledDataSource("mvcapp");
    }
 
    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }
 
 
}
