<%@ page language="java" import="java.util.*, com.hotelsystem.bean.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html lang="en">
<head>
  <title>Index</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="shortcut icon" href="user/assets/images/favicon/favicon.png">
  <link rel="stylesheet" href="user/assets/css/style.css">
  <link rel="stylesheet" href="user/assets/css/responsive.css">
  <link rel="stylesheet" id=cal_style type="text/css"	href="admin/css/flatpickr.min.css" >
  <style>
        #allmap {
            width: 100%;
            height: 400px;
            margin: 0 auto;
            overflow: hidden;
        }
    </style>
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
        <!-- parallax -->
      <section class="bg-parallax parallax-window">
        <div class="overlay"></div>
        <div class="container">
          <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
              <div class="parallax-text">
                <h2 class="parallax_t __white">New Grand Hotel 5*</h2>
                <h2 class="parallax_t __green">available from 10.12.2016</h2>
                <p>Offices parties lasting outward nothing age few resolve. Impression to discretion understood to we interested he excellence. Him remarkably use projection collecting going about eat forty world.</p>
              </div>
            </div>
            <!-- planner-->
            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 planner">
              <div class="planner-block">
               
                  <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                      <div class="form-group">
                        <label>Check in</label>
                        <input class="flatpickr form-control __plannerInput" id="datetimepicker1" placeholder="入住时间" data-date-format="Y-m-d" value=""/>
                      </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                      <div class="form-group">
                        <label>Check out</label>
                        <input class="flatpickr form-control __plannerInput" id="datetimepicker2" placeholder="退房时间" data-date-format="Y-m-d" value=""/>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                      <div class="form-group">
                          <label>Room type</label>
                          <div class="theme-select">
                            <select class="form-control __plannerSelect" id="roomType">
                              <c:forEach items="${list }" var="roomType">
                              	<option value="${roomType.id }">${roomType.name }</option>
                              </c:forEach>
                            </select>
                          </div>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12">
                      <div class="planner-check-availability">
                        <input type="submit" class="btn btn-default" value="Check availability" onclick="check()">
                      </div>
                    </div>
                  </div>
               
              </div>
            </div>
            <!-- /planner-->
             </div>
        </div>
    </section>
    <!-- /parallax -->
            
    <!-- chose best rooms -->
    <section class="best-room">
      <div class="container">
        <div class="title-main">
          <h2 class="h2">Best Offer For Weekend<span class="title-secondary">Look Our Featured Rooms</span></h2>
        </div>
        <div class="best-room-carousel">
          <ul class="row best-room_ul">
         	 <c:forEach items="${list }" var="obj">
            <li class="col-lg-4 col-md-4 col-sm-6 col-xs-12 best-room_li">
              <div class="best-room_img">
              <!-- 查看房间细节 -->
                <a href="roomTypeDetail.action?id=${obj.id}"><img src="${obj.img }" alt="" style="height:239px;"></a>
                <div class="best-room_overlay">
                  <div class="overlay_icn"><a href="roomTypeDetail.action?id=${obj.id}"></a></div>
                </div>
              </div>
              <div class="best-room-info">
                <div class="best-room_t"><a href="roomTypeDetail.action?id=${obj.id}">${obj.name}</a></div>
                <div class="best-room_price">
                  <span>￥${obj.price}</span> / one day
                </div>
              </div>
            </li>           
       		 </c:forEach>
          </ul>
        </div>
      </div>
    </section>

   
    <!-- /lux banner parallax -->
    <div id="allmap"></div>
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
  <!-- /footer -->
  <!-- Scripts -->
  <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=yCOqeTdMoZzpX8iatyTPHPsp4Fjg22nu"></script>
  <script type="text/javascript" src="user/assets/js/jquery.min.js"></script>
  <script type="text/javascript" src="user/assets/js/tether.min.js"></script>
  <script type="text/javascript" src="user/assets/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="user/assets/js/jquery-ui.min.js"></script>
  <script type="text/javascript" src="user/assets/js/moment.min.js"></script>
  <script type="text/javascript" src="user/assets/js/jquery.smartmenus.js"></script>
  <script type="text/javascript" src="user/assets/js/jquery.parallax.min.js"></script>
  <script type="text/javascript" src="user/assets/js/jquery.shuffle.min.js"></script>
  <script type="text/javascript" src="user/assets/js/owl.carousel.min.js"></script>
  <script type="text/javascript" src="http://ditu.google.cn/maps/api/js"></script>
  <script type="text/javascript" src="user/assets/js/map.js"></script>
  <script type="text/javascript" src="user/assets/js/main.js"></script>
   <script type="text/javascript" src="user/assets/js/private/index.js"></script>
  <!-- /Scripts -->
  <script type="text/javascript">
    // 百度地图API功能
    var map = new BMap.Map("allmap");
    var point = new BMap.Point(104.070199,30.57258);
    map.centerAndZoom(point, 17);
    var marker = new BMap.Marker(point);  // 创建标注
    map.addOverlay(marker);              // 将标注添加到地图中
    var label = new BMap.Label("环球中心店",{offset:new BMap.Size(20,-10)});
    marker.setLabel(label);
    map.enableScrollWheelZoom();
</script>
  <script type="text/javascript">
	function fp_ready() {
		// setting custom defaults
		Flatpickr.l10n.firstDayOfWeek = 1;

		//Regular flatpickr
		document.getElementById("datetimepicker1").flatpickr();
		document.getElementsByClassName("datetimepicker2").flatpickr();

		var calendars = document.getElementsByClassName("flatpickr").flatpickr();
	}
</script>
<script async src="admin/js/public/flatpickr.js" onload="fp_ready()"></script>


</body>
</html>