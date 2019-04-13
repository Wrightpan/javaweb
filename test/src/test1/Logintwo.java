package test1;



import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;


public class  Logintwo  implements Servlet {
    private ServletConfig servletConfig;

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig=servletConfig;
    }

    public void service
            (ServletRequest request, ServletResponse response)
        throws ServerException ,IOException{
        String username =request.getParameter("username");
        String password =request.getParameter("password");

        ServletContext servletContext =servletConfig.getServletContext();
        String initUser = servletContext.getInitParameter("user");
        String initPassword= servletContext.getInitParameter("password");
        
        PrintWriter out = response.getWriter();
        
        if(initUser.equals(username) && initPassword.equals(password))
        {
           out.print("hello:"+ username);
        }
        else{
            out.print("sorry:" + username);
        }
    }
}
