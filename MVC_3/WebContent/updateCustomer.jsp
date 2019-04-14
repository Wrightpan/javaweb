<%@ page import="MVCCases.Customer" %><%--
  Created by IntelliJ IDEA.
  User: Skye
  Date: 2017/12/11
  Time: 15:30
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
    if(message != null){
%>
        <br>
        <font color="red"><%= message%></font>
        <br>
        <br>
<%
    }
    String id = null;
    String name = null;
    String address = null;
    String phone = null;
    String oldName = null;
    Customer customer = (Customer)request.getAttribute("customer");
 
    if(customer != null){
        id = customer.getId() + "";
        name = customer.getName();
        oldName = customer.getName();
        address = customer.getAddress();
        phone = customer.getPhone();
    } else{
        id = request.getParameter("id");
        name = request.getParameter("name");
        oldName = request.getParameter("oldName");
        address = request.getParameter("address");
        phone = request.getParameter("phone");
    }
%>
 
<form action="update.do" method="post">
 
    <%--隐藏域 --%>
    <input type="hidden" name="id" value="<%= id%>"/>
    <input type="hidden" name="oldName" value="<%= oldName%>"/>
 
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="<%= name%>"/></td>
        </tr>
 
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address" value="<%= address%>"/></td>
        </tr>
 
        <tr>
            <td>Phone:</td>
            <td><input type="text" name="phone" value="<%= phone%>"/></td>
        </tr>
 
        <tr>
            <td><input type="submit" name="Submit"/></td>
 
        </tr>
        <%-- <form>
             <tr>
                 <th>ID</th>
                 <th>Name</th>
                 <th>Address</th>
                 <th>Phone</th>
             </tr>
 
             <tr>
                 <td><%=customer.getId()%></td>
                 <td><%=customer.getName()%></td>
                 <td><%=customer.getAddress()%></td>
                 <td><%=customer.getPhone()%></td>
             </tr>
         </form>--%>
    </table>
</form>
</body>
</html>
