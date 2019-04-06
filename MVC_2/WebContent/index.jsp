<%@ page import="mvc_2.Users" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <head>
  <title>$Title$</title>
  <script type="text/javascript" src="scripts/jquery-1.7.2.js"></script>
  <script type="text/javascript">
    $(function(){
        $(".delete").click(function(){
            //数字从0开始,第一个parent是a，第二个是td
            var content = $(this).parent().parent().find("td:eq(1)").text();
            var flag = confirm("确定要删除"+ content +"的信息吗？");
            return flag;
        });
    });
  </script>
  </head>
  <body>
  <form action="query.do", method="post ">
    <table>
      <tr>
        <td>userame:</td>
        <td><input type="text", name="username"/></td>
      </tr>
 
      <tr>
        <td>password:</td>
        <td><input type="text", name="password"/></td>
      </tr>
 
    
 
      <tr>
        <td><input type="submit", value="Query"/></td>
        <td><a href="">Create New Users</a></td>
 
      </tr>
    </table>
  </form>
 
  <br><br>
  <%
    List<Users> Users = (List<Users>)request.getAttribute("Users");
    if(Users != null && Users.size() != 0){
  %>
  <br><br>
  <hr>
 
  <table border="1" cellpadding="10" cellspacing="0">
    <tr><%--tr表示行，td表示列，th表示表头--%>
      <th>ID</th>
      <th>USERNAME</th>
      <th>Password</th>
     
      <th>Delete/Update</th>
    </tr>
 
    <%
        for(Users Users: Users){
    %>
            <tr>
              <td><%= Users.getId()%></td>
              <td><%= Users.getUsername()%></td>
              <td><%= Users.getPassword()%></td>
       
              <td>
                <a href="">UPDATE</a>
                <a href="delete.do?id=<%= Users.getId()%>" class="delete">DELETE</a>
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
