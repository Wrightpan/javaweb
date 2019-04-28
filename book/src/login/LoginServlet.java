package login;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.pept.transport.Connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
//import javax.servlet.ServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException
			{
				String username = req.getParameter("username");
				String password = req.getParameter("passowrd");
				
				Connection connection = null;
				PreparedStatement statement = null;
				ResultSet resultset = null ;
				
				
				PrintWriter out = resp.getWriter();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc.mysql:///test";
					String user = "root";
					String password2 = "030909";
					connection = (Connection) DriverManager.getConnection(url,user,password2);
					
					String sql = "select count(id) from users where username = ?" +
							"password = ?";
					
					statement = ((java.sql.Connection) connection).prepareStatement(sql);
					statement.setString(1, username);
					statement.setString(2, password);
					
					resultset = statement.executeQuery();
					
					if(resultset.next())
					{
						int count = resultset.getInt(1);
						if (count > 0) {
							out.print("hello:" + username);
						}else {
							out.print("sorry:" + username);
						}
					}
				}catch (Exception e){
					e.printStackTrace();
				}finally
				{
					try {
						if(resultset != null) {
							resultset.close();
						}
					}catch(SQLException e) {
						e.printStackTrace();
					}
					try {
						if(statement!= null) {
							statement.close();
						}
					}catch(SQLException e) {
						e.printStackTrace();
					}
					if(connection != null) {
						connection.close();
					}
					
				}
				
			
			}
}