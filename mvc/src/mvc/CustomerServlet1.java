package mvc;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerServlet1
 */
@WebServlet("*.do" )
public class CustomerServlet1 extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO = new CustomerDAOImpl();
    //private CustomerDAO customerDAO = new CustomerJdbcDAOImpl();

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
 
        //1.鑾峰彇servletPath锛�/add.do 鎴� /delete.do绛�
        String servletPath = req.getServletPath();
 
        //2.鍙栧嚭/鍜�.do寰楀埌鏂规硶鍚�
        String methodName = servletPath.substring(1);
        methodName = methodName.substring(0, methodName.length() - 3);
 
        //3.鍒╃敤鍙嶅皠鑾峰彇methodName瀵瑰簲鐨勬柟娉�
        Method method = null;
        try {
 
            method = getClass().getDeclaredMethod(methodName,
                    HttpServletRequest.class, HttpServletResponse.class);
            //4.鍒╃敤鍙戝皠璋冪敤瀵瑰簲鐨勬柟娉�
            method.invoke(this, req, resp);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
 
    }
 
    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add");
        //1.鑾峰彇娣诲姞鐨勯【瀹㈢殑淇℃伅
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
 
        long count = CustomerDAO.getCountWithName(name);
        if(count > 0){
            req.setAttribute("message", "鐢ㄦ埛鍚�" + name + "宸茶鍗犵敤");
 
            req.getRequestDispatcher("/newCustomer.jsp").forward(req, resp);
            return;
        }
 
        //2.鍒涘缓涓�涓狢ustomer瀵硅薄
        Customer customer = new Customer(0, name, address, phone);
 
        CustomerDAO.save(customer);
 
        //鑻ユ坊鍔犳垚鍔燂紝鍒欓噸瀹氬悜鍒版垚鍔熼〉闈�
        resp.sendRedirect("success.jsp");
 
    }
 
    private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("query");
        //鑾峰彇妯＄硦鏌ヨ鐨勮姹傚弬鏁�
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
 
        //鎶婅姹傚弬鏁板皝瑁呬负涓�涓狢riteriaCustomer瀵硅薄
        CriteriaCustomer cc = new CriteriaCustomer(name, address, phone);
        //1.璋冪敤CustomerDAOImpl绫荤殑getForListWithCriteriaCustomer鏂规硶
        List<Customer> customers = customerDAO.getForListWithCriteriaCustomer(cc);
 
        //2.鎶奵ustomers鏀惧叆req涓�
        req.setAttribute("customers", customers);
 
        //3.杞彂鍒癷ndex.jsp
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
       //璋冪敤customerDAO鐨刧et(int id)鑾峰彇鍜宨d瀵瑰簲鐨凜ustomer瀵硅薄customer
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
            //褰撳悕瀛楄鍗犵敤鏃�
            if(count>0) {
                req.setAttribute("message", "鐢ㄦ埛鍚嶏細" + name + "宸茶鍗犵敤锛岃閲嶆柊閫夋嫨");
 
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
