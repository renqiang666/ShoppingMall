<%@ page language="java" import="java.util.*, com.hotelsystem.bean.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>DeluxHotel - Blog - Responsive Bootstrap 4 Template For Hotels</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="shortcut icon" href="user/assets/images/favicon/favicon.png">
  <link rel="stylesheet" href="user/assets/css/style.css">
  <link rel="stylesheet" href="user/assets/css/responsive.css">
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
  <section class="breadcrumbs" style="background-image: url(user/assets/images/breadcrumbs/blog.jpg)">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h1 class="h1">Orders</h1>
        </div>
        <div class="col-md-6">
          <ol class="breadcrumb">
            <li><a href="roomtype.action">Home</a><i class="fa fa-angle-right"></i></li>
            <li class="active">Orders</li>
          </ol>
        </div>
      </div>
    </div>
  </section>
  <!-- /breadcrumbs -->
  <!-- Blog -->
  <section class="blog">
    <div class="container">
      <div class="row">
        <div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
          <div class="blog-box __post">
            <div class="post-list">
              <c:forEach items="${pages.list}" var="vie">
              <div class="post-list_box">
                <div class="row">
                  <div class="col-lg-6 col-md-6 col-ms-12 col-xs-12">
                    <div class="post-list_info">
                      <div class="post-list_n"><a href="blog-detail.html">${vie.id}</a></div>
                      <div class="post-list_meta">
                        <ul class="meta_author">
                          <li><i class="fa fa-user-o"></i> <span>订房人名字:${vie.reservePeopleName}</span></li>
                          <li><i class="fa fa-folder-o"></i> <span>Travel</span></li>
                          <li><i class="fa fa-clock-o"></i> <span>入住时间：<fmt:formatDate value="${vie.checkIn}" pattern="yyyy-MM-dd"/></span></li>
                          <li><i class="fa fa-clock-o"></i> <span>离开时间：<fmt:formatDate value="${vie.checkOut}" pattern="yyyy-MM-dd"/></span></li>
                        </ul>
                      </div>
                      <div class="post-list_desc">
                     		 房间类型：${vie.roomType},
                    		 已付金额：${vie.money},
                      		房间单价:${vie.price},<br>
                     		 预计到店时间：<fmt:formatDate value="${vie.arrive }" pattern="yyyy-MM-dd HH:mm:ss"/>
                      </div>
                      <div class="post-list_readmore"><a href="javascript:;" onclick="refundMoney('${vie.id}')">Refued Reserve</a></div>
                      <br/>
                      <div class="wizzard-confirm">
						<form action="/HotelManagement/modifyReserve.action"> 
							<input type="text" name="reserveRoomId" style="display:none" value="${vie.id}">
							<button type="submit" class="btn btn-default">修改预定</button>
						</form>	
						</div>
                    </div>
                  </div>
                </div>
              </div>
              </c:forEach>
            </div>
            <nav class="text-center">
              <ul class="pagination">
                <li><a href="ReserveInfo.action?page=${pages.firstPage}">&lt;</a></li>
                <li><a href="ReserveInfo.action?page=${pages.prePage}">&laquo;</a></li>
                <li><a href="#" class="active">${pages.pageNum}</a></li>
                <li><a href="ReserveInfo.action?page=${pages.nextPage}">&raquo;</a></li>
                <li><a href="ReserveInfo.action?page=${pages.lastPage}">&gt;</a></li>
              </ul>
              <p>一共有${pages.pages}页，共${pages.total}条记录</p>
            </nav>
          </div>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
          <div class="post-sidebar_lpost">
            <form action="" class="form-horizontal post-search form-wizzard">
              <div class="form-group has-feedback">
                <div class="search-group">
                  <input type="search" class="form-control" placeholder="Search ..."/>
                </div>
                <i class="fa fa-search form-control-search"></i>
              </div>
            </form>
          </div>
          <!-- /Sidebar tags -->
        </div>
      </div>
    </div>
  </section>
   <!-- enjoy our services -->
    <section class="section">
      <div class="container">
        <div class="title-main"><h2 class="h2">Our Services<span class="title-secondary">Great. Safe. Free.</span></h2></div>
        <div class="row">
          <div class="col-lg-4 col-md-4 col-sm-6">
            <h3 class="service_title"><i class="fa fa-globe"></i> Different Tours</h3>
            <p>Improve ashamed married expense bed her comfort pursuit mrs. Four time took ye your as fail lady.</p>
          </div>
          <div class="col-lg-4 col-md-4 col-sm-6">
            <h3 class="service_title"><i class="fa fa-taxi"></i> Taxi Service</h3>
            <p>Improve ashamed married expense bed her comfort pursuit mrs. Four time took ye your as fail lady.</p>
          </div>
          <div class="col-lg-4 col-md-4 col-sm-6">
            <h3 class="service_title"><i class="fa fa-glass"></i> Bar Included</h3>
            <p>Improve ashamed married expense bed her comfort pursuit mrs. Four time took ye your as fail lady.</p>
          </div>
          <div class="col-lg-4 col-md-4 col-sm-6">
            <h3 class="service_title"><i class="fa fa-life-ring"></i> Discount System</h3>
            <p>Improve ashamed married expense bed her comfort pursuit mrs. Four time took ye your as fail lady.</p>
          </div>
          <div class="col-lg-4 col-md-4 col-sm-6">
            <h3 class="service_title"><i class="fa fa-leaf"></i> Professional Staff</h3>
            <p>Improve ashamed married expense bed her comfort pursuit mrs. Four time took ye your as fail lady.</p>
          </div>
          <div class="col-lg-4 col-md-4 col-sm-6">
            <h3 class="service_title"><i class="fa fa-eye"></i> Parking 24/7</h3>
            <p>Improve ashamed married expense bed her comfort pursuit mrs. Four time took ye your as fail lady.</p>
          </div>
        </div>
      </div>
    </section>
    <!-- /enjoy our services -->
  </div>
  <!-- /Blog -->
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
<script type="text/javascript">
  
  function refundMoney(id) {
      $.ajax({
          url:"refundOrder.action",
          type:"post",
          anync:true,
          dataType: "json",
          data:"reserveRoomId="+id,
          success:function (data) {
              if(data==true){
                  alert("退款成功");
              }
              else{
                  alert("退款失败，不合法");
              }
          }
      })
  }
</script>
<!-- /Scripts -->
</body>
</html>