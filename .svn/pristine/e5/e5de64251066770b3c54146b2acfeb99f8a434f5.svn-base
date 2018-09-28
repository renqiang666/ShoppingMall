<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Pay Success</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="shortcut icon" href="user/assets/images/favicon/favicon.png">
<link rel="stylesheet" href="user/assets/css/style.css">
<link rel="stylesheet" href="user/assets/css/responsive.css">

</head>
<body>
	<!-- main wrapper --
	>
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
	<section class="breadcrumbs"
		style="background-image: url(user/assets/images/breadcrumbs/reservation.jpg)">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h1 class="h1">Reservation</h1>
			</div>
			<div class="col-md-6">
				<ol class="breadcrumb">
					<li><a href="roomtype.action">Home</a><i class="fa fa-angle-right"></i></li>
					<li class="active">Finish Reservation</li>
				</ol>
			</div>
		</div>
	</div>
	</section>
	<!-- /breadcrumbs -->
	<!-- reservation wizzard steps-->
	<div class="wizzard">
		<div class="container-fluid reservation_last_step_container">
			<div class="container">
				<div class="row reservation-top">
					<div class="module __reservation">
						<div class="module-block">
								<h1 style="color: green;">预订成功</h1>
								<table>
									<tr>
										<td>订单编号: ${out_trade_no }</td>
									</tr>
										
									<tr>
										<td>支付宝交易号: ${trade_no }</td>
									</tr>
										
									<tr>
										<td>实付金额: ${total_amount }</td>
									</tr>
									<tr>
										<td>房间名称：${productName }</td>
									</tr>
								</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="wizzard-success">
						
						<a href="roomtype.action" class="btn btn-default">Continue</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /reservation wizzard steps-->
	<!-- Scripts -->
	<script type="text/javascript" src="user/assets/js/jquery.min.js"></script>
	<script type="text/javascript" src="user/assets/js/tether.min.js"></script>
	<script type="text/javascript" src="user/assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="user/assets/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="user/assets/js/moment.min.js"></script>
	<script type="text/javascript" src="user/assets/js/jquery.smartmenus.js"></script>
	<script type="text/javascript" src="user/assets/js/jquery.parallax.min.js"></script>
	<script type="text/javascript" src="user/assets/js/jquery.shuffle.min.js"></script>
	<script type="text/javascript" src="user/assets/js/owl.carousel.min.js"></script>
	<script type="text/javascript" src="user/assets/js/main.js"></script>
	<!-- /Scripts -->
</body>
</html>

