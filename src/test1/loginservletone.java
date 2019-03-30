package test1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.corba.se.pept.transport.Connection;

import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Servlet implementation class loginservletone
 */
@WebServlet("/loginservletone")
public class loginservletone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservletone() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException
			{
				String username = req.getParameter("username");
				String password = req.getParameter("passowrd");
				
				Connection connection = null;
				PreparedStatement statement = null;
				ResultSet resultset = null  ;
				
				
				PrintWriter out = resp.getWriter();
				
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					//String url = "jdbc.mysql:///test";
					//String user = "root";
					//String password2 = "030909";
					connection = (Connection) DriverManager.getConnection("jdbc.mysql:///test","root","030909");
					
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
