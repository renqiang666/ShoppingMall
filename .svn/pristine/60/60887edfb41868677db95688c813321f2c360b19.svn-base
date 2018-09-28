
<%@ page language="java" import="java.util.*, com.hotelsystem.bean.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>DeluxHotel - About Us - Responsive Bootstrap 4 Template For Hotels</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="shortcut icon" href="/HotelManagement/user/assets/images/favicon/favicon.png">
  <link rel="stylesheet" href="/HotelManagement/user/assets/css/style.css">
  <link rel="stylesheet" href="/HotelManagement/user/assets/css/responsive.css">
  <script type="text/javascript" src="/HotelManagement/user/assets/js/private/comment.js"></script> 
  
</head>
<body>
  <!-- main wrapper -->
  <div class="wrapper">
    <!-- header -->
    <header class="header">
        <%@ include file="head.jsp" %>
     <div class="header-bottom">
        <nav class="navbar navbar-universal navbar-custom">
          <div class="container">
            <div class="row">
              <div class="col-lg-3">
                <div class="logo"><a href="/HotelManagement/roomtype.action" class="navbar-brand page-scroll"><img src="/HotelManagement/user/assets/images/logo/logo.png" alt="logo"/></a></div>
              </div>
              <div class="col-lg-9">
                <div class="navbar-header">
                  <button type="button" data-toggle="collapse" data-target=".navbar-main-collapse" class="navbar-toggle"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                </div>
                <div class="collapse navbar-collapse navbar-main-collapse">
                  <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="/HotelManagement/roomtype.action">Home</a></li>
                    <li><a href="/HotelManagement/user/about-us.jsp">About Us</a></li>
                    <li><a href="/HotelManagement/user/contacts.jsp">Contacts</a></li>
                    <li><a href="/HotelManagement/ReserveInfo.action?page=1">Orders</a></li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </nav>
      </div>
    </header>
    <!-- /header -->
    <!-- breadcrumbs -->
    <section class="breadcrumbs" style="background-image: url(/HotelManagementuser/assets/images/breadcrumbs/about.jpg)">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <h1 class="h1">About Us</h1>
          </div>
          <div class="col-md-6">
            <ol class="breadcrumb">
              <li><a href="/HotelManagement/roomtype.action">Home</a><i class="fa fa-angle-right"></i></li>
              <li class="active">About Us</li>
            </ol>
          </div>
        </div>
      </div>
    </section>
    <!-- /breadcrumbs -->
    <!-- about -->
    <section class="about">
      <div class="container">
        <h2 class="h2">About Our DeluxHotel</h2>
        <div class="row">
          <div class="col-md-6">
            <div class="about_img"><img class="img-responsive" src="/HotelManagement/user/assets/images/about/1.jpg" alt=""/></div>
          </div>
          <div class="col-md-6">
            <div class="about_info">
              <div class="about_t">From 1990 to now...</div>
              <p>May musical arrival beloved luckily adapted him. Shyness mention married son she his started now. Rose if as past near were. To graceful he elegance oh moderate attended entrance pleasure. Vulgar saw fat sudden edward way played either. Thoughts smallest at or peculiar relation breeding produced an. <br><br>At depart spirit on stairs. She the either are wisdom praise things she before. Be mother itself vanity favour do me of. Begin was power joy after had walls miles. Wise busy past both park when an ye no. Nay likely her length sooner thrown lively income.</p>
              <a class="btn btn-default" href="/HotelManagement/user/contacts.jsp">Contact us</a>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- /about -->
    
    
    
     <!-- testiomonials -->
    <section class="testimonials">
      <div class="container">
        <div class="title-main"><h2 class="h2">Some Testimonails<span class="title-secondary">People Says About Us</span></h2></div>
        <div class="owl-carousel">
          <c:forEach items="${pageInfo.list }" var="obj">
          <div class="item">
            <div class="testimonials-block_i">
              <div class="testimonials-block_t"><fmt:formatDate value="${obj.date}" pattern="yyyy-MM-dd"/></div>
              <p>${obj.content}</p>
            </div>
            <div class="testimonials-block_user">
                
                <div class="user_n">${obj.userLogin.account}</div>
            </div>
          </div>
        </c:forEach>
        </div>
      </div>
      <div style="width:100%;text-align:center;">
       	<button id="first" onclick="firstPage(1)">首页</button>
     	<button id="last" onclick="lastPage(${pageInfo.pageNum-1 } )">上一页</button>
      	<span id="current">${pageInfo.pageNum }</span>/<span id="total">${pageInfo.pages }</span>
      	<button id="next" onclick="nextPage(${pageInfo.pageNum+1 })">下一页</button>
      	<button id="end" onclick="endPage(${pageInfo.pages })">末页</button>
      </div>
     
    </section>
    <!-- /testiomonials -->
    
    
    <!-- Our mission -->
    <section class="mission">
      <div class="container">
        <h2 class="h2">Our Mission</h2>
        <div class="row">
          <div class="col-md-6">
            <ul class="mission_ul">
              <li>Aenean lacinia bibendum nulla sed consectetur. Fusce dapibus, tellus </li>
              <li>If you have any questiong about our products or something else</li>
              <li>iStock customers get 15% off 6 or more credits, use the code</li>
              <li>Cras mattis consectetur purus sit amet fermentum. Etiam porta sem</li>
            </ul>
          </div>
          <div class="col-md-6">
            <ul class="mission_ul">
              <li>You can c reate various skin to use on color/parallax section easily.</li>
              <li>This will help you to be able to create various color tone within your site.</li>
              <li>Nullam id dolor id nibh ultricies vehicula ut id elit.</li>
              <li>ivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor</li>
            </ul>
          </div>
        </div>
      </div>
    </section>
    <!-- /Our mission -->
</div>
  <!-- /footer -->
  <!-- Scripts -->
  <script type="text/javascript" src="/HotelManagement/user/assets/js/jquery.min.js"></script>
  <script type="text/javascript" src="/HotelManagement/user/assets/js/tether.min.js"></script>
  <script type="text/javascript" src="/HotelManagement/user/assets/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="/HotelManagement/user/assets/js/jquery-ui.min.js"></script>
  <script type="text/javascript" src="/HotelManagement/user/assets/js/moment.min.js"></script>
  <script type="text/javascript" src="/HotelManagement/user/assets/js/jquery.smartmenus.js"></script>
  <script type="text/javascript" src="/HotelManagement/user/assets/js/jquery.parallax.min.js"></script>
  <script type="text/javascript" src="/HotelManagement/user/assets/js/jquery.shuffle.min.js"></script>
  <script type="text/javascript" src="/HotelManagement/user/assets/js/owl.carousel.min.js"></script>
  <script type="text/javascript" src="/HotelManagement/user/assets/js/main.js"></script>
  <script type="text/javascript">
  	check();
  </script>

  <!-- /Scripts -->
</body>
</html>