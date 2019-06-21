<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page import="javax.servlet.http.Cookie" %>
<%@ page import="domain.Order, dao.OrderDao, java.util.Set" %>
<%@ page import="util.ServletUtils" %>
<%@ page import="java.util.Map, java.util.HashMap" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>bookstore</title>
    <style>
           /* Table Head */
#table-7 thead th {
background-color: rgb(81, 130, 187);
color: #fff;
border-bottom-width: 0;
}

/* Column Style */
#table-7 td {
color: #000;
}
/* Heading and Column Style */
#table-7 tr, #table-7 th {
border-width: 1px;
border-style: solid;
border-color: rgb(81, 130, 187);
}

/* Padding and font style */
#table-7 td, #table-7 th {
padding: 5px 10px;
font-size: 12px;
font-family: Verdana;
font-weight: bold;
}
        body {
            font-family: "Lato", sans-serif;
        }

        .sidenav {
            height: 100%;
            width: 0;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: rgb(81, 130, 187);
            overflow-x: hidden;
            transition: 0.5s;
            padding-top: 60px;
        }

        .sidenav a {
            padding: 8px 8px 8px 32px;
            text-decoration: none;
            font-size: 25px;
            color: #ffffff;
            display: block;
            transition: 0.3s;
        }

        .sidenav a:hover, .offcanvas a:focus{
            color: #f1f1f1;
        }

        .sidenav .closebtn {
            position: absolute;
            top: 0;
            right: 25px;
            font-size: 36px;
            margin-left: 50px;
        }

        #main {
            transition: margin-left .5s;
            padding: 16px;
        }

        @media screen and (max-height: 450px) {
            .sidenav {padding-top: 15px;}
            .sidenav a {font-size: 18px;}
        }
        .date{
           font-size: 20px;
           color:rgb(81, 130, 187);
           padding-top: 0;
        }
        .table{
        font-size:14px;
        
        }
    </style>
</head>
<body>
<%      

		Cookie cookie = ServletUtils.getCookie(request, "user");
		if (cookie == null) {
			response.getWriter().println("Sorry, you are not logged in yet, and you will be logged in to the login page after 5 seconds.");
			response.addHeader("refresh", "5;url=" + request.getContextPath() + "/login.jsp");
			return;
		}
		
		Cookie cookie1 = ServletUtils.getCookie(request, "user");
		OrderDao orderDao = new OrderDao();
		Set<Order> orders = orderDao.getOrderById(Integer.valueOf(cookie1.getValue()));
	%>
	
<div style="text-align: right" class="date">
		<span><%= new Date() %></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		<a  href="${pageContext.request.contextPath}/index.jsp">back</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
				  
	</div>


<div id="main">

   
 <table id="table-7">
 <thead>
    <tr>
      <th>ID</th>
      <th>Money</th>
      <th>ReceiveAddress</th>
      <th>ReceiveName</th>
      <th>ReceivePhone</th>
      <th>OrderTime</th>
      
     
    </tr>
</thead> 
    <%
        for(Order order: orders){
    %>
    <tbody>
            <tr>
              <td><%= order.getId()%></td>
              <td><%= order.getMoney()%></td>
              <td><%= order.getReceiveAddress()%></td>
              <td><%= order.getReceiveName()%></td>
              <td><%= order.getReceivePhone()%></td>
              <td><%= order.getOrderTime()%></td>              
            </tr>
 
    <%
        }
    %>
    </tbody>
  </table>
  
</div>
</body>
<script>
    function openNav() {
        document.getElementById("mySidenav").style.width = "250px";
        document.getElementById("main").style.marginLeft = "250px";
    }

    function closeNav() {
        document.getElementById("mySidenav").style.width = "0";
        document.getElementById("main").style.marginLeft= "0";
    }
</script>
</html>