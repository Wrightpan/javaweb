package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User;
import dao.UserDao;



@WebServlet(name="AddUserServlet", urlPatterns={"/AddUserServlet"})
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String introduce = request.getParameter("introduce");
		String state = request.getParameter("state");
		String role = request.getParameter("role");

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setGender(gender);
		user.setEmail(email);
		user.setPhone(phone);
		user.setIntroduce(introduce);
		user.setState(Integer.valueOf(state));
		user.setRole(role);
		
		
		
		UserDao userDao = new UserDao();
		userDao.addUser(user);
		
		response.getWriter().println("Add item successfully, jump to the administrator home page after 2 seconds");
		response.setHeader("Refresh", "2;url=" + request.getContextPath() + "/admin/index.jsp");
	}
}
