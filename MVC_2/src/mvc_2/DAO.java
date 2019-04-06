package mvc_2;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
 
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
 
public class DAO<T> {
 
    private QueryRunner queryRunner = new QueryRunner();
    private Class<T> clazz;
 
    public DAO() {
        clazz = ReflectionUtils.getSuperGenericType(getClass());
    }
 
    /**
     * 1.Create Retrieve Update Delete
     * INSERT UPDATE DELETE
     */
    public void update(String sql, Object ...args){
 
        Connection connection = null;
 
        try{
            connection = jdbcUtils.getConnection();
 
            queryRunner.update(connection, sql, args);
 
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
 
    /**
     * 2.查询,返回T的实例的对象
     */
    public T get(String sql, Object ...args){
 
        Connection connection = null;
 
        try{
 
            connection = jdbcUtils.getConnection();
            return queryRunner.query(connection, sql,new BeanHandler<>(clazz), args);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
 
    /**
     * 3.查询，返回T所对应的List<T>
     */
    public List<T> getForList(String sql, Object ...args){
 
        Connection connection = null;
 
        try{
 
            connection = jdbcUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
 
    /**
     *4.返回某个字段的值：如返回某一条记录的值，或返回数据表中有多少条记录
     */
    public <E> E getForValue(String sql, Object ...args){
 
        Connection connection = null;
 
        try{
 
            connection = jdbcUtils.getConnection();
            return (E) queryRunner.query(connection, sql,new ScalarHandler(), args);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
 
}
