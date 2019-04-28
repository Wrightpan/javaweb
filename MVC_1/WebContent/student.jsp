<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List" import="mvc_1.Student" import="java.sql.*"
    import="mvc_1.Delete"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		List<Student> list = (List<Student>)request.getAttribute("student");
 %>
        <table border="1 "cellpadding="10" cellspacing="0">
                <tr>
                        <th>id</th>
                        <th>username</th>
                        <th>password</th>
                        <th>delete</th>
                </tr>
        <%  for(Student student: list){ %>	
         
	 <tr>
                        <td><%= student.getid()%></td>
                        <td><%= student.getusername()%></td>
                        <td><%= student.getpassword()%></td>
                        <td><a href="/MVC_1/delete?id=<%=student.getid()
                        %>">delete</a></td>
             </tr>

             
            <%  } %>	 
        	 

       </table>
</body>

