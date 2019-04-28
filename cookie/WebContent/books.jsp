<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Book Page</h4>
    <a href="book.jsp?book=JavaWeb">JavaWeb</a><br>
    <a href="book.jsp?book=Java">Java</a><br>
    <a href="book.jsp?book=JavaScript">JavaScript</a><br>
    <a href="book.jsp?book=MySQL">MySQL</a><br>
    <a href="book.jsp?book=Ajax">Ajax</a><br>
    <a href="book.jsp?book=TCPIP">TCPIP</a><br>
    <a href="book.jsp?book=Spring">Spring</a><br>
    <a href="book.jsp?book=Hibernate">Hibernate</a><br>
    <a href="book.jsp?book=Struts">Struts</a><br>
 
    <br>
<%
    //显示最近浏览的 5 本书
    Cookie[] cookies = request.getCookies();
 
    //获取所有的 Cookie 
    if(cookies != null && cookies.length > 0){
        //从中筛选出 Book 的 Cookie：
        for(Cookie cc: cookies){
            String bookName = cc.getName();
            //如果 cookieName 为books 开头的即符合条件
            if(bookName.startsWith("books")){
                //显示 cookieValue
                out.print(cc.getValue());
                out.print("<br>");
            }
        }
    }
%>
</body>
 
 
</html>
