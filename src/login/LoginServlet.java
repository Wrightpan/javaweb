package login;

import com.sun.xml.internal.ws.resources.WsservletMessages;

import javax.servlet.*;
import java.io.IOException;
import java.rmi.ServerException;


public class  LoginServlet  implements Servlet {
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

        if(initUser.equals(username)&&initPassword.equals(password))
        {
            System.out.print("hello:"+ username);
        }
        else{
            System.out.print("sorry:" + password);
        }
    }
}

