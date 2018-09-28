<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '404.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="assets/images/favicon/favicon.png">
  <link rel="stylesheet" href="/HotelManagement/user/assets/css/style.css">
  <link rel="stylesheet" href="/HotelManagement/user/assets/css/responsive.css">
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
    <section class="breadcrumbs" style="background-image: url(/HotelManagement/user/assets/images/breadcrumbs/faq.jpg)">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <h1 class="h1">F.A.Q</h1>
          </div>
          <div class="col-md-6">
            <ol class="breadcrumb">
              <li><a href="roomtype.action">Home</a><i class="fa fa-angle-right"></i></li>
              <li class="active">F.A.Q</li>
            </ol>
          </div>
        </div>
      </div>
    </section>
    <!-- /breadcrumbs -->
    <!-- 404 -->
    <section class="not-found">
      <div class="container">
        <div class="not-found_t">4<span>0</span>4</div>
        <div class="not-found_slogan">Oops, Error!</div>
        <div class="not_found_txt">The page you were looking for could not be found.</div>
      </div>
    </section>
    <!-- /404 -->
</div>
  <!-- /footer -->
  <!-- Scripts -->
  <script type="text/javascript" src="assets/js/jquery.min.js"></script>
  <script type="text/javascript" src="assets/js/tether.min.js"></script>
  <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="assets/js/jquery-ui.min.js"></script>
  <script type="text/javascript" src="assets/js/moment.min.js"></script>
  <script type="text/javascript" src="assets/js/jquery.smartmenus.js"></script>
  <script type="text/javascript" src="assets/js/jquery.parallax.min.js"></script>
  <script type="text/javascript" src="assets/js/jquery.shuffle.min.js"></script>
  <script type="text/javascript" src="assets/js/owl.carousel.min.js"></script>
  <script type="text/javascript" src="assets/js/main.js"></script>
  <!-- /Scripts -->
</body>
</html>