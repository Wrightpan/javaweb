package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Product;
import dao.ProductDao;

@WebServlet(name="ShowProductServlet", urlPatterns={"/ShowProductServlet"})
public class ShowProductServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao productDao = new ProductDao();
		List<Product> products = productDao.getAllProdut();
		
		request.setAttribute("products", products);
		request.getRequestDispatcher("/admin/show_production.jsp").forward(request, response);
	}
}
