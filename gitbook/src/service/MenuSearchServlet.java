package service;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import dao.ProductDao;

@WebServlet(name="MenuSearchServlet", urlPatterns={"/MenuSearchServlet"})
public class MenuSearchServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String findBook = request.getParameter("findBook");
		if (findBook != null && findBook.length() > 0 && !findBook.equals("Please enter the title")) {
			ProductDao productDao = new ProductDao();
			Set<Product> set = productDao.getProductBySearchName(findBook);
			if (set != null) {
				request.setAttribute("productSet", set);
			}
		}
		request.getRequestDispatcher("/productList.jsp").forward(request, response);

		
	}
}
