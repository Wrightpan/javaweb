package admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import dao.UserDao;

@WebServlet(name="DeleteUserServlet", urlPatterns={"/DeleteUserServlet"})
public class DeleteUserServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");


		User user = new User();
	
		user.setId(Integer.valueOf(id));
	
		
		UserDao userDao = new UserDao();
		userDao.deleteUser(user);
		
		response.getWriter().println("Delete item successfully, jump to the administrator home page after 3 seconds");
		response.setHeader("Refresh", "3;url=" + request.getContextPath() + "/admin/show_user.jsp");
	}
}
