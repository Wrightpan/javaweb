      <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="domain.Product, dao.ProductDao, java.util.List" %>
       <html class="no-js" lang="zxx">
        <head>
            <meta charset="utf-8">
            <meta http-equiv="x-ua-compatible" content="ie=edge">
            <title>Shop-List</title>
            <meta name="description" content="">
            <meta name="viewport" content="width=device-width, initial-scale=1">

            <!-- Google font (font-family: 'Roboto', sans-serif; Poppins ; Satisfy) -->
            <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">
            <link href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,500,600,600i,700,700i,800" rel="stylesheet">
            <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900" rel="stylesheet">

            <!-- Stylesheets -->
            <link rel="stylesheet" href="css/bootstrap.min.css">
            <link rel="stylesheet" href="css/plugins.css">
            <link rel="stylesheet" href="style.css">

            <!-- Cusom css -->
            <link rel="stylesheet" href="css/custom.css">

            <!-- Modernizer js -->
            <script src="js/vendor/modernizr-3.5.0.min.js"></script>
        </head>
<body>
<%
		ProductDao productDao = new ProductDao();
		List<Product> products = productDao.getAllProdut();
	%>


<!-- Main wrapper -->
<div class="wrapper" id="wrapper">

    <!-- Header -->
    <header id="wn__header" class="oth-page header__area header__absolute sticky__header">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-4 col-sm-4 col-7 col-lg-2">
                    <div class="logo">
                        <a href="index.jsp">
                            <img src="images/logo/logo.png" alt="logo images">
                        </a>
                    </div>
                </div>
                <div class="col-lg-8 d-none d-lg-block">
                    <nav class="mainmenu__nav">
                        <ul class="meninmenu d-flex justify-content-start">
                            <li><a href="index.jsp">Home</a></li>
                            <li><a href="shop-list.jsp">Shop List</a></li>
                            <li><a href="single-product.html">Single Product</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="col-md-8 col-sm-8 col-5 col-lg-2">
                    <ul class="header__sidebar__right d-flex justify-content-end align-items-center">
                       <li class="shop_search"><a class="search__active" href="#"></a></li>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <li class="shopcart"><a class="cartbox_active" href="${pageContext.request.contextPath}/cart.jsp"></a>
                        
                        <li class="setting__bar__icon"><a class="setting__active" href="${pageContext.request.contextPath}/login.jsp"></a>    
                            

                    </ul>
                </div>
            </div>
            <!-- Start Mobile Menu -->
            <div class="row d-none">
                <div class="col-lg-12 d-none">
                    <nav class="mobilemenu__nav">
                        <ul class="meninmenu">
                            <li><a href="index.jsp">Home</a></li>
                            <li><a href="shop-list.jsp">Shop List</a></li>
                           <li><a ></a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                           <li><a ></a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </ul>
                    </nav>
                </div>
            </div>
            <!-- End Mobile Menu -->
            <div class="mobile-menu d-block d-lg-none">
            </div>
            <!-- Mobile Menu -->
        </div>
    </header>
    <!-- //Header -->
    <!-- Start Search Popup -->
    <div class="box-search-content search_active block-bg close__top">
        <form id="search_mini_form" class="minisearch" action="#">
            <div class="field__search">
                <input type="text" placeholder="Search entire store here...">
                <div class="action">
                    <a href="#"><i class="zmdi zmdi-search"></i></a>
                </div>
            </div>
        </form>
        <div class="close__wrap">
            <span>close</span>
        </div>
    </div>
    <!-- End Search Popup -->
    <!-- Start Bradcaump area -->
    <div class="ht__bradcaump__area bg-image--5">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="bradcaump__inner text-center">
                        <h2 class="bradcaump-title">Shop List</h2>
                        <nav class="bradcaump-content">
                            <a class="breadcrumb_item" href="index.jsp">Home</a>
                            <span class="brd-separetor">/</span>
                            <span class="breadcrumb_item active">Shop List</span>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Bradcaump area -->
    <!-- Start Shop Page -->
    <div class="page-shop-sidebar left--sidebar bg--white section-padding--lg">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-12 order-2 order-lg-1 md-mt-40 sm-mt-40">
                    <div class="shop__sidebar">
                        <aside class="wedget__categories poroduct--cat">
                            <h3 class="wedget__title">Product Categories</h3>
                            <ul>
                                <li><a href="#">Biography <span>(3)</span></a></li>
                                <li><a href="#">Business <span>(4)</span></a></li>
                                <li><a href="#">Cookbooks <span>(6)</span></a></li>
                                <li><a href="#">Health & Fitness <span>(7)</span></a></li>
                                <li><a href="#">History <span>(8)</span></a></li>
                                <li><a href="#">Mystery <span>(9)</span></a></li>
                                <li><a href="#">Inspiration <span>(13)</span></a></li>
                                <li><a href="#">Romance <span>(20)</span></a></li>
                                <li><a href="#">Fiction/Fantasy <span>(22)</span></a></li>
                                <li><a href="#">Self-Improvement <span>(13)</span></a></li>
                                <li><a href="#">Humor Books <span>(17)</span></a></li>
                                <li><a href="#">Harry Potter <span>(20)</span></a></li>
                                <li><a href="#">Land of Stories <span>(34)</span></a></li>
                                <li><a href="#">Kids' Music <span>(60)</span></a></li>
                                <li><a href="#">Toys & Games <span>(3)</span></a></li>
                                <li><a href="#">hoodies <span>(3)</span></a></li>
                            </ul>
                        </aside>
                        <aside class="wedget__categories pro--range">
                            <h3 class="wedget__title">Filter by price</h3>
                            <div class="content-shopby">
                                <div class="price_filter s-filter clear">
                                    <form action="#" method="GET">
                                        <div id="slider-range"></div>
                                        <div class="slider__range--output">
                                            <div class="price__output--wrap">
                                                <div class="price--output">
                                                    <span>Price :</span><input type="text" id="amount" readonly="">
                                                </div>
                                                <div class="price--filter">
                                                    <a href="#">Filter</a>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </aside>
                        <aside class="wedget__categories poroduct--compare">
                            <h3 class="wedget__title">Compare</h3>
                            <ul>
                                <li><a href="#">x</a><a href="#">Condimentum posuere</a></li>
                                <li><a href="#">x</a><a href="#">Condimentum posuere</a></li>
                                <li><a href="#">x</a><a href="#">Dignissim venenatis</a></li>
                            </ul>
                        </aside>
                        <aside class="wedget__categories poroduct--tag">
                            <h3 class="wedget__title">Product Tags</h3>
                            <ul>
                                <li><a href="#">Biography</a></li>
                                <li><a href="#">Business</a></li>
                                <li><a href="#">Cookbooks</a></li>
                                <li><a href="#">Health & Fitness</a></li>
                                <li><a href="#">History</a></li>
                                <li><a href="#">Mystery</a></li>
                                <li><a href="#">Inspiration</a></li>
                                <li><a href="#">Religion</a></li>
                                <li><a href="#">Fiction</a></li>
                                <li><a href="#">Fantasy</a></li>
                                <li><a href="#">Music</a></li>
                                <li><a href="#">Toys</a></li>
                                <li><a href="#">Hoodies</a></li>
                            </ul>
                        </aside>
                        <aside class="wedget__categories sidebar--banner">
                            <img src="images/others/banner_left.jpg" alt="banner images">
                            <div class="text">
                                <h2>new products</h2>
                                <h6>save up to <br> <strong>40%</strong>off</h6>
                            </div>
                        </aside>
                    </div>
                </div>
                <div class="col-lg-9 col-12 order-1 order-lg-2">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="shop__list__wrapper d-flex flex-wrap flex-md-nowrap justify-content-between">
                                <div class="shop__list nav justify-content-center" role="tablist">
                                   
                                    
                                    <a class="nav-item nav-link active" data-toggle="tab" href="#nav-list" role="tab"><i class="fa fa-list"></i></a>
                                    
                                </div>
								<a href="${pageContext.request.contextPath}/PagingServlet?newPage=1">View all books</a>

                            </div>
                        </div>
                    </div>


                    <div class="tab__container">
                        



                        <div class="shop-grid tab-pane fade show active" id="nav-list" role="tabpanel">
                            <div class="list__view__wrapper">

                                <!-- Start Single Product -->
                                
                                <c:forEach items="${entities}" var="entity">
                                
                                <div class="list__view mt--40">
                                    <div class="thumb">
                                        <a class="first__img" href="${entity.description}"><img src="${entity.imgurl}" alt="product images"></a>
                                        <a class="second__img animation1" href="${entity.description}"><img src="${entity.imgurl}" alt="product images"></a>
                                    </div>
                                    <div class="content">
                                        <h2><a href="${entity.description}">${entity.name}</a></h2>
                                        <ul class="rating d-flex">
                                            <li class="on"><i class="fa fa-star-o"></i></li>
                                            <li class="on"><i class="fa fa-star-o"></i></li>
                                            <li class="on"><i class="fa fa-star-o"></i></li>
                                            <li class="on"><i class="fa fa-star-o"></i></li>
                                            <li><i class="fa fa-star-o"></i></li>
                                            <li><i class="fa fa-star-o"></i></li>
                                        </ul>
                                        <ul class="prize__box">
                                            <li>${entity.price}</li>
                                            <li class="old__prize">$220.00</li>
                                        </ul>
                                        <p>${entity.description}</p>
                                        <ul class="cart__action d-flex">
                                            <li class="cart"><a href="${pageContext.request.contextPath}/AddCarServlet?id=${entity.id}">Add to cart</a></li>
                                        
                                        </ul>

                                    </div>
                                </div>
                                    </c:forEach>
                                <!-- End Single Product -->
                                <ul class="wn__pagination">
                                <li class="active"><a href="${pageContext.request.contextPath}/PagingServlet?newPage=1">First page</a></li>
       							<li><a href="${pageContext.request.contextPath}/PagingServlet?newPage=${newPage-1<=1?1:newPage-1}">Previous page</a></li>
       							<li><a href="${pageContext.request.contextPath}/PagingServlet?newPage=${newPage+1>=countPage?countPage:newPage+1}">Next page</a><li>
       							<li><a href="${pageContext.request.contextPath}/PagingServlet?newPage=${countPage}">Last Page</a></li>
                            	</ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Shop Page -->
    <!-- Footer Area -->
    <footer id="wn__footer" class="footer__area bg__cat--8 brown--color">
        <div class="footer-static-top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="footer__widget footer__menu">
                            <div class="ft__logo">
                                <a href="index.jsp">
                                    <img src="images/logo/3.png" alt="logo">
                                </a>
                                <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered duskam alteration variations of passages</p>
                            </div>
                            <div class="footer__content">
                                <ul class="social__net social__net--2 d-flex justify-content-center">
                                    <li><a href="#"><i class="bi bi-facebook"></i></a></li>
                                    <li><a href="#"><i class="bi bi-google"></i></a></li>
                                    <li><a href="#"><i class="bi bi-twitter"></i></a></li>
                                    <li><a href="#"><i class="bi bi-linkedin"></i></a></li>
                                    <li><a href="#"><i class="bi bi-youtube"></i></a></li>
                                </ul>
                                <ul class="mainmenu d-flex justify-content-center">
                                    <li><a href="index.jsp">Trending</a></li>
                                    <li><a href="index.jsp">Best Seller</a></li>
                                    <li><a href="index.jsp">All Product</a></li>
                                    <li><a href="index.jsp">Wishlist</a></li>
                                    <li><a href="index.jsp">Blog</a></li>
                                    <li><a href="index.jsp">Contact</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </footer>
    <!-- //Footer Area -->

</div>
<!-- //Main wrapper -->

<!-- JS Files -->
<script src="js/vendor/jquery-3.2.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/plugins.js"></script>
<script src="js/active.js"></script>

</body>
</html>
