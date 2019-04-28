<%@ page import="mvccases.Customer" %>

<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Skye
  Date: 2017/12/8
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
     <!--  <script type="text/javascript">
    $(function(){
        $(".delete").click(function(){
            //数字从0开始,第一个parent是a，第二个是td
            var content = $(this).parent().parent().find("td:eq(1)").text();
            var flag = confirm("确定要删除"+ content +"的信息吗？");
            return flag;
        });
    });
  </script> -->

  </head>
  <body>
  <form action="query1.do", method="post ">
    <table>
      <tr>
        <td>Name:</td>
        <td><input type="text", name="name"/></td>
      </tr>
 
      <tr>
        <td>Address:</td>
        <td><input type="text", name="address"/></td>
      </tr>
 
      <tr>
        <td>Phone:</td>
        <td><input type="text", name="phone"/></td>
      </tr>
 
      <tr>
        <td><input type="submit", value="Query"/></td>
        <td><a href="newCustomer.jsp">Create New Customer</a></td>
 
      </tr>
    </table>
  </form>
 
  <br><br>
  <%
    List<Customer> customers = (List<Customer>)request.getAttribute("customers");
    if(customers != null && customers.size() != 0){
  %>
  <br><br>
  <hr>
 
  <table border="1" cellpadding="10" cellspacing="0">
    <tr><%--tr表示行，td表示列，th表示表头--%>
      <th>ID</th>
      <th>NAME</th>
      <th>Address</th>
      <th>Phone</th>
      <th>Delete/Update</th>
    </tr>
 
    <%
        for(Customer customer: customers){
    %>
            <tr>
              <td><%= customer.getId()%></td>
              <td><%= customer.getName()%></td>
              <td><%= customer.getAddress()%></td>
              <td><%= customer.getPhone()%></td>
              <td>
                <a href="edit1.do?id=<%= customer.getId() %>"UPDATE></a>
                <a href="delete1.do?id=<%= customer.getId()%>" class="delete">DELETE</a>
              </td>
            </tr>
 
    <%
        }
    %>
  </table>
 
 
  <%
    }
  %>
  </body>
</html>
