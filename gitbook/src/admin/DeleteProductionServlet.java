package admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import dao.ProductDao;

@WebServlet(name="DeleteProductionServlet", urlPatterns={"/DeleteProductionServlet"})
public class DeleteProductionServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");


		Product product = new Product();
	
		product.setId(Integer.valueOf(id));
	
		
		ProductDao productDao = new ProductDao();
		
		productDao.deleteProduct(product);
		
		response.getWriter().println("Delete item successfully, jump to the administrator home page after 3 seconds");
		response.setHeader("Refresh", "3;url=" + request.getContextPath() + "/admin/show_production.jsp");
	}
}
