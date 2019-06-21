package admin;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import domain.User;
import dao.UserDao;


/**
 * Servlet implementation class ShowSingleP
 */
@WebServlet("/ShowSingleU")
public class ShowSingleU extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		UserDao userDao = new UserDao();
		
		Set<User> set = userDao.getUserById(Integer.valueOf(id));
		
	//	productDao.getProduct(Integer.valueOf(id));
		
		
		
		request.setAttribute("userSet", set);
		
		request.getRequestDispatcher("/admin/show_singleu.jsp").forward(request, response);
	}

}
