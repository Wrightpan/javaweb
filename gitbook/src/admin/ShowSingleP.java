package admin;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import dao.ProductDao;

/**
 * Servlet implementation class ShowSingleP
 */
@WebServlet("/ShowSingleP")
public class ShowSingleP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		ProductDao productDao = new ProductDao();
		
		Set<Product> set = productDao.getProductById(Integer.valueOf(id));
		
	//	productDao.getProduct(Integer.valueOf(id));
		
		
		
		request.setAttribute("productSet", set);
		
		request.getRequestDispatcher("/admin/show_singlep.jsp").forward(request, response);
	}

}
