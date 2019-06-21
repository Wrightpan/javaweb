<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>

<%@ page import="domain.User, dao.UserDao, java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>admin-bookstore</title>
    <style>
         
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
                 .bootstrap-frm {
            margin-left:auto;
            margin-right:auto;
            max-width: 500px;
            background: #FFF;
            padding: 20px 30px 20px 30px;
            font: 12px "Helvetica Neue", Helvetica, Arial, sans-serif;
            color: rgb(0, 91, 137);
            text-shadow: 1px 1px 1px #FFF;
            border:1px solid #ffffff;
            border-radius: 5px;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
        }

        .bootstrap-frm h1 {
            font: 25px "Helvetica Neue", Helvetica, Arial, sans-serif;
            padding: 0 0 10px 40px;
            display: block;
            border-bottom: 1px solid rgb(0, 91, 137);
            margin: -10px -30px 30px -30px;
            color: rgb(0, 91, 137);
        }
        .bootstrap-frm h1>span {
            display: block;
            font-size: 11px;
        }
        .bootstrap-frm label {
            display: block;
            margin: 0 0 5px;
        }
        .bootstrap-frm label>span {
            float: left;
            width: 20%;
            text-align: right;
            padding-right: 10px;
            margin-top: 10px;
            color: rgb(0, 91, 137);
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
            font-weight: bold;
        }
        .bootstrap-frm input[type="text"], .bootstrap-frm input[type="email"], .bootstrap-frm textarea, .bootstrap-frm select{
            border: 1px solid rgb(0, 91, 137);
            color: #888;
            height: 20px;
            line-height:15px;
            margin-bottom: 16px;
            margin-right: 6px;
            margin-top: 2px;
            outline: 0 none;
            padding: 5px 0px 5px 5px;
            width: 70%;
            border-radius: 4px;
            -webkit-border-radius: 4px;
            -moz-border-radius: 4px;
            -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
            box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
            -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
        }
        .bootstrap-frm select {
            background: #FFF;
            background: #FFF ;
            appearance:none;
            -webkit-appearance:none;
            -moz-appearance: none;
            text-indent: 0.01px;
            text-overflow: '';
            width: 70%;
            height: 35px;
            line-height:15px;
        }
        .bootstrap-frm textarea{
            height:100px;
            padding: 5px 0 0 5px;
            width: 70%;
        }
        .bootstrap-frm .button {
            background: rgb(0, 91, 137);
            border: 1px solid rgb(0, 91, 137);
            padding: 10px 25px 10px 25px;
            color: #ffffff;
            border-radius: 4px;
        }
        .bootstrap-frm .button:hover {
            color: rgb(0, 91, 137);
            background-color: #EBEBEB;
            border-color: #ADADAD;
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

<form action="${pageContext.request.contextPath}/AddUserServlet" method="post" onsubmit="return validate_add_user(this)" class="bootstrap-frm">
		<h1>Please enter information about users</h1>
		username:&nbsp;
		<input type="text" name="username"/> <br/>
		password:&nbsp;
		<input type="text" name="password"/> <br/>			
		email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="text" name="email"/> <br/>
		phone:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="text" name="phone"/> <br/>
		state:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="text"  name="state"><br/>
		role:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="text"  name="role"><br/>
		Introduce:&nbsp;&nbsp;<textarea name="description"></textarea> <br><br>
		<input type="submit" value="send" class="button"/>
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" class="button" value="reset"/>
	</form>
	

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