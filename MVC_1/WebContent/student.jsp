<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		List<Student> stus = (List<Student>)request.getAttribute("students");
 %>
        <table>
                <tr>
                        <th>id</th>
                        <th>username</th>
                        <th>password</th>
                </tr>
        <%  for(Student student: stus){
         %>	
	 <tr>
                        <td><%= student.getid()%></td>
                        <td><%= student.getusername()%></td>
                        <td><%= student.getpassword()%></td>
             </tr>
             
            <%  }
         %>	 

       </table>
</body>
