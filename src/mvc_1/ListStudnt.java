package mvc_1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.IOException;
import java.sql.*;
import java.util.List;

@WebServlet(name = "ListStudent",urlPatterns = "/listStudent")
public class ListStudnt extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    // String id = request.getParameter("id");



        Studentdao studentdao = new Studentdao();
        try {
            List<Student> students = studentdao.getall();
            request.setAttribute("student", students);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        request.getRequestDispatcher("/student.jsp").forward(request,response);}
}
