package mvc_1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Student
 */
@WebServlet("/Student")
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private  int id;
       private  String username;
       private  String password;
       public void getid(){
           this.id = id;
       }
    public void getusername(){
        this.username = username ;
    }
    public void getpassword(){
        this.password= password;
    }

    public Student(Integer id,String username,String password)
    {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public Student(){

    }


}
