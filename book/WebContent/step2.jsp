<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
form action="<%= request.getContextPath() %>/processStep2" method="post">
     <h4>step2: 请输入寄送的地址和信用卡信息</h4>
     <table border="1" cellpadding="10" cellspacing="0">
         <tr>
             <td colspan="2" align="center">寄送信息</td>
         </tr>
         
         <tr>
             <td>姓名：</td>
             <td><input type="text" name="name"/></td>
         </tr>
         
         <tr>
             <td>寄送地址：</td>
             <td><input type="text" name="address"/></td>
         </tr>
         
         <tr>
             <td colspan="2" align="center">信用卡信息</td>
         </tr>
         
         <tr>
             <td>种类：</td>
             <td>
                 <input type="radio" name="cardType" value="Visa"/>Visa
                 <input type="radio" name="cardType" value="Master"/>Master 
             
             </td>
         </tr>
         
         <tr>
             <td>卡号：</td>
             <td><input type="text" name="card"/></td>
         </tr>
         
         <tr>
             <td colspan="2">
             <input align="center" type="submit" value="Submit"/></td>
         </tr>
 </table>
     </form>
</body>
</html>