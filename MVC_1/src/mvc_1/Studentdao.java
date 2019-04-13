package mvc_1;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/Studentdao")
public class Studentdao extends HttpServlet  {
        /**
	 * 
	 */

	private static final long serialVersionUID = 1L;
		public void deleteByid (Integer id) throws SQLException{
            Connection connection = null;
            PreparedStatement preparedStatement = null;
          //  ResultSet resultSet = null;
            String sql = "delete from users where id = ? ";
            try {
               // String driverClass = "com.mysql.cj.jdbc.Driver";
                String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&serverTimezone=CTT";
                String user = "root";
                String password = "030909";


                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = (Connection) DriverManager.getConnection(url,user,password);
                //connection = DriverManager.getConnection(url,user,password);

                //String sql = "delete from users where id = ? ";

                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setInt(1,id);

                preparedStatement.executeUpdate();

                //return connection;
            }catch (Exception e){
                e.printStackTrace();}

            finally
            {

                
                    if(preparedStatement!= null) {
                    	try {  preparedStatement.close();
                    
                }catch(SQLException e) {
                    e.printStackTrace();
                } 
                    }if(connection != null) {
                try {connection.close();
            }catch (SQLException e) {
            	e.printStackTrace();
            }
                
                    }


            }


        }
        public   List<Student> getall()throws SQLException{

		List<Student> list = new ArrayList<Student>();


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
                       // String driverClass = "com.mysql.cj.jdbc.Driver";
                        String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&serverTimezone=CTT";
                        String user = "root";
                        String password = "030909";
                         

                         Class.forName("com.mysql.cj.jdbc.Driver");
                     connection = DriverManager.getConnection(url,user,password);

                        String sql = "select id,username,password from users";

                        preparedStatement = connection.prepareStatement(sql);
       

                        resultSet = preparedStatement.executeQuery();

                        while(resultSet.next()){
                        	int id = resultSet.getInt(1);
                        	String username = resultSet.getString(2);
                        	String password1 = resultSet.getString(3);
                            Student student = new Student(id,username,password1);
                        	//Student student = new Student(id,username,password1);
                        	list.add(student);
                        	//return (List<Student>) student ;
                     
                        }
                    }catch (Exception e){
                            e.printStackTrace();}

                    finally
                                {
                                try {
                                        if(resultSet != null) {
                                             resultSet.close();
                                }
                                 }catch(SQLException e) {
                                        e.printStackTrace();
                                }
                                try {
                                         if(preparedStatement!= null) {
                                        preparedStatement.close();
                                }
                                }catch(SQLException e) {
                                        e.printStackTrace();
                                } if(connection != null) {
                                        connection.close();
                                 }
                                
                                

                                }


            
                    return list;
                }

}

