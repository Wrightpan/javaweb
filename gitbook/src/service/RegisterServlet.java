package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import dao.UserDao;


@WebServlet(name="RegisterServlet", urlPatterns={"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() + "/register.jsp");
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String introduce = request.getParameter("introduce");

		UserDao userDao = new UserDao();
		if (userDao.getUser(username) != null) {
			out.println("The user already exists, jump to the registration page after 5 seconds");
			response.addHeader("refresh", "5;url=" + request.getContextPath() + "/register.jsp");
			return;
		}
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setGender(gender);
		user.setEmail(email);
		user.setPhone(phone);
		user.setIntroduce(introduce);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		user.setRegistTime(dateFormat.format(new Date()));
		userDao.addUser(user);

		out.println("Registration is successful, jump to the login page after 5 seconds");
		response.addHeader("refresh", "5;url=" + request.getContextPath() + "/login.jsp");
	}
}
