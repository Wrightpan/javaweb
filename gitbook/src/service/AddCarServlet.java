package service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Product;
import dao.ProductDao;
import dao.User;
import dao.UserDao;
import util.ServletUtils;


@WebServlet(name="AddCarServlet", urlPatterns={"/AddCarServlet"})
public class AddCarServlet  extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doPost(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Cookie cookie = ServletUtils.getCookie(request, "user");
		if (cookie == null) {
			response.getWriter().println("wrong");
			response.addHeader("refresh", "2;url=" + request.getContextPath() + "/login.jsp");
			return;
		}
		
	
		String id = request.getParameter("id");
	
		ProductDao productDao = new ProductDao();
		Product product = productDao.getProduct(Integer.valueOf(id));
		if (product == null) {
		
			return;
		}
		
	
		HttpSession session = request.getSession();
		Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart" + cookie.getValue());
		if (cart == null) {
			cart = new HashMap<Product, Integer>();
		}
	
		if (cart.containsKey(product)) {
			Integer num = cart.get(product);
			cart.put(product, num + 1);
		}
		else {
			cart.put(product, 1);
		}
		
		session.setAttribute("cart" + cookie.getValue(), cart);
		response.sendRedirect(request.getContextPath() + "/cart.jsp");
	}
}
