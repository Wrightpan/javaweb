package mvc_2;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
 
public class Usersservlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsersDAO UsersDAO = new UsersDAOImpl();

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
        String methodusername = servletPath.substring(1);
        methodusername = methodusername.substring(0, methodusername.length() - 3);
 
        //3.利用反射获取methodusername对应的方法
        Method method = null;
        try {
 
            method = getClass().getDeclaredMethod(methodusername,
                    HttpServletRequest.class, HttpServletResponse.class);
            //4.利用发射调用对应的方法
            method.invoke(this, req, resp);
 
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
            }
 
 
    }
 
    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add");
    }
 
    private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取模糊查询的请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
       
        //把请求参数封装为一个CriteriaUsers对象
        CriteriaUsers cc = new CriteriaUsers(username, password);
        //1.调用UsersDAOImpl类的getForListWithCriteriaUsers方法
        List<Users> Users = UsersDAO.getForListWithCriteriaUsers(cc);
 
        //2.把Userss放入req中
        req.setAttribute("Users", Users);
 
        //3.转发到index.jsp
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
 
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String idStr = req.getParameter("id");
       int deleteId = 0;
 
       try{
           deleteId = Integer.parseInt(idStr);
           UsersDAO.delete(deleteId);
 
       }catch(Exception e){
           e.printStackTrace();
       }
 
       resp.sendRedirect("query.do");
    }
}
