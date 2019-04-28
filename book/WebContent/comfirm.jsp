<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
    <%@page import="chose.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%
         Customer customer = (Customer)session.getAttribute("customer");
         String[] books = (String[])session.getAttribute("books");
     %>
     <table border="1" cellpadding="10" cellspacing="0">
         <tr>
             <td>顾客姓名：</td>
             <td><%= customer.getName() %></td>
         </tr>
         
         <tr>
             <td>地址：</td>
             <td><%= customer.getAddress() %></td>
         </tr>
         <tr>
             <td>卡号：</td>
             <td><%= customer.getCard()%></td>
         </tr>
         <tr>
             <td>卡的类型：</td>
             <td><%= customer.getCardType()%></td>
         </tr>
         <tr>
             <td>买的书：</td>
             <td>
                 <%
                     for(String book : books ){
                         out.print(book);
                         out.print("<br>");
                     }
                 %>
             </td>
         </tr>
     </table>
</body>
</html>