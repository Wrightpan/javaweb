package service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Order;
import dao.OrderDao;
import domain.Product;
import util.ServletUtils;

@WebServlet("/CheckHistoryOrder")
public class CheckHistoryOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = ServletUtils.getCookie(request, "user");
		if (cookie == null) {
			response.getWriter().println("Sorry, you are not logged in yet, and you will be logged in to the login page after 5 seconds.");
			response.addHeader("refresh", "5;url=" + request.getContextPath() + "/login.jsp");
			return;
		}
		
		//HttpSession session = request.getSession();

		
		Order order = new Order();
		
		order.setUserId(Integer.valueOf(cookie.getValue()));
		
		OrderDao orderDao = new OrderDao();
		orderDao.getOrderById(Integer.valueOf(cookie.getValue()));
		
		response.sendRedirect(request.getContextPath() + "/checkhistoryorder.jsp");
		
	}

}
