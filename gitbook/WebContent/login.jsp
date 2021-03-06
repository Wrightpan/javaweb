0<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Coming Soon - </title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Merriweather:300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="css1/coming-soon.min.css" rel="stylesheet">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="overlay"></div>
  <video playsinline="playsinline" autoplay="autoplay" muted="muted" loop="loop">
    <source src="mp4/bg.mp4" type="video/mp4">
  </video>

  <div class="masthead">
    <div class="masthead-bg"></div>
    <div class="container h-100">
      <div class="row h-100">
        <div class="col-12 my-auto">
          <div class="masthead-content text-white py-5 py-md-0">
            <h1 class="mb-3">Welcome!</h1>
            <p class="mb-5">      </p>
              <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
              <div class="input-group-append">
              <input type="text" name="username" class="form-control" placeholder="Enter username..."aria-label="Enter username..." aria-describedby="basic-addon">
              </div> 
              <br> 
            <div class="input-group-append">
              
              <input type="password" name="password" class="form-control" placeholder="Enter password..." aria-label="Enter password..." aria-describedby="basic-addon">
             
              </div><br>
            <div class="input-group-append">
            	 <input type="text" name="check_code" class="form-control" placeholder="Enter verification code..."aria-label="Enter verification code..." aria-describedby="basic-addon"/>
    			<img src="./ValidateColorServlet"/>
              
            </div><br>
           
           <button class="btn btn-secondary" type="submit">Login</button> </form>
           <br>
           <form action="${pageContext.request.contextPath}/register.jsp" method="post">
             <button class="btn btn-secondary" type="submit">
             
				Register</button> 
            </form> 
            
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="social-icons">
    <ul class="list-unstyled text-center mb-0">
      <li class="list-unstyled-item">
        <a href="#">
          <i class="fab fa-twitter"></i>
        </a>
      </li>
      <li class="list-unstyled-item">
        <a href="#">
          <i class="fab fa-facebook-f"></i>
        </a>
      </li>
      <li class="list-unstyled-item">
        <a href="#">
          <i class="fab fa-instagram"></i>
        </a>
      </li>
    </ul>
  </div>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="js1/coming-soon.min.js"></script>

</body>
</html>