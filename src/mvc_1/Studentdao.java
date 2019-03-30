package mvc_1;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/Studentdao")
public class Studentdao extends HttpServlet  {
        public void deleteByid (Integer id) throws SQLException{
            Connection connection = null;
            PreparedStatement preparedStatement = null;
          //  ResultSet resultSet = null;

            try {
                String driverClass = "com.mysql.jdbc.Driver";
                String url = "jdbc.mysql:///test";
                String user = "root";
                String password = "030909";


                Class.forName("com.mysql.jdbc.Driver");
                connection = (Connection) DriverManager.getConnection(url,user,password);
                //connection = DriverManager.getConnection(url,user,password);

                String sql = "delete from customers where id = ? ";

                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setInt(1,id);

                preparedStatement.executeUpdate();


            }catch (Exception e){
                e.printStackTrace();}

            finally
            {

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


        }
        public List<Student> getall()throws SQLException{

		List<Student> students = new ArrayList<>();


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
                       // String driverClass = "com.mysql.jdbc.Driver";
                        String url = "jdbc.mysql://localhost:3306/test";
                        String user = "root";
                        String password = "030909";
                         

                         Class.forName("com.mysql.jdbc.Driver");
                     connection = DriverManager.getConnection(url);

                        String sql = "select id,username,password from users";

                        preparedStatement = connection.prepareStatement(sql);
       

                        resultSet = preparedStatement.executeQuery();

                        while(resultSet.next()){
                        	int id = resultSet.getInt(1);
                        	String username = resultSet.getString(2);
                        	String password1 = resultSet.getString(3);
                            Student student = new Student(id,username,password1);
                        	//Student student = new Student(id,username,password1);
                        	students.add(student);

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


            
                    return students;
                }

}
