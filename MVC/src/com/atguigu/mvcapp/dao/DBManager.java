package com.atguigu.mvcapp.dao;


//import java.sql.Connection;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.Properties;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
 
public class DBManager {
	private static final String configFile = "dbcp.properties";
 
	private static DataSource dataSource;
 
	static {
		Properties dbProperties = new Properties();
		try {
			dbProperties.load(DBManager.class.getClassLoader().getResourceAsStream(configFile));
			dataSource = BasicDataSourceFactory.createDataSource(dbProperties);
 
			Connection conn = getConn();
			DatabaseMetaData mdm = conn.getMetaData();
 
			System.out.println("Connected to " + mdm.getDatabaseProductName() + " " + mdm.getDatabaseProductVersion());
			if (conn != null) {
				conn.close();
			}
 
		} catch (Exception e) {
			System.out.println("��ʼ�����ӳ�ʧ��:" + e);
		}
	}
 
	private DBManager() {
 
	}
 
	public static final Connection getConn() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (Exception e) {
			System.out.println("��ȡ���ݿ�����ʧ��:" + e);
		}
		return conn;
	}
 
	//�ر����ݿ����ӣ������ӷ��������ݿ����ӳ�
	public static void closeConn(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.setAutoCommit(true);
				conn.close();
			}
		} catch (Exception e) {
			System.out.println("�ر����ݿ�����ʧ�ܣ�" + e);
		}
	}
 
	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			Connection conn = DBManager.getConn();
			System.out.println(i + "��������");
			DBManager.closeConn(conn);
		}
		long end = System.currentTimeMillis();
		System.out.println("��ʱ��" + (end - begin));
	}
}


