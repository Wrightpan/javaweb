package MVCCases;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
 
public class CustomerServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 CustomerDAO customerDAO = null;
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //super.doGet(req, resp);
        doPost(req, resp);
    }
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //super.doPost(req, resp);
 
        //1.获取servletPath：/add.do 或 /delete.do等
        String servletPath = req.getServletPath();
 
        //2.取出/和.do得到方法名
        String methodName = servletPath.substring(1);
        methodName = methodName.substring(0, methodName.length() - 3);
 
        //3.利用反射获取methodName对应的方法
        Method method = null;
        try {
 
            method = getClass().getDeclaredMethod(methodName,
                    HttpServletRequest.class, HttpServletResponse.class);
            //4.利用发射调用对应的方法
            method.invoke(this, req, resp);
 
        } catch (Exception e) {
           
        }
 
 
    }
 
    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add");
        //1.获取添加的顾客的信息
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
 
        long count = CustomerDAO.getCountWithName(name);
        if(count > 0){
            req.setAttribute("message", "用户名" + name + "已被占用");
 
            req.getRequestDispatcher("/newCustomer.jsp").forward(req, resp);
            return;
        }
 
        //2.创建一个Customer对象
        Customer customer = new Customer( name, address, phone);
 
        CustomerDAO.save(customer);
 
        //若添加成功，则重定向到成功页面
        resp.sendRedirect("success.jsp");
 
    }
 
    private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("query");
        //获取模糊查询的请求参数
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
 
        //把请求参数封装为一个CriteriaCustomer对象
        CriteriaCustomer cc = new CriteriaCustomer(name, address, phone);
       
		//1.调用CustomerDAOImpl类的getForListWithCriteriaCustomer方法
        List<Customer> customers = customerDAO.getForListWithCriteriaCustomer(cc);
 
        //2.把customers放入req中
        req.setAttribute("customers", customers);
 
        //3.转发到index.jsp
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
 
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("delete");
        String idStr = req.getParameter("id");
       int deleteId = 0;
 
       try{
           deleteId = Integer.parseInt(idStr);
          
		customerDAO.delete(deleteId);
 
       }catch(Exception e){
           e.printStackTrace();
       }
 
       resp.sendRedirect("query.do");
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
 
       String id = req.getParameter("id");
 
       String forwardPath = "error.jsp";
       //调用customerDAO的get(int id)获取和id对应的Customer对象customer
       Customer customer = customerDAO.get(Integer.parseInt(id));
       if(customer != null){
           forwardPath = "/updateCustomer.jsp";
           req.setAttribute("customer", customer);
       }
 
       req.getRequestDispatcher(forwardPath).forward(req, resp);
 
   }
   private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String idStr = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String oldName = req.getParameter("oldName");
 
        if(!oldName.equalsIgnoreCase(name)){
            long count = CustomerDAO.getCountWithName(name);
            //当名字被占用时
            if(count>0) {
                req.setAttribute("message", "用户名：" + name + "已被占用，请重新选择");
 
                req.getRequestDispatcher("/updateCustomer.jsp").forward(req, resp);
                return;
            }
        }
        Customer customer = new Customer(0, name, address, phone);
        customer.setId(Integer.parseInt(idStr));
 
        customerDAO.update(customer);
 
        resp.sendRedirect("query.do");
 
    }
}
