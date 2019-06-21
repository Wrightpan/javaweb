package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import dao.UserDao;



@WebServlet(name="UpdateUserServlet", urlPatterns={"/UpdateUserServlet"})
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String introduce = request.getParameter("introduce");
		String state = request.getParameter("state");
		String role = request.getParameter("role");
		String id = request.getParameter("id");
		
		User user = new User();
		
		user.setUsername(username);
		user.setPassword(password);
		user.setGender(gender);
		user.setEmail(email);
		user.setPhone(phone);
		user.setIntroduce(introduce);
		user.setState(Integer.valueOf(state));
		user.setRole(role);
		user.setId(Integer.valueOf(id));
		
		
		UserDao userDao = new UserDao();
		userDao.updateUser(user);
		
		response.getWriter().println("update item successfully, jump to the administrator home page after 3 seconds");
		response.setHeader("Refresh", "3;url=" + request.getContextPath() + "/admin/index.jsp");
	}
}
