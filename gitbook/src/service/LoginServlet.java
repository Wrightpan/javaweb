package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User;
import dao.UserDao;


@WebServlet(name="LoginServlet", urlPatterns={"/LoginServlet"})
public class LoginServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao userDao = new UserDao();
		
		User user = userDao.getUser(username);
		if (user == null) {
			
			response.addHeader("refresh", "2;url=" + request.getContextPath() + "/client/register.jsp");
			return;
		}
		else if (!user.getPassword().equals(password)) {
			
			response.addHeader("refresh", "2;url=" + request.getContextPath() + "/login.jsp");
			return;
		}
		else if (user.getState() == 0) {
			
			response.addHeader("refresh", "2;url=" + request.getContextPath() + "/login.jsp");
			return;
		}

		
		request.getSession().setAttribute("user" + user.getId(), user);
		
		Cookie cookie = new Cookie("user", String.valueOf(user.getId()));
		response.addCookie(cookie);
		
		
		String role = user.getRole();
		if (role.equals("admin")) {
			response.sendRedirect(request.getContextPath() + "/admin/index.jsp");
			return;
		}
		else {
			response.sendRedirect(request.getContextPath() + "/index1.jsp");
		}
	}
}
