
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8" />
    <title>admin-bookstore</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" />
    <style >
        *, *:before, *:after {
            -moz-box-sizing: border-box;
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
        }
        a {
            color: inherit;
            text-decoration: none;
           
        }
        html, body {
            padding: 0;
            margin: 0;
            background: rgba(255, 255, 255, 0);
        }
        .date{
           font-size: 20px;
           color:#0b9ac3;
           padding-top: 0;
        }
       
        body {
            padding-top: 10px;
        }
        .section {
            width: 300px;
            margin: 5px auto;
            height: 58px;
            box-shadow: 0 1px 2px rgba(0, 0, 0, 0);
            overflow: hidden;
            -webkit-transition: .35s;
            transition: .35s;
        }
        .title {
            padding: 20px;
            padding-top: 24px;
            background: #0b9ac3;
            color: #fff;
            cursor: pointer;
            text-shadow: 0 1px 0 #666;
            width: 100%;
            text-transform: capitalize;
            font-family: 'Merriweather Sans', sans-serif;
            font-style: italic;
            position: relative;
            -moz-user-select: none;
            -ms-user-select: none;
            -webkit-user-select: none;
            user-select: none;
            z-index: 10;
        }
        .title:before, .title:after {
            content: "";
            display: block;
            position: absolute;
            right: 20px;
            top: 21px;
            font-style: normal;
            height: 21px;
            line-height: 1;
            overflow: hidden;
            font-family: FontAwesome;
            font-size: 20px;
            background: #ffd558;
            -webkit-transition: .35s;
            transition: .35s;
        }
        .title:before {
            z-index: 2;
        }
        .title:after {
            top: 25px;
            -webkit-transform: rotate( 180deg );
            -ms-transform: rotate( 180deg );
            -moz-transform: rotate( 180deg );
            transform: rotate( 180deg );
        }

        .open .title:before {
            height: 0;
        }
        .body {
            font: 16px open, sans-serif;
            background: #fff;
            padding: 10px 20px 40px;
            -moz-transform: translateY( -100% );
            -ms-transform: translateY( -100% );
            -webkit-transform: translateY( -100% );
            transform: translateY( -100% );
            overflow: hidden;
            -webkit-transition: .35s;
            transition: .35s;
        }
        .body a {
            color: #2fa7c3;
        }
        .body span {
            font-size: 20px;
        }
        .section.open {
            height: 180px;
        }
        .open .body {
            -webkit-transform: none;
            -ms-transform: none;
            -moz-transform: none;
            transform: none;
        }
    </style>
</head>

<body>
	<div style="text-align: right" class="date">
		<span><%= new Date() %></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		<a  href="${pageContext.request.contextPath}/admin/index.jsp">back</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
		<a href="${pageContext.request.contextPath}/login.jsp">login</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		 <br> <br> <br> 
	</div>
<div class="section">
   
    <div class="title">Managing books</div>
     <div class="body">
    <span><a href="${pageContext.request.contextPath}/admin/add_production.jsp">Adding books</a></span>
    <br><br>
     <span><a href="${pageContext.request.contextPath}/ShowProductServlet">All books</a></span>
    </div>
    
</div>

<div class="section">
    <div class="title">Managing users</div>
    

    <div class="body">
    <span><a href="${pageContext.request.contextPath}/admin/add_user.jsp">Adding users</a></span>
    <br><br>
    <span><a href="${pageContext.request.contextPath}/ShowUserServlet">All users</a></span>    
    </div>

</div>

</body>
<script>
    ;!( function( w, d ) {
        'use strict';
        var titles = d.querySelectorAll( '.title' ),
            i = 0,
            len = titles.length;
        for ( ; i < len; i++ )
            titles[ i ].onclick = function( e ) {
                for ( var j = 0; j < len; j++ )
                    if ( this != titles[ j ] )
                        titles[ j ].parentNode.className = titles[ j ].parentNode.className.replace( / open/i, '' );
                var cn = this.parentNode.className;
                this.parentNode.className = ~cn.search( /open/i ) ? cn.replace( / open/i, '' ) : cn + ' open';
            };
    })( this, document );
</script>
</html>
