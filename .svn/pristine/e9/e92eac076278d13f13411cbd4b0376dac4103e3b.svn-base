<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=yes">
   <title>Detail</title>
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="shortcut icon" href="user/assets/images/favicon/favicon.png">
	<link rel="stylesheet" href="user/assets/css/style.css">
	<link rel="stylesheet" href="user/assets/css/responsive.css">
	<link rel="stylesheet" id=cal_style type="text/css"	href="/HotelManagement/admin/time/dist/flatpickr.min.css">
	<script type="text/javascript" src="user/assets/js/jQuery-2.2.2.js"></script>
</head>



<body>
<!--     	<input id="flatpickr-tryme" class="flatpickr" data-date-format="d-m-Y" -->
<!-- 		placeholder="European Format ('d-m-Y')"> -->
<!-- 	<br /> -->
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
    <section class="breadcrumbs" style="background-image: url(user/assets/images/breadcrumbs/best-room.jpg)">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <h1 class="h1">Room Details</h1>
          </div>
          <div class="col-md-6">
            <ol class="breadcrumb">
              <li><a href="roomtype.action">Home</a><i class="fa fa-angle-right"></i></li>
              <li><a href="roomtype.action">Rooms</a><i class="fa fa-angle-right"></i></li>
              <li class="active"><a href="roomTypeDetail.action?id=${map.roomTypeBean.id }">Room Detail</a></li>
            </ol>
          </div>
        </div>
      </div>
    </section>
    <!-- /breadcrumbs -->
    <!-- room details-->
                    
    <section class="room-detail">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 col-md-12 col-sm-12">
            <div class="row reservation-top">
              <div class="module __reservation">
                <div class="module-block">
                 <form class="form-planner form-horizontal">
                      <div class="col-md-3 col-xs-12">
                        <div class="form-group">
                            <label>Check in</label>
<!--                              <input class="form-control __plannerInput" id="datetimepicker1" type="text" placeholder="10-05-2015"/> -->
                                    <input id="stime" class="flatpickr" class="form-control __plannerInput" data-date-format="Y-m-d" placeholder="入住时间">  
                        </div>
          
                      </div>
                      <div class="col-md-3 col-xs-12">
                        <div class="form-group">
                            <label>Check out</label>
                            <input id="etime" class="flatpickr" class="form-control __plannerInput" data-date-format="Y-m-d" placeholder="离店时间"> 
                        </div>
                      </div>
                         <div class="col-md-2 col-xs-12">
                        <div class="form-group">
                            <a onclick="roomIdentity()" class="btn btn-default wizzard-search-btn" style="margin-top:0px;">Search</a>
                        </div>
                      </div>
                      <div id="mes" style="float:left;width:200px;height:34px;color:red;"></div>
                     </form> 
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-12 marg50"><h2 class="h2">${map.roomTypeBean.name }</h2></div>
          <div class="col-lg-6 col-md-6 col-sm-6">
          	 
              <div class="owl-carousel owl_gallery">
               	<div class="item">
               	 	<img class="img-responsive" src="${map.roomTypeBean.img }"/>
               	</div>
              </div>
          </div>
          <div class="col-lg-6 col-md-6">
            <div class="room-detail_overview">
              <table class="simple">
                <tr>
                  <td><strong>Price:</strong></td>
                  <td>
                  	<span>￥  ${map.roomTypeBean.price }</span> / a night
                  </td>           
                </tr>
                <tr>
                  <td><strong>Room size:</strong></td>
                  <td>${map.roomTypeBean.area } sqm</td>
                </tr>
                <tr>
                  <td><strong>Bed:</strong></td>
                  <td>${map.roomTypeBean.bedType }</td>
                </tr>
                <tr>
                  <td><strong>Max people:</strong></td>
                  <td>${map.roomTypeBean.people } people</td>
                </tr>
                <tr>
                  <td><strong>Wi-Fi:</strong></td>
                  <td>${map.roomTypeBean.netType }</td>
                </tr>
                <tr>
                  <td><strong>Room Service:</strong></td>
                  <td>Avaible</td>
                </tr>
                <tr>
                  <td><strong>Breakfast:</strong></td>
                  <td>
                  	<c:choose>
                  		<c:when test="${map.roomTypeBean.breakfirst == '提供早餐'}">
                  			Included
                  		</c:when>
                  		<c:otherwise>
                  			Nothing
                  		</c:otherwise>
                  	</c:choose>
                  </td>
                </tr>
                <tr>
                  <td><strong>Smoking:</strong></td>
                  <td><c:choose>
                  		<c:when test="${map.roomTypeBean.noSmoking == '禁烟'}">
                  			NoSmoking
                  		</c:when>
                  		<c:otherwise>
                  			Smoking
                  		</c:otherwise>
                  	</c:choose></td>
                </tr>
                 <tr>
                  <td><strong>Balance Room:</strong></td>
                  <td>${map.restRoom }</td>
                </tr>                
                
                <tr>
                  <td><strong>comment:</strong></td>
                 <td><button id="comment" onclick="comment()" class="btn btn-default">commit</button></td>
                </tr> 
              </table>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- /room details -->
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
  function comment() {
	  $.ajax({
			url:"/HotelManagement/comment.action",
			method:"post",
			async:true,
			contentType:"application/json;charset=utf-8",
			dateType:"json",
			success:function(message){
				document.location = "/HotelManagement/user/about-us.jsp"
			}
		});
}
  </script>
</body>
<script type="text/javascript">
	function fp_ready() {
		// setting custom defaults
		Flatpickr.l10n.firstDayOfWeek = 1;

		//Regular flatpickr
		document.getElementById("stime").flatpickr();
		document.getElementById("etime").flatpickr();
		document.getElementsByClassName("calendar").flatpickr();

		var calendars = document.getElementsByClassName("flatpickr").flatpickr();
	}
	function roomIdentity() {
		    var stime=$("#stime").val();
		    var etime=$("#etime").val();
		    if(stime==""||etime==""){
		    	$("#mes").html("时间不能有空值！");
		    }else if(stime>etime){
		    	$("#mes").html("入住时间不能小于退房时间！");
		    }else if(stime<getNowFormatDate()){
		    	$("#mes").html("入住时间不能小于当前日期！");
		    }else{
		    	var jsonObj = {"roomTypeId":${map.roomTypeBean.id},"checkIn":$("#stime").val(),"checkOut":$("#etime").val()};
				
	  			$.ajax({
	  				url:"/HotelManagement/checkAvailable.action",
	  				method:"post",
	  				async:true,
	  				contentType:"application/json;charset=utf-8",
	  				data:JSON.stringify(jsonObj),
	  				success:function(message){
	  					if(message=="false"){
	  						$("#mes").html("暂无房间！");
	  					}else{
	  						window.location.href=message;
	  					}
	  				}
	  			});
		    }
		
	}
	//获取当前时间，格式YYYY-MM-DD
	function getNowFormatDate() {
	    var date = new Date();
	    var seperator1 = "-";
	    var year = date.getFullYear();
	    var month = date.getMonth() + 1;
	    var strDate = date.getDate();
	    if (month >= 1 && month <= 9) {
	        month = "0" + month;
	    }
	    if (strDate >= 0 && strDate <= 9) {
	        strDate = "0" + strDate;
	    }
	    var currentdate = year + seperator1 + month + seperator1 + strDate;
	    return currentdate;
	}
</script>
<script async src="/HotelManagement/admin/time/dist/flatpickr.js" onload="fp_ready()"></script>
</html>
