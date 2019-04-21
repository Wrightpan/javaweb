<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    String name = request.getParameter("loginName");
    if(name != null && !name.trim().equals("")){
        Cookie cookie = new Cookie("name", name);
        cookie.setMaxAge(30000);
        response.addCookie(cookie);
    }else{
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length != 0){
            for(Cookie cookie: cookies){
                if("name".equals(cookie.getName())){
                    String val = cookie.getValue();
                    name = val;
                }
            }
        }
    }
 
    if(name != null && !name.trim().equals("")){
        out.print("hello" + name);
    }else{
        response.sendRedirect("login.jsp");
    }
 
  %>
  </body>
</html>
