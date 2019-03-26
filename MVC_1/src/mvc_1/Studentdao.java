package mvc_1;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;



@WebServlet("/Studentdao")
public class Studentdao extends HttpServlet {
        public List<Student> getall(){
		List<Student> students = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
                        String driverClass = "com.mysql.jdbc.Driver";
                        String url = "jdbc.mysql:///test";
                        String user = "root";
                        String password = "030909";
                         

                         Class.forname(driverClass);
                     connection = DriverManager.getConnection("jdbc.mysql:///test","root","030909");

                        String sql = "select id,username,password from users";

                        preparedStatement = connection.prepareStatement(sql);
       

                        resultSet = preparedStatement.executeQuery();

                        while(resultSet.next()){
                        	int id = resultSet.getInt(1);
                        	String username = resultSet.getString(2);
                        	String password1 = resultSet.getString(2);
                            
                        	Student student = new Student(id,username,password1);
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
