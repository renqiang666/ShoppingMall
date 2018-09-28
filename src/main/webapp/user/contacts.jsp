<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>My JSP 'contacts.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>DeluxHotel - Contacts - Responsive Bootstrap 4 Template For Hotels</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="shortcut icon" href="assets/images/favicon/favicon.png">
	<link rel="stylesheet" href="assets/css/style.css">
	<link rel="stylesheet" href="assets/css/responsive.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

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
    <section class="breadcrumbs" style="background-image: url(assets/images/breadcrumbs/reservation.jpg)">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <h1 class="h1">Contacts</h1>
          </div>
          <div class="col-md-6">
            <ol class="breadcrumb">
              <li><a href="#">Home</a><i class="fa fa-angle-right"></i></li>
              <li class="active">Contacts</li>
            </ol>
          </div>
        </div>
      </div>
    </section>
    <!-- /breadcrumbs -->
    <section class="contact-block">
      <div class="container">
        <div class="contact-block_form">
          <div class="row">
              <div class="contact-block_info">
                <div class="col-md-4">
                  <div class="contact-block_i">
                    <div class="info_icon">
                      <i class="fa fa-home"></i>
                    </div>
                    <div class="info_txt"><span>455 Martinson, Los Angeles</span></div>
                  </div>
                </div>
                <div class="col-md-4">
                  <div class="contact-block_i">
                    <div class="info_icon">
                      <i class="fa fa-envelope-o"></i>
                    </div>
                    <div class="info_txt"><span>support@email.com</span></div>
                  </div>
                </div>
                <div class="col-md-4">
                  <div class="contact-block_i">
                    <div class="info_icon">
                      <i class="fa fa-phone"></i>
                    </div>
                    <div class="info_txt"><span>8 (043) 567 - 89 - 30</span></div>
                  </div>
                </div>
              </div>
            </div>
              <div class="row marg50">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"><h2 class="h2">Write your comment...</h2></div> 
                <div class="col-lg-2 col-md-2 col-sm-1 col-xs-1"></div>
                <div class="col-lg-8 col-md-8 col-sm-11 col-xs-11">
                  <form  method="POST" class="form-horizontal form-wizzard">

                    <div id="comment-group" class="form-group">
                      <textarea rows="10" name="comment" id="comment1" class="form-control" placeholder="Additional note type here ..."></textarea>
                    </div>
                    <div class="form-group text-center">
                      <input  value="submit comment" onclick="sendComment()" class="btn btn-default"/>
                    </div>
                  </form>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-1 col-xs-1"></div>
              </div>
            </div>
          </div>
    </section>
  
</div>
  <!-- /footer -->
  <!-- Scripts -->
  <script type="text/javascript">
   function sendComment(){
  	$.ajax({
			url:"/HotelManagement/sendComment.action",
			type:"post",
			dataType:"json",
			data:{
				content:$("#comment1").val(),	
			},
			success:function(data){
			
				 alert(data);
				
			}
		}); 
  
  
  } 
  </script>
  <script type="text/javascript" src="assets/js/jquery.min.js"></script>
  <script type="text/javascript" src="assets/js/tether.min.js"></script>
  <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="assets/js/jquery-ui.min.js"></script>
  <script type="text/javascript" src="assets/js/moment.min.js"></script>
  <script type="text/javascript" src="assets/js/jquery.smartmenus.js"></script>
  <script type="text/javascript" src="assets/js/jquery.parallax.min.js"></script>
  <script type="text/javascript" src="assets/js/jquery.shuffle.min.js"></script>
  <script type="text/javascript" src="assets/js/owl.carousel.min.js"></script>
  <script type="text/javascript" src="http://ditu.google.cn/maps/api/js"></script>
  <script type="text/javascript" src="assets/js/map.js"></script>
  <script type="text/javascript" src="assets/js/main.js"></script>
  
  
  

  
  
  
  <!-- /Scripts -->
</body>
</html>
