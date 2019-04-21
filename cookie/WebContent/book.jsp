<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Skye
  Date: 2017/12/12
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Book Detail Page</h4>
    Book: <%= request.getParameter("book") %>
    <a href="books.jsp">Return</a>
<%
    //把书的信息以 Cookie 方式传回给浏览器，删除一个 Cookie
    String book = request.getParameter("book");
 
    //每次都重新读取浏览器中Cookie的信息，进行存储
    List<Cookie> cookies = new ArrayList<Cookie>();
 
    Cookie temp = null;
    Cookie[] c = request.getCookies();
    if(c!= null && c.length > 0){
        for(Cookie cc : c){
            String bookName = cc.getName();
             //确定要被删除的 Cookie:books开头的 Cookie
            if(bookName.startsWith("books")){
                cookies.add(cc);
 
                //若已经存储在浏览器的Cookie信息中
                if(cc.getValue().equals(book)){
                    temp = cc;
                }
            }
        }
    }
 
    //若List中的书的信息超过了5本，且本次读取的书不在List中，则删除最早的一本
    if(cookies.size() >= 5 && temp == null){
        temp = cookies.get(0);
    }
 
    //删除该书的信息
    if(temp != null){
        temp.setMaxAge(0);
        //删除时用的是先设置最大时效为0，再加入Cookie
        response.addCookie(temp);
    }
 
    //把从 books.jsp 传入的 book 作为一个 Cookie 返回
    Cookie cookie = new Cookie("books" + book, book);
    response.addCookie(cookie);
%>
</body>
</html>
