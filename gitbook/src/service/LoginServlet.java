package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import dao.UserDao;


@WebServlet(name="LoginServlet", urlPatterns={"/LoginServlet"})
public class LoginServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	


		response.sendRedirect(request.getContextPath() + "/login.jsp");
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String userName=request.getParameter("username");
		HttpSession session1 = request.getSession();
		session1.setAttribute("username", userName);
		
		
		PrintWriter out = response.getWriter();
		
		
		response.setContentType("text/html;charset=utf-8");  
        
        
        HttpSession session = request.getSession(false);  
        if(session == null) {  
            out.print("Verification code is invalid!After 5 seconds, transfer to the login page.");        	
			response.addHeader("refresh", "5;url=" + request.getContextPath() + "/login.jsp");
            return;  
        }  
          
        String saveCode = (String)session.getAttribute("check_code");  
        if(saveCode == null) {  
            out.print("Verification code is invalid!After 5 seconds, transfer to the login page.");        	
        	response.addHeader("refresh", "5;url=" + request.getContextPath() + "/login.jsp");
            return;  
        }  
          
        String checkCode = request.getParameter("check_code");  
        if(!saveCode.equals(checkCode)) {  
            out.print("Verification code is invalid!After 5 seconds, transfer to the login page.");        	
            response.addHeader("refresh", "5;url=" + request.getContextPath() + "/login.jsp");
            return;  
        }  
          
        session.removeAttribute("check_code");  
      
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao userDao = new UserDao();
		
		User user = userDao.getUser(username);
		if (user == null) {
			response.getWriter().println("Sorry, you are not registered yet, and you will be transferred to the registration page after 5 seconds.");
			response.addHeader("refresh", "5;url=" + request.getContextPath() + "/register.jsp");
			return;
		}
		else if (!user.getPassword().equals(password)) {
			response.getWriter().println("Sorry, the password is incorrect. After 5 seconds, transfer to the login page.");
			response.addHeader("refresh", "5;url=" + request.getContextPath() + "/login.jsp");
			return;
		}
		else if (user.getState() == 0) {
			response.getWriter().println("Sorry, you have not activated yet, please contact the administrator and transfer to the login page after 5 seconds.");
			response.addHeader("refresh", "5;url=" + request.getContextPath() + "/login.jsp");
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
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}
}
