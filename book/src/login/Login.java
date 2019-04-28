package login;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
//import java.io.IOException;
import java.io.PrintWriter;
//import java.rmi.ServerException;
/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private ServletConfig servletConfig;

	    @Override
	    public ServletConfig getServletConfig() {
	        return servletConfig;
	    }

	    @Override
	    public String getServletInfo() {
	        return null;
	    }

	    @Override
	    public void destroy() {

	    }

	    @Override
	    public void init(ServletConfig servletConfig) throws ServletException {
	        this.servletConfig=servletConfig;
	    }

	    public void service
	            (ServletRequest request, ServletResponse response)
	        throws ServerException ,IOException, ServletException{
	        String username =request.getParameter("username");
	        String password =request.getParameter("password");

	        ServletContext servletContext =servletConfig.getServletContext();
	        String initUser = servletContext.getInitParameter("user");
	        String initPassword= servletContext.getInitParameter("password");
	        
	      PrintWriter out = response.getWriter();
	        
	        if(initUser.equals(username) && initPassword.equals(password))
	        {
	           //out.print("hello:"+ username);正确界面
	        	 request.getRequestDispatcher("index.html").forward(request, response);
	        }
	        else{
	            out.print("sorry:" + username);
	        }
	    }
	}