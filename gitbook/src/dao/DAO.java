package dao;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import db.DataSourceUtils;
import db.ReflectionUtils;

/**
 * ��װ�˻����� CRUD �ķ���, �Թ�����̳�ʹ��
 * ��ǰ DAO ֱ���ڷ����л�ȡ���ݿ�����. 
 * ���� DAO ��ȡ DBUtils �������. 
 * @param <T>: ��ǰ DAO �����ʵ�����������ʲô
 */
public class DAO<T> {

	private QueryRunner queryRunner = new QueryRunner();
	
	private Class<T> clazz;
	
	public DAO() {
		
		clazz = ReflectionUtils.getSuperGenericType(getClass());
		
		
		
	}
	
	/**
	 * ����ĳһ���ֶε�ֵ�����緵��ĳһ����¼�� customerName, �򷵻����ݱ����ж�������¼��. 
	 * @param sql
	 * @param args
	 * @return
	 */
	public <E> E getForValue(String sql, Object ... args){
		Connection connection = null;
		
		try {
			connection = DataSourceUtils.getConnection();
			return (E) queryRunner.query(connection, sql, new ScalarHandler(), args);  
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DataSourceUtils.releaseConnection(connection);
		}
		return null;
	}
	
	/**
	 * ���� T ����Ӧ�� List 
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<T> getForList(String sql, Object ... args){
		
		Connection connection = null;
		
		try {
			connection = DataSourceUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DataSourceUtils.releaseConnection(connection);
		}
		
		return null;
	}
	
	/**
	 * ���ض�Ӧ�� T ��һ��ʵ����Ķ���. 
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(String sql, Object ... args){
		
		Connection connection = null;
		
		try {
			connection = DataSourceUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanHandler<>(clazz), args); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DataSourceUtils.releaseConnection(connection);
		}
		
		return null;
	}
	
	/**
	 * �÷�����װ�� INSERT��DELETE��UPDATE ����.
	 * @param sql: SQL ���
	 * @param args: ��� SQL ����ռλ��.
	 */
	public void update(String sql, Object ... args){
		Connection connection = null;
		
		try {
			connection = DataSourceUtils.getConnection();
			queryRunner.update(connection, sql, args); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DataSourceUtils.releaseConnection(connection);
		}
	}

}
