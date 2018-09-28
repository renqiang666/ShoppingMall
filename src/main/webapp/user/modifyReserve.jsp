<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>My JSP 'ModifyReserve.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>DeluxHotel - Reservation Page 3 - Responsive Bootstrap 4 Template For Hotels</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="shortcut icon" href="user/assets/images/favicon/favicon.png">
  <link rel="stylesheet" href="user/assets/css/style.css">
  <link rel="stylesheet" href="user/assets/css/responsive.css">
  <link rel="stylesheet" id=cal_style type="text/css"	href="admin/css/flatpickr.min.css" >
  <script type="text/javascript" src="user/assets/js/jQuery-2.2.2.js"></script>
  <script>

	/*离焦事件，当选定数量时，入住人输入框可变  */
  $(function () {
      $("input[name = 'count']").blur(function () {
          var values = $("input[name = 'count']").val();
          $("#checkInPerson").empty();
          for(var i = 0;i < values;i++){
			
			/* class = 'checkInPeople' */

              $("#checkInPerson").append("<label>入住人</label><input class= 'form-control-n'  type='text' placeholder='请输入入住人姓名'   /></td>");
          }
      })
  })

		/*一加载界面就把数据加载出来  */
$(function () {
	
    $("#checkInPerson").append("<c:forEach items='${list }' var = 'view' varStatus='status'><lable>入住人</lable><input type='text' name='checkInPeople' value = '${view.checkInPeople  }' /></c:forEach>");

})

  </script>
  </head>
  
  <body>
    <!-- main wrapper -->
  <div class="wrapper">
    <!-- header -->
    <header class="header">
      <%@include file="head.jsp" %>
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
    <section class="breadcrumbs" style="background-image: url(user/assets/images/breadcrumbs/reservation.jpg)">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <h1 class="h1">Modify</h1>
          </div>
          <div class="col-md-6">
            <ol class="breadcrumb">
              <li><a href="/HotelManagement/roomtype.action">Home</a><i class="fa fa-angle-right"></i></li>
              <li class="active">Modify</li>
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
                    <div class="row">
                    <input type="hidden" id="roomId" value="${list[0].id }">
                    <input type="hidden" id="peopleId" value="${list[0].reservePeopleId }">
                    <input type="hidden" id="personId" value="${list[0].checkInPersonId }">
                    <div class="col-md-3 col-xs-6">
                        <div class="form-group">
                            <label>ReservePeople</label>
                            <input class="form-control"  type="text" readonly="readonly"  id="reservePeople" value = "${list[0].reservePeopleName  }"/>
                        </div>
                    </div>
                    <div class="col-md-3 col-xs-6">
                        <div class="form-group">
                            <label>Tel</label>
                            <input class="form-control"  type="text" readonly="readonly"  id="reservePeopleTel" value = "${list[0].tel  }"/>
                        </div>
                    </div>
                    <div class="col-md-3 col-xs-6">
                        <div class="form-group">
                            <label>RoomType</label>
                            <input class="form-control"  type="text" readonly="readonly"  id="roomType" value = "${list[0].roomType  }"/>
                        </div>
                      </div>
                       <div class="col-md-3 col-xs-6">
                        <div class="form-group">
                            <label>RoomNumber</label>
                            <input class="form-control"  type="text"   id="roomCount" name = "count" value = "${list[0].roomCount  }"/>
                        </div>
                      </div>
                    </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      <div class="container">
        <div class="row">
          <div class="col-md-12">

              <h3 class="h3">Change Information</h3>

               <div class="row">
                <div class="col-md-6">
                  <div class="form-group">
                    <label>CheckIn Time</label>
                    <input class="form-control " data-date-format="Y-m-d"	 id="checkIn" type="text"
                    	value="<fmt:formatDate value='${list[0].checkIn }' pattern='yyyy-MM-dd'/>"  />
                  	
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label>CheckOut Time</label>
                    <input class="form-control " id="checkOut" data-date-format="Y-m-d" type="text"
						 value="<fmt:formatDate value='${list[0].checkOut }' pattern='yyyy-MM-dd'/>"/>
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group">
                    <label>Arrive Time</label>
                    <input class="form-control "  data-enable-time=true
						data-time_24hr=true data-enable-seconds=true  id="arrive" type="text"
						value="<fmt:formatDate value='${list[0].arrive }'  pattern='yyyy-MM-dd HH:mm:ss'/>"/>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label>Cancel Time</label>
                    <input class="form-control " data-enable-time=true
						data-time_24hr=true data-enable-seconds=true id="cancel" type="text"
						value="<fmt:formatDate value='${list[0].cancel }'  pattern='yyyy-MM-dd HH:mm:ss'/>"/>
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group">
                    <label>CheckIn Person</label>
                    <input class="form-control " id="person" value="${list[0].checkInPeople }"/>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label>Annotation</label>
                    <input class="form-control " id="people_context" value="${list[0].context }"/>
                  </div>
                </div>
              </div>
            <div class="wizzard-confirm">
            	<strong id="mes" style="color: red;"></strong>
            	<a href="javascript:;" onclick="window.history.go(-1)" class="btn btn-default">Back</a>
            	<a href="javascript:;" onclick="modifyReserveInfo()" class="btn btn-default">Checkout</a>
      		</div>
          </div>
        </div>
      </div>
    </div>
      
    <!-- /reservation wizzard steps-->
  <!-- footer -->
  <hr>
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
   <script type="text/javascript" src="user/assets/js/private/modify.js"></script>
  <!-- /Scripts -->
  <script type="text/javascript">
  function fp_ready() {
			// setting custom defaults
			Flatpickr.l10n.firstDayOfWeek = 1;

			//Regular flatpickr
			document.getElementById("checkIn").flatpickr();
			document.getElementById("checkOut").flatpickr();
			document.getElementById("arrive").flatpickr();
			document.getElementById("cancel").flatpickr();
			var calendars = document.getElementsByClassName("flatpickr").flatpickr();
		}	
  </script>
  <script async src="admin/js/public/flatpickr.js" onload="fp_ready()"></script>
  
  
 
  </body>
</html>
