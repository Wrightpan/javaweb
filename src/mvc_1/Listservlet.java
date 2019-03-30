package mvc_1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Listservlet")
public class Listservlet extends HttpServlet {
        private static final long serialVersionUID = 1L;


        protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        		throws ServletException, IOException{

        	Studentdao studentdao = new Studentdao();
        	List<Student> students = studentdao.getall();
                request.setAttribute("students",students);
                request.getRequestDispatcher("/student.jsp").forward(request, response);
        }


        }
