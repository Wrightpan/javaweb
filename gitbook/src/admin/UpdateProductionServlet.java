package admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import dao.ProductDao;

@WebServlet(name="UpdateProductionServlet", urlPatterns={"/UpdateProductionServlet"})
public class UpdateProductionServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String category = request.getParameter("category");
		String num = request.getParameter("num");
		String imgurl = request.getParameter("imgurl");
		String description = request.getParameter("description");
		String id = request.getParameter("id");
		Product product = new Product();
		
		
		product.setName(name);
		product.setPrice(Double.valueOf(price));
		product.setCategory(category);
		product.setNum(Integer.valueOf(num));
		product.setDescription(description);
		product.setId(Integer.valueOf(id));
		
		ProductDao productDao = new ProductDao();
		productDao.updateProduct(product);
		
		response.getWriter().println("update item successfully, jump to the administrator home page after 3 seconds");
		response.setHeader("Refresh", "3;url=" + request.getContextPath() + "/admin/show_production.jsp");
	}
}
