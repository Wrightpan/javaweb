<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>文件上传</title>
  </head>
  
  <body>
    <form action="Upload" method="post" enctype="multipart/form-data">
	最简单的文件上传：<input type="file" name="file1"/>
	
	<input type="submit" value="submit"/>
	</form>

  </body>
</html>