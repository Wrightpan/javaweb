package service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Order;
import dao.OrderDao;
import domain.OrderItem;
import dao.OrderItemDao;
//import dao.OrderItemDao;
import domain.Product;
import dao.ProductDao;
import util.ServletUtils;


@WebServlet(name="CreateOrderServlet", urlPatterns={"/CreateOrderServlet"})
public class CreateOrderServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		Cookie cookie = ServletUtils.getCookie(request, "user");
		if (cookie == null) {
			response.getWriter().println("Sorry, you are not logged in yet, and you will be logged in to the login page after 5 seconds.");
			response.addHeader("refresh", "5;url=" + request.getContextPath() + "/login.jsp");
			return;
		}
		
		HttpSession session = request.getSession();
		Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart" + cookie.getValue());
		if (cart == null) {
			response.getWriter().println("Sorry, your current shopping cart is empty and transferred to the homepage after 5 seconds.");
			response.addHeader("refresh", "5;url=" + request.getContextPath() + "/index.jsp");
			return;
		}
		
		String receiveAddress = request.getParameter("address");
		String receiveName = request.getParameter("name");
		String receivePhone = request.getParameter("phone");
		
		
		
		Order order = new Order();
		
		order.setId(String.valueOf(UUID.randomUUID()));
		double totalMoney = 0.0;
		for (Product product : cart.keySet()) {
			totalMoney += product.getPrice() * cart.get(product);
		}
		order.setMoney(totalMoney);
		order.setReceiveAddress(receiveAddress);
		order.setReceiveName(receiveName);
		order.setReceivePhone(receivePhone);
		//order.setPaystate(0);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String orderTime = dateFormat.format(new Date());
		order.setOrderTime(orderTime);
		order.setUserId(Integer.valueOf(cookie.getValue()));
	
		OrderDao orderDao = new OrderDao();
		orderDao.addOrder(order);
		
		
		ProductDao productDao = new ProductDao();
		OrderItemDao orderItemDao = new OrderItemDao();
		for (Product product : cart.keySet()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setOrderId(order.getId());
			orderItem.setProductId(product.getId());
			orderItem.setBuyNum(cart.get(product));
			
			orderItemDao.addOrderItem(orderItem);
		
			productDao.updateProductNum(product.getId(), product.getNum() - cart.get(product));
		}
		cart.clear();
		response.sendRedirect(request.getContextPath() + "/createOrderSuccess.jsp");
	}
}
