package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/checkcodeservlet")
public class CheckCodeServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        response.setContentType("text/html;charset=utf-8");  
        PrintWriter out = response.getWriter();  
          
        HttpSession session = request.getSession(false);  
        if(session == null) {  
            out.print("验证码处理问题");  
            return;  
        }  
          
        String saveCode = (String)session.getAttribute("check_code");  
        if(saveCode == null) {  
            out.print("验证码处理问题");  
            return;  
        }  
          
        String checkCode = request.getParameter("check_code");  
        if(!saveCode.equals(checkCode)) {  
            out.print("验证码无效!");  
            return;  
        }  
          
        session.removeAttribute("check_code");  
       // out.print("验证码通过，服务器正在校验用户名和密码！");  
        request.getRequestDispatcher("index.html").forward(request, response);
  
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
        doGet(request, response);  
    }   
        
    }

