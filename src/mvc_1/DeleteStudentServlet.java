package mvc_1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");


        try
        {   Studentdao studentdao = new Studentdao();
            studentdao.deleteByid(Integer.parseInt(id));

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/success.jsp").forward(request,response);
    }
}
