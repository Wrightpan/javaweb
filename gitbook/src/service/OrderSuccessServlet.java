package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="OrderSuccessServlet", urlPatterns={"/OrderSuccessServlet"})
public class OrderSuccessServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.doPost(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("Hello, has been paid successfully, return to the home page after 5 seconds");
		response.addHeader("refresh", "5;url=" + request.getContextPath() + "/index.jsp");
	}
}
