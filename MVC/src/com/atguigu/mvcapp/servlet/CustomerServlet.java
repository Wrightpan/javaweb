package com.atguigu.mvcapp.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.mvcapp.dao.CriteriaCustomer;
import com.atguigu.mvcapp.dao.CustomerDAO;
import com.atguigu.mvcapp.dao.factory.CustomerDAOFactory;
import com.atguigu.mvcapp.dao.impl.CustomerDAOXMLImpl;
import com.atguigu.mvcapp.domain.Customer;


public class CustomerServlet extends HttpServlet {


	private CustomerDAO customerDAO = 
			CustomerDAOFactory.getInstance().getCustomerDAO();
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		String method = request.getParameter("method");
//		
//		switch(method){
//			case "add":    add(request, response); break;
//			case "query":  query(request, response); break;
//			case "delete": delete(request, response); break;
//			case "update": update(request, response); break;
//		}
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//1. 获取 ServletPath: /edit.do 或 /addCustomer.do
		String servletPath = req.getServletPath();

		//2. 去除 / 和 .do, 得到类似于 edit 或 addCustomer 这样的字符串
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0, methodName.length() - 3);
		
		try {
			//3. 利用反射获取 methodName 对应的方法
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, 
					HttpServletResponse.class);
			//4. 利用反射调用对应的方法
			method.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			//可以有一些响应.
			resp.sendRedirect("error.jsp");
		}
		
	}

	private void edit(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException{
		
		String forwardPath = "/error.jsp";
		
		//1. 获取请求参数 id
		String idStr = request.getParameter("id");
		
		//2. 调用 CustomerDAO 的 customerDAO.get(id) 获取和 id 对应的 Customer 对象 customer
		try {
			Customer customer = customerDAO.get(Integer.parseInt(idStr));
			if(customer != null){
				forwardPath = "/updatecustomer.jsp";
				//3. 将 customer 放入 request 中
				request.setAttribute("customer", customer);
			}
		} catch (NumberFormatException e) {} 
		
		
		//4. 响应 updatecustomer.jsp 页面: 转发.
		request.getRequestDispatcher(forwardPath).forward(request, response);
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		//1. 获取表单参数: id, name, address, phone, oldName
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String oldName = request.getParameter("oldName");
		
		//2. 检验 name 是否已经被占用:
		
		//2.1 比较 name 和 oldName 是否相同, 若相同说明 name 可用. 
		//2.1 若不相同, 则调用 CustomerDAO 的 getCountWithName(String name) 获取 name 在数据库中是否存在
		if(!oldName.equalsIgnoreCase(name)){
			long count = customerDAO.getCountWithName(name);
			//2.2 若返回值大于 0, 则响应 updatecustomer.jsp 页面: 通过转发的方式来响应 newcustomer.jsp
			if(count > 0){
				//2.2.1 在 updatecustomer.jsp 页面显示一个错误消息: 用户名 name 已经被占用, 请重新选择!
				//在 request 中放入一个属性 message: 用户名 name 已经被占用, 请重新选择!, 
				//在页面上通过 request.getAttribute("message") 的方式来显示
				request.setAttribute("message", "用户名" + name + "已经被占用, 请重新选择!");
				
				//2.2.2 newcustomer.jsp 的表单值可以回显. 
				//address, phone 显示提交表单的新的值, 而 name 显示 oldName, 而不是新提交的 name
				
				//2.2.3 结束方法: return 
				request.getRequestDispatcher("/updatecustomer.jsp").forward(request, response);
				return;
			}
		}
		
		//3. 若验证通过, 则把表单参数封装为一个 Customer 对象 customer
		Customer customer = new Customer(name, address, phone);
		customer.setId(Integer.parseInt(id)); 
		
		//4. 调用 CustomerDAO 的  update(Customer customer) 执行更新操作
		customerDAO.update(customer);
		
		//5. 重定向到 query.do
		response.sendRedirect("query.do");
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//获取模糊查询的请求参数
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		//把请求参数封装为一个 CriteriaCustomer 对象
		CriteriaCustomer cc = new CriteriaCustomer(name, address, phone);
		
		//1. 调用 CustomerDAO 的 getForListWithCriteriaCustomer() 得到 Customer 的集合
		List<Customer> customers = customerDAO.getForListWithCriteriaCustomer(cc);
		
		//2. 把 Customer 的集合放入 request 中
		request.setAttribute("customers", customers);
		
		//3. 转发页面到 index.jsp(不能使用重定向)
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idStr = request.getParameter("id");
		int id = 0;
		
		//try ... catch 的作用: 防止 idStr 不能转为 int 类型
		//若不能转则 id = 0, 无法进行任何的删除操作. 
		try {
			id = Integer.parseInt(idStr);
			System.out.println(id); 
			customerDAO.delete(id);
		} catch (Exception e) {}
		
		response.sendRedirect("query.do");
	}

	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//1. 获取表单参数: name, address, phone
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		//2. 检验 name 是否已经被占用:
		
		//2.1 调用 CustomerDAO 的 getCountWithName(String name) 获取 name 在数据库中是否存在
		long count = customerDAO.getCountWithName(name);
		
		//2.2 若返回值大于 0, 则响应 newcustomer.jsp 页面: 
		//通过转发的方式来响应 newcustomer.jsp
		if(count > 0){
			//2.2.1 要求再 newcustomer.jsp 页面显示一个错误消息: 用户名 name 已经被占用, 请重新选择!
			//在 request 中放入一个属性 message: 用户名 name 已经被占用, 请重新选择!, 
			//在页面上通过 request.getAttribute("message") 的方式来显示
			request.setAttribute("message", "用户名" + name + "已经被占用, 请重新选择!");
			
			//2.2.2 newcustomer.jsp 的表单值可以回显. 
			//通过 value="<%= request.getParameter("name") == null ? "" : request.getParameter("name") %>"
			//来进行回显
			//2.2.3 结束方法: return 
			request.getRequestDispatcher("/newcustomer.jsp").forward(request, response);
			return;
		}
		
		//3. 若验证通过, 则把表单参数封装为一个 Customer 对象 customer
		Customer customer = new Customer(name, address, phone);
		
		//4. 调用 CustomerDAO 的  save(Customer customer) 执行保存操作
		customerDAO.save(customer);
		
		//5. 重定向到 success.jsp 页面: 使用重定向可以避免出现表单的重复提交问题.  
		response.sendRedirect("success.jsp");
		//request.getRequestDispatcher("/success.jsp").forward(request, response);
	}

}
