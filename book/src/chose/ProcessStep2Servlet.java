package chose;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chose.Customer;
@WebServlet("/ProcessStep2Servlet")
public class ProcessStep2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		          //1. 获取请求参数 name ,address ,cardType,card
	         request.setCharacterEncoding("UTF-8");
	        String name = request.getParameter("name");
	         String address = request.getParameter("address");
	         String cardType = request.getParameter("cardType");
		         String card = request.getParameter("card");
		        
		         Customer customer = new Customer(name, address, cardType, card);
		        
	        //2.把请求存储到Httpsession中
		          HttpSession  session = request.getSession();
		          session.setAttribute("customer", customer);
		        
		         //3.重定向到confirm.jsp
		          response.sendRedirect(request.getContextPath() + "/shoppingcart/confirm.jsp");
		     }

}
