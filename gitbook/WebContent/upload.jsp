<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传页面</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/FileUploadServlet" enctype="multipart/form-data" method="post">
		
		<input type="file" name="file1"><br/>
		
		<input type="submit" value="submit" />
	</form>
</body>
</html>
