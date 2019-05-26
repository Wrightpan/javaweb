package mvc_1;

//import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;

/**
 * Servlet implementation class Student
 */
@WebServlet("/Student")
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	
	public int getid(){
		//this.id=id;
		return id;
       }
	public void setid(int id) {
		this.id = id;
	}
    public String getusername(){
    	//this.username = username;
    	return username;
    }
    public void setusername(String username) {
		this.username = username;
	}
    public String getpassword(){
        //this.password = password;
		return password;
    }
    public void setpassword(String password) {
		this.password= password;
	}
    @Override
    public String toString() {
    	return "Student [id = "+ id +",username ="+ username +", password = "+ password +"]";
    }
    public Student(Integer id,String username,String password)
    {
        
        this.id=id;
        this.username = username;
        this.password = password;
    }
    public Student(){
    	super();
    }


}

