<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="domain.Product, java.util.HashMap" %>
<%@ page import="java.util.Map, java.util.HashMap" %>
<%@ page import="util.ServletUtils" %>
<%@ page import="javax.servlet.http.Cookie" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>order</title>


    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Google font (font-family: 'Roboto', sans-serif; Poppins ; Satisfy) -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,500,600,600i,700,700i,800" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900" rel="stylesheet">

    <!-- Stylesheets -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/plugins.css">
    <link rel="stylesheet" href="style.css">

    <!-- Cusom css -->
    <link rel="stylesheet" href="css/custom.css">

    <!-- Modernizer js -->
    <script src="js/vendor/modernizr-3.5.0.min.js"></script>

    <script src="js/vendor/jquery-3.2.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/plugins.js"></script>
    <script src="js/active.js"></script>
    

    
</head>
</head>
<body> <!-- Start Shopping Cart -->


	<%
		Cookie cookie = ServletUtils.getCookie(request, "user");
		if (cookie == null) {
			response.getWriter().println("Sorry, you are not logged in yet, and you will be logged in to the login page after 5 seconds.");
			response.addHeader("refresh", "5;url=" + request.getContextPath() + "/login.jsp");
			return;
		}
		String userId = "cart" + cookie.getValue();
		Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute(userId);
		if (cart == null) {
			response.getWriter().println("Sorry, you haven't purchased any items yet, transfer to the homepage after 5 seconds.");
			response.addHeader("refresh", "5;url=" + request.getContextPath() + "/index.jsp");
			return;
		}
	%>
	
	
<div >
  

  
    <div class="minicart-content-wrapper">
      
        <div class="items-total d-flex justify-content-between">
           
           <!--   <span><h4>Cart Subtotal</h4></span> -->
        </div>
        
      
          <c:set var="total" value="0" scope="page"/>
          <c:forEach var="entry" items="<%= cart %>" varStatus="vs">
        <div class="single__items">
            <div class="miniproduct">
                
                <div class="item01 d-flex mt--20">
                    <div class="thumb">
                        <a href="${entry.key.description}"><img src="${entry.key.imgurl}" alt="product images"></a>
                    </div>
                    <div class="content">
                        <h6><a href="${entry.key.description}">${entry.key.name}</a></h6>
                        <span class="prize">${entry.key.price}</span>
                        <div class="product_prize d-flex justify-content-between">
                            <span class="qun">${entry.value}</span>
                            <ul class="d-flex justify-content-end">
                                
                                <li><a href="${pageContext.request.contextPath}/ChangeCartServlet?id=${entry.key.id}"><i class="zmdi zmdi-delete"></i></a></li>
                              <c:set var="total" value="${total + entry.key.price * entry.value}"/>
                            </ul>
                        </div>
                    </div>
                </div>
                
            </div>
            </c:forEach>
        </div>
        <div class="total_amount text-right">
            <span>${total}</span>
        </div>
       <div>
			<form action="${pageContext.request.contextPath}/CreateOrderServlet" method="post">
						<div class="container">
                        <aside class="wedget__categories poroduct--cat">
                            <h3 class="wedget__title"></h3>
                            <ul>
                                <li>receiceAddress:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="address"/> </li><br/>
                                <li>recviceName:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name"/></li><br/>
                                <li>recivePhone:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="phone"/></li>  <br/>                            						                            
                            </ul>
                        </aside>
                    </div>
					 <div class="mini_action checkout">	<input class="checkout__btn" type="submit" value="submit"> </div>
			</form>
		</div>
       
    </div>
  
</div>
<!-- End Shopping Cart --></body>
</html>