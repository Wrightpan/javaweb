package mvc_1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListStudent
 */
@WebServlet("/listStudent")
public class ListStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // String id = request.getParameter("id");


      
           Studentdao studentdao = new Studentdao();
            try {
				List<Student> students = studentdao.getall();
				request.setAttribute("student", students);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        
       
        request.getRequestDispatcher("/student.jsp").forward(request,response);
    }

}
