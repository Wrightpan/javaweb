<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="domain.Product, dao.ProductDao, java.util.List" %>
        <html class="no-js" lang="zxx">
        <head>
            <meta charset="utf-8">
            <meta http-equiv="x-ua-compatible" content="ie=edge">
            <title>Home</title>
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
    <header id="wn__header" class="header__area header__absolute sticky__header">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6 col-sm-6 col-6 col-lg-2">
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
                               
                            <li><a href="${pageContext.request.contextPath}/PagingServlet?newPage=1">Shop List</a></li>
                           <li><a ></a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                           <li><a ></a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                           
                        </ul>
                    </nav>
                </div>
                <div class="col-md-6 col-sm-6 col-6 col-lg-2">
                    <ul class="header__sidebar__right d-flex justify-content-end align-items-center">
                        <li class="shop_search"><a class="search__active" href="#"></a></li>
                        
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        
                         <li class="shopcart"><a class="cartbox_active" href="${pageContext.request.contextPath}/cart.jsp"></a>
                                                                                                     
                        <li class="setting__bar__icon">
                        <form action="${pageContext.request.contextPath}/CheckHistoryOrder" method="post">
                        <button ></button>
                        </form>
                    
                     
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
                                               
                                            </ul>
                                        </nav>
                                    </div>
                                </div>
                                <!-- End Mobile Menu -->
                                <div class="mobile-menu d-block d-lg-none">
                                </div>


        </div>
    </header>
    <!-- //Header -->
    <!-- Start Search Popup -->
    <div class="brown--color box-search-content search_active block-bg close__top">
        <form id="search_mini_form" class="minisearch" action="${pageContext.request.contextPath}/MenuSearchServlet" method="get">
            <div class="field__search">
                <input type="text" placeholder="Search book here..."  name="findBook" value="Please enter the title">
                <div class="action">
                    <a href="#"><i class="zmdi zmdi-search"><input type="submit" value="search"/></i></a>
                </div>
            </div>
        </form>
        <div class="close__wrap">
            <span>close</span>
        </div>
    </div>
    <!-- End Search Popup -->
    <!-- Start Slider area -->
    <div class="slider-area brown__nav slider--15 slide__activation slide__arrow01 owl-carousel owl-theme">
        <!-- Start Single Slide -->
        <div class="slide animation__style10 bg-image--1 fullscreen align__center--left">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="slider__content">
                            <div class="contentbox">
                                <h2>Buy <span>your </span></h2>
                                <h2>favourite <span>Book </span></h2>
                                <h2>from <span>Here </span></h2>
                                <a class="shopbtn" href="#">shop now</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Single Slide -->
        <!-- Start Single Slide -->
        <div class="slide animation__style10 bg-image--7 fullscreen align__center--left">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="slider__content">
                            <div class="contentbox">
                                <h2>Buy <span>your </span></h2>
                                <h2>favourite <span>Book </span></h2>
                                <h2>from <span>Here </span></h2>
                                <a class="shopbtn" href="#">shop now</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Single Slide -->
    </div>
    <!-- End Slider area -->
    <!-- Start BEst Seller Area -->
    <section class="wn__product__area brown--color pt--80  pb--30">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section__title text-center">
                        <h2 class="title__be--2">New <span class="color--theme">Products</span></h2>
                        <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered lebmid alteration in some ledmid form</p>
                    </div>
                </div>
            </div>
            <!-- Start Single Tab Content -->
            
            <div class="furniture--4 border--round arrows_style owl-carousel owl-theme row mt--50">
            
                                         
                <c:forEach var="product" items="<%= products %>">
                            
                            <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                                <div class="product product__style--3">
                                    <div class="product__thumb">
                                        <a class="first__img" href="${product.description}"><img src="${product.imgurl}" alt="product image"></a>
                                        <a class="second__img animation1" href="${product.description}"><img src="${product.imgurl}" alt="product image"></a>
                                        <div class="hot__box">
                                            <span class="hot-label">BEST SALLER</span>
                                        </div>
                                    </div>
                                    <div class="product__content content--center">
                                        <h4><a href="${product.description}">${product.name}</a></h4>
                                        <ul class="prize d-flex">
                                            <li>${product.price}</li>
                                            <li class="old_prize">$10</li>
                                        </ul>
                                        <div class="action">
                                            <div class="actions_inner">
                                                <ul class="add_to_links">
                                                    <li><a class="cart" href="${pageContext.request.contextPath}/AddCarServlet?id=${product.id}"><i class="bi bi-shopping-bag4">
                                                    		</i></a></li>
                                                    
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="product__hover--content">
                                            <ul class="rating d-flex">
                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                <li><i class="fa fa-star-o"></i></li>
                                                <li><i class="fa fa-star-o"></i></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </c:forEach>
                  
                </div>
            </div>
            <!-- End Single Tab Content -->
        </div>
    </section>
    <!-- Start BEst Seller Area -->
    <!-- Start NEwsletter Area -->
    <section class="wn__newsletter__area bg-image--2">
        <div class="container">
            <div class="row">
                <div class="col-lg-7 offset-lg-5 col-md-12 col-12 ptb--150">
                    <div class="section__title text-center">
                        <h2>Stay With Us</h2>
                    </div>
                    <div class="newsletter__block text-center">
                        <p>Subscribe to our newsletters now and stay up-to-date with new collections, the latest lookbooks and exclusive offers.</p>
                        <form action="#">
                            <div class="newsletter__box">
                                <input type="email" placeholder="Enter your e-mail">
                                <button>Subscribe</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- End NEwsletter Area -->
    <!-- Start Best Seller Area -->
    <section class="wn__bestseller__area bg--white pt--80  pb--30">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section__title text-center">
                        <h2 class="title__be--2">All <span class="color--theme">Products</span></h2>
                        <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered lebmid alteration in some ledmid form</p>
                    </div>
                </div>
            </div>
            <div class="row mt--50">
                <div class="col-md-12 col-lg-12 col-sm-12">
                    <div class="product__nav nav justify-content-center" role="tablist">
                        <a class="nav-item nav-link active" data-toggle="tab" href="#nav-all" role="tab">ALL</a>
                        <a class="nav-item nav-link" data-toggle="tab" href="#nav-biographic" role="tab">BIOGRAPHIC</a>
                        <a class="nav-item nav-link" data-toggle="tab" href="#nav-adventure" role="tab">ADVENTURE</a>
                        <a class="nav-item nav-link" data-toggle="tab" href="#nav-children" role="tab">CHILDREN</a>

                    </div>
                </div>
            </div>
            <div class="tab__container mt--60">
                <!-- Start Single Tab Content -->
                <div class="row single__tab tab-pane fade show active" id="nav-all" role="tabpanel">
                    <div class="product__indicator--4 arrows_style owl-carousel owl-theme">
                                           
                        <div class="single__product">
                        
                            <!-- Start Single Product -->
                            
                            <c:forEach var="product" items="<%= products %>">
                            
                            <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                                <div class="product product__style--3">
                                    <div class="product__thumb">
                                        <a class="first__img" href="${product.description}"><img src="${product.imgurl}" alt="product image"></a>
                                        <a class="second__img animation1" href="${product.description}"><img src="${product.imgurl}" alt="product image"></a>
                                        <div class="hot__box">
                                            <span class="hot-label">BEST SALLER</span>
                                        </div>
                                    </div>
                                    <div class="product__content content--center">
                                        <h4><a href="${product.description}">${product.name}</a></h4>
                                        <ul class="prize d-flex">
                                            <li>${product.price}</li>
                                            <li class="old_prize">$40</li>
                                        </ul>
                                        <div class="action">
                                            <div class="actions_inner">
                                                <ul class="add_to_links">
                                                    <li><a class="cart" href="href="${pageContext.request.contextPath}/AddCarServlet?id=${product.id}""><i class="bi bi-shopping-bag4"></i></a></li>
                                                    
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="product__hover--content">
                                            <ul class="rating d-flex">
                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                <li><i class="fa fa-star-o"></i></li>
                                                <li><i class="fa fa-star-o"></i></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </c:forEach>
                            <!-- Start Single Product -->
                       
                        </div>
                    </div>
                </div>
                <!-- End Single Tab Content -->
                
                <!-- Start Single Tab Content -->
                <div class="row single__tab tab-pane fade" id="nav-biographic" role="tabpanel">
                    <div class="product__indicator--4 arrows_style owl-carousel owl-theme">
						
                        <div class="single__product">
                        
                            <!-- Start Single Product -->
                            
                            <c:forEach var="product" items="<%= products %>">
                            
                            <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                                <div class="product product__style--3">
                                    <div class="product__thumb">
                                        <a class="first__img" href="${product.description}"><img src="${product.imgurl}" alt="product image"></a>
                                        <a class="second__img animation1" href="${product.description}"><img src="${product.imgurl}" alt="product image"></a>
                                        <div class="hot__box">
                                            <span class="hot-label">BEST SALLER</span>
                                        </div>
                                    </div>
                                    <div class="product__content content--center">
                                        <h4><a href="${product.description}">${product.name}</a></h4>
                                        <ul class="prize d-flex">
                                            <li>${product.price}</li>
                                            <li class="old_prize">$50</li>
                                        </ul>
                                        <div class="action">
                                            <div class="actions_inner">
                                                <ul class="add_to_links">
                                                    <li><a class="cart" href="${pageContext.request.contextPath}/AddCarServlet?id=${product.id}"><i class="bi bi-shopping-bag4"></i></a></li>
                                                    
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="product__hover--content">
                                            <ul class="rating d-flex">
                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                <li><i class="fa fa-star-o"></i></li>
                                                <li><i class="fa fa-star-o"></i></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </c:forEach>
                            <!-- Start Single Product -->

                        </div>
                    </div>
                </div>
                <!-- End Single Tab Content -->
                
                <!-- Start Single Tab Content -->
                <div class="row single__tab tab-pane fade" id="nav-adventure" role="tabpanel">
                    <div class="product__indicator--4 arrows_style owl-carousel owl-theme">
                    
                     
                        <div class="single__product">
                            <!-- Start Single Product -->
                            
                            <c:forEach var="product" items="<%= products %>">
                            
                            <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                                <div class="product product__style--3">
                                    <div class="product__thumb">
                                        <a class="first__img" href="${product.description}"><img src="${product.imgurl}" alt="product image"></a>
                                        <a class="second__img animation1" href="${product.description}"><img src="${product.imgurl}" alt="product image"></a>
                                        <div class="hot__box">
                                            <span class="hot-label">BEST SALLER</span>
                                        </div>
                                    </div>
                                    <div class="product__content content--center">
                                        <h4><a href="${product.description}">${product.name}</a></h4>
                                        <ul class="prize d-flex">
                                            <li>${product.price}</li>
                                            <li class="old_prize">$50</li>
                                        </ul>
                                        <div class="action">
                                            <div class="actions_inner">
                                                <ul class="add_to_links">
                                                    <li><a class="cart" href="${pageContext.request.contextPath}/AddCarServlet?id=${product.id}"><i class="bi bi-shopping-bag4"></i></a></li>
                                                    
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="product__hover--content">
                                            <ul class="rating d-flex">
                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                <li><i class="fa fa-star-o"></i></li>
                                                <li><i class="fa fa-star-o"></i></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </c:forEach>
                            
                            <!-- Start Single Product -->
                        </div>
                    </div>
                </div>
                <!-- End Single Tab Content -->
                
                <!-- Start Single Tab Content -->
                <div class="row single__tab tab-pane fade" id="nav-children" role="tabpanel">
                    <div class="product__indicator--4 arrows_style owl-carousel owl-theme">
                    
                        
                        <div class="single__product">
                            <!-- Start Single Product -->
                            <c:forEach var="product" items="<%= products %>">
                            
                            <div class="col-lg-3 col-md-4 col-sm-6 col-12">
                                <div class="product product__style--3">
                                    <div class="product__thumb">
                                        <a class="first__img" href="${product.description}"><img src="${product.imgurl}" alt="product image"></a>
                                        <a class="second__img animation1" href="${product.description}"><img src="${product.imgurl}" alt="product image"></a>
                                        <div class="hot__box">
                                            <span class="hot-label">BEST SALLER</span>
                                        </div>
                                    </div>
                                    <div class="product__content content--center">
                                        <h4><a href="${product.description}">${product.name}</a></h4>
                                        <ul class="prize d-flex">
                                            <li>${product.price}</li>
                                            <li class="old_prize">$50</li>
                                        </ul>
                                        <div class="action">
                                            <div class="actions_inner">
                                                <ul class="add_to_links">
                                                    <li><a class="cart" href="${pageContext.request.contextPath}/AddCarServlet?id=${product.id}"><i class="bi bi-shopping-bag4"></i></a></li>
                                                    
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="product__hover--content">
                                            <ul class="rating d-flex">
                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                <li class="on"><i class="fa fa-star-o"></i></li>
                                                <li><i class="fa fa-star-o"></i></li>
                                                <li><i class="fa fa-star-o"></i></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </c:forEach>
                            <!-- Start Single Product -->
                           
                        </div>
                    </div>
                </div>
                <!-- End Single Tab Content -->

            </div>
        </div>
    </section>
    <!-- Start BEst Seller Area -->

    <!-- Best Sale Area -->
    <section class="best-seel-area pt--80 pb--60">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section__title text-center pb--50">
                        <h2 class="title__be--2">Best <span class="color--theme">Seller </span></h2>
                        <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered lebmid alteration in some ledmid form</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="slider center">
            <!-- Single product start -->
            <div class="product product__style--3">
                <div class="product__thumb">
                    <a class="first__img" href="single-product.html"><img src="images/best-sell-product/1.jpg" alt="product image"></a>
                </div>
                <div class="product__content content--center">
                    <div class="action">
                        <div class="actions_inner">
                            <ul class="add_to_links">
                                <li><a class="cart" href="#"><i class="bi bi-shopping-bag4"></i></a></li>
                                <li><a class="wishlist" href="#"><i class="bi bi-shopping-cart-full"></i></a></li>
                                <li><a class="compare" href="#"><i class="bi bi-heart-beat"></i></a></li>
                                <li><a data-toggle="modal" title="Quick View" class="quickview modal-view detail-link" href="#productmodal"><i class="bi bi-search"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="product__hover--content">
                        <ul class="rating d-flex">
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li><i class="fa fa-star-o"></i></li>
                            <li><i class="fa fa-star-o"></i></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Single product end -->
            
            <!-- Single product start -->
            <div class="product product__style--3">
                <div class="product__thumb">
                    <a class="first__img" href="single-product.html"><img src="images/best-sell-product/2.jpg" alt="product image"></a>
                </div>
                <div class="product__content content--center">
                    <div class="action">
                        <div class="actions_inner">
                            <ul class="add_to_links">
                                <li><a class="cart" href="#"><i class="bi bi-shopping-bag4"></i></a></li>
                                <li><a class="wishlist" href="#"><i class="bi bi-shopping-cart-full"></i></a></li>
                                <li><a class="compare" href="#"><i class="bi bi-heart-beat"></i></a></li>
                                <li><a data-toggle="modal" title="Quick View" class="quickview modal-view detail-link" href="#productmodal"><i class="bi bi-search"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="product__hover--content">
                        <ul class="rating d-flex">
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li><i class="fa fa-star-o"></i></li>
                            <li><i class="fa fa-star-o"></i></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Single product end -->
            <!-- Single product start -->
            <div class="product product__style--3">
                <div class="product__thumb">
                    <a class="first__img" href="single-product.html"><img src="images/best-sell-product/3.jpg" alt="product image"></a>
                </div>
                <div class="product__content content--center">
                    <div class="action">
                        <div class="actions_inner">
                            <ul class="add_to_links">
                                <li><a class="cart" href="#"><i class="bi bi-shopping-bag4"></i></a></li>
                                <li><a class="wishlist" href="#"><i class="bi bi-shopping-cart-full"></i></a></li>
                                <li><a class="compare" href="#"><i class="bi bi-heart-beat"></i></a></li>
                                <li><a data-toggle="modal" title="Quick View" class="quickview modal-view detail-link" href="#productmodal"><i class="bi bi-search"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="product__hover--content">
                        <ul class="rating d-flex">
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li><i class="fa fa-star-o"></i></li>
                            <li><i class="fa fa-star-o"></i></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Single product end -->
            <!-- Single product start -->
            <div class="product product__style--3">
                <div class="product__thumb">
                    <a class="first__img" href="single-product.html"><img src="images/best-sell-product/4.jpg" alt="product image"></a>
                </div>
                <div class="product__content content--center">
                    <div class="action">
                        <div class="actions_inner">
                            <ul class="add_to_links">
                                <li><a class="cart" href="#"><i class="bi bi-shopping-bag4"></i></a></li>
                                <li><a class="wishlist" href="#"><i class="bi bi-shopping-cart-full"></i></a></li>
                                <li><a class="compare" href="#"><i class="bi bi-heart-beat"></i></a></li>
                                <li><a data-toggle="modal" title="Quick View" class="quickview modal-view detail-link" href="#productmodal"><i class="bi bi-search"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="product__hover--content">
                        <ul class="rating d-flex">
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li><i class="fa fa-star-o"></i></li>
                            <li><i class="fa fa-star-o"></i></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Single product end -->
            <!-- Single product start -->
            <div class="product product__style--3">
                <div class="product__thumb">
                    <a class="first__img" href="single-product.html"><img src="images/best-sell-product/5.jpg" alt="product image"></a>
                </div>
                <div class="product__content content--center">
                    <div class="action">
                        <div class="actions_inner">
                            <ul class="add_to_links">
                                <li><a class="cart" href="#"><i class="bi bi-shopping-bag4"></i></a></li>
                                <li><a class="wishlist" href="#"><i class="bi bi-shopping-cart-full"></i></a></li>
                                <li><a class="compare" href="#"><i class="bi bi-heart-beat"></i></a></li>
                                <li><a data-toggle="modal" title="Quick View" class="quickview modal-view detail-link" href="#productmodal"><i class="bi bi-search"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="product__hover--content">
                        <ul class="rating d-flex">
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li><i class="fa fa-star-o"></i></li>
                            <li><i class="fa fa-star-o"></i></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Single product end -->
            <!-- Single product start -->
            <div class="product product__style--3">
                <div class="product__thumb">
                    <a class="first__img" href="single-product.html"><img src="images/best-sell-product/6.jpg" alt="product image"></a>
                </div>
                <div class="product__content content--center">
                    <div class="action">
                        <div class="actions_inner">
                            <ul class="add_to_links">
                                <li><a class="cart" href="#"><i class="bi bi-shopping-bag4"></i></a></li>
                                <li><a class="wishlist" href="#"><i class="bi bi-shopping-cart-full"></i></a></li>
                                <li><a class="compare" href="#"><i class="bi bi-heart-beat"></i></a></li>
                                <li><a data-toggle="modal" title="Quick View" class="quickview modal-view detail-link" href="#productmodal"><i class="bi bi-search"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="product__hover--content">
                        <ul class="rating d-flex">
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li><i class="fa fa-star-o"></i></li>
                            <li><i class="fa fa-star-o"></i></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Single product end -->
            <!-- Single product start -->
            <div class="product product__style--3">
                <div class="product__thumb">
                    <a class="first__img" href="single-product.html"><img src="images/best-sell-product/7.jpg" alt="product image"></a>
                </div>
                <div class="product__content content--center">
                    <div class="action">
                        <div class="actions_inner">
                            <ul class="add_to_links">
                                <li><a class="cart" href="#"><i class="bi bi-shopping-bag4"></i></a></li>
                                <li><a class="wishlist" href="#"><i class="bi bi-shopping-cart-full"></i></a></li>
                                <li><a class="compare" href="#"><i class="bi bi-heart-beat"></i></a></li>
                                <li><a data-toggle="modal" title="Quick View" class="quickview modal-view detail-link" href="#productmodal"><i class="bi bi-search"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="product__hover--content">
                        <ul class="rating d-flex">
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li><i class="fa fa-star-o"></i></li>
                            <li><i class="fa fa-star-o"></i></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Single product end -->
            <!-- Single product start -->
            <div class="product product__style--3">
                <div class="product__thumb">
                    <a class="first__img" href="single-product.html"><img src="images/best-sell-product/8.jpg" alt="product image"></a>
                </div>
                <div class="product__content content--center">
                    <div class="action">
                        <div class="actions_inner">
                            <ul class="add_to_links">
                                <li><a class="cart" href="#"><i class="bi bi-shopping-bag4"></i></a></li>
                                <li><a class="wishlist" href="#"><i class="bi bi-shopping-cart-full"></i></a></li>
                                <li><a class="compare" href="#"><i class="bi bi-heart-beat"></i></a></li>
                                <li><a data-toggle="modal" title="Quick View" class="quickview modal-view detail-link" href="#productmodal"><i class="bi bi-search"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="product__hover--content">
                        <ul class="rating d-flex">
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li class="on"><i class="fa fa-star-o"></i></li>
                            <li><i class="fa fa-star-o"></i></li>
                            <li><i class="fa fa-star-o"></i></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Single product end -->
        </div>
    </section>
    <!-- Best Sale Area Area -->
    <!-- Footer Area -->
    <footer id="wn__footer" class="footer__area bg__cat--8 brown--color">
        <div class="footer-static-top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="footer__widget footer__menu">
                            <div class="ft__logo">
                                <a href="index.html">
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
                                    <li><a href="index.html">Trending</a></li>
                                    <li><a href="index.html">Best Seller</a></li>
                                    <li><a href="index.html">All Product</a></li>
                                    <li><a href="index.html">Wishlist</a></li>
                                    <li><a href="index.html">Blog</a></li>
                                    <li><a href="index.html">Contact</a></li>
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
