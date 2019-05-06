<%@ page import="mvc.Customer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Skye
  Date: 2017/12/11
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 
<%
    Object message = request.getAttribute("message");
 
    if(message!= null){
        %>
        <br>
        <font color="red"><%=message%></font>
        <br>
        <br>
        <br>
<%
    }
%>
<form action="add.do" method="post">
<table>
 
    <tr>
        <td>CustomerName:</td>
        <td><input type="text" name="name" value="<%=request.getParameter("name") == null ? "" : request.getParameter("name")%>"/></td>
    </tr>
 
    <tr>
        <td>Address</td>
        <td>
        <input type="text" name="address" value="<%=request.getParameter("address") == null ? "" : request.getParameter("address")%>">
        </td>
    </tr>
 
    <tr>
        <td>Phone</td>
        <td>
        <input type="text" name="phone" value="<%=request.getParameter("phone")== null ? "" : request.getParameter("phone")%>">
        </td>
    </tr>
 
    <tr>
        <%--colspan="2"用来指定单元格横向跨越的列数  横跨两列--%>
        <%--rowspan的作用是指定单元格纵向跨越的行数--%>
        <td colspan="2"><input type="submit" value="Submit"/></td>
    </tr>
 
</table>
 
</body>
</html>
