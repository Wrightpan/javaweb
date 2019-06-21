package admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import dao.ProductDao;

@WebServlet(name="AddProductionServlet", urlPatterns={"/AddProductionServlet"})
public class AddProductionServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String category = request.getParameter("category");
		String num = request.getParameter("num");
		String imgurl = request.getParameter("imgurl");
		String description = request.getParameter("description");

		Product product = new Product();
		product.setName(name);
		product.setPrice(Double.valueOf(price));
		product.setCategory(category);
		product.setNum(Integer.valueOf(num));
		product.setDescription(description);
		
		ProductDao productDao = new ProductDao();
		productDao.addProduct(product);
		
		response.getWriter().println("Add item successfully, jump to the administrator home page after 2 seconds");
		response.setHeader("Refresh", "2;url=" + request.getContextPath() + "/admin/index.jsp");
	}
}
