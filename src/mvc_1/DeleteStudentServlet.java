package mvc_1;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "deleteStudent",urlPatterns = "/delete")
public class DeleteStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    String id = request.getParameter("id");



    Studentdao studentdao = new Studentdao();
            try {
        studentdao.deleteByid(Integer.parseInt(id));
    } catch (NumberFormatException | SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }



        request.getRequestDispatcher("/delete.jsp").forward(request,response);
}
}
