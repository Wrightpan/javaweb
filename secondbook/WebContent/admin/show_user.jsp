<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>

<%@ page import="dao.User, dao.UserDao, java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>admin-bookstore</title>
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
		UserDao userDao = new UserDao();
		List<User> users = userDao.getAllUser();
	%>
<div style="text-align: right" class="date">
		<span><%= new Date() %></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		<a  href="${pageContext.request.contextPath}/admin/index.jsp">back</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		<a href="${pageContext.request.contextPath}/login.jsp">login</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		  
	</div>
<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <span>Managing books</span>
    <a href="${pageContext.request.contextPath}/admin/add_production.jsp">Adding books</a>
    <span><a href="${pageContext.request.contextPath}/ShowProductServlet">All books</a></span>
    <span>Managing users</span>
    <span><a href="${pageContext.request.contextPath}/admin/add_user.jsp">Adding users</a></span>
    <a href="${pageContext.request.contextPath}/ShowUserServlet">All users</a>
</div>

<div id="main">

    <span style="font-size:30px;cursor:pointer;color:#001878" onclick="openNav()">&#9776; options</span><br><br><br>
 <table id="table-7">
 <thead>
    <tr>
      <th>ID</th>
      <th>Username</th>
      <th>Gender</th>
      <th>Email</th>
      <th>Phone</th>
      <th>Introduce</th>
      <th>RegistTime</th>
    </tr>
</thead> 
    <%
        for(User user: users){
    %>
    <tbody>
            <tr>
              <td><%= user.getId()%></td>
              <td><%= user.getUsername()%></td>
              <td><%= user.getGender()%></td>
              <td><%= user.getEmail()%></td>
              <td><%= user.getPhone()%></td>
              <td><%= user.getIntroduce()%></td>
              <td><%= user.getRegistTime()%></td>
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