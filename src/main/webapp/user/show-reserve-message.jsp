<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>显示预订信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  <link rel="shortcut icon" href="user/assets/images/favicon/favicon.png">
  <link rel="stylesheet" href="user/assets/css/style.css">
  <link rel="stylesheet" href="user/assets/css/responsive.css">
  <link rel="stylesheet" id=cal_style type="text/css"	href="admin/css/flatpickr.min.css" >
  <link rel="stylesheet" href="user/assets/css/confirmation.css"> 
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
            <h1 class="h1">Reservation</h1>
          </div>
          <div class="col-md-6">
            <ol class="breadcrumb">
              <li><a href="roomtype.action">Home</a><i class="fa fa-angle-right"></i></li>
              <li class="active">Reservation</li>
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
                  <form class="form-planner form-horizontal">
                    <div class="row">
                      <div class="col-md-3 col-xs-12">
                        <div class="form-group">
                            <label>Check in</label>
                            <input class="form-control" readonly="readonly" type="text" value="<fmt:formatDate value="${bean.checkIn }" pattern="yyyy-MM-dd"/>" id="checkIn"/>
                        </div>
                      </div>
                      <div class="col-md-3 col-xs-12">
                        <div class="form-group">
                            <label>Check out</label>
                            <input class="form-control" readonly="readonly" type="text" value="<fmt:formatDate value="${bean.checkOut }" pattern="yyyy-MM-dd"/>" id="checkOut"/>
                        </div>
                      </div>
                      <div class="col-md-2 col-xs-6">
                        <div class="form-group">
                            <label>Type</label><input type="hidden" id="typeId" value="${roomTypeBean.id }">
                            <input class="form-control" readonly="readonly" type="text" value="${roomTypeBean.name }" />
                        </div>
                      </div>
                      <div class="col-md-2 col-xs-6">
                        <div class="form-group">
                            <label>Price</label>
                            <input class="form-control" readonly="readonly" type="text" value="" id="money"/>
                        </div>
                      </div>
                      <div class="col-md-2 col-xs-12">
                        <div class="form-group">
                            <a href="roomtype.action" class="btn btn-default wizzard-search-btn">RESELECTION</a>
                          </div>
                        </div>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      <div class="container">
        <div class="row">
          <div class="col-md-12">
              <h3 class="h3">Personal information</h3>
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group">
                    <label>Arrive Time</label>
                    <input class="form-control flatpickr" value="" data-enable-time=true
						data-time_24hr=true data-enable-seconds=true placeholder="24 hour time" id="arrive"/>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label>Cancel Time</label>
                    <input class="form-control flatpickr" value="" data-enable-time=true
						data-time_24hr=true data-enable-seconds=true placeholder="24 hour time" id="cancel"/>
                  </div>
                </div>
              </div>
              
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group">
                    <label>CheckInPerson</label>&nbsp;&nbsp;<i style="color: red;">At Least One Person</i>&nbsp;&nbsp;<button style="color: blue;" id="addperson" onclick="add()">Add</button>
                    <input class="form-control checkInPerson" type="text" placeholder="Enter one person" id="firstman"/>
                  </div>
                </div>
              <div  id="person">
             
              </div> 
             
              <div class="row">
                <div class="col-md-12">
                  <div class="form-group">
                    <label>Additional note</label>
                    <textarea class="form-control" rows="5" placeholder="Type here" id="message"></textarea>
                  </div>
                </div>
              </div>
              <div class="wizzard-confirm">
                <a href="javascript:;" id="aaa" class="btn btn-default">Checkout</a>
              </div>
         </div>
        </div>
      </div>
    </div>
    </div>
    <div id="confirmation" style="margin: 0 auto;">
    <table>
    	<tr>
    		<td>CheckIn Time</td>
    		<td><input type="text" readonly="readonly" value="<fmt:formatDate value="${bean.checkIn }" pattern="yyyy-MM-dd"/>"></td>
    		<td><i>请确认入住时间</i></td>
    	</tr>
   		<tr>
    		<td>CheckOut Time</td>
    		<td><input type="text" readonly="readonly" value="<fmt:formatDate value="${bean.checkOut }" pattern="yyyy-MM-dd"/>"></td>
    		<td><i>请确认退房时间</i></td>
    	</tr>
   		<tr>
    		<td>Arrive Time</td>
    		<td><input type="text" readonly="readonly" value="" id="cArrive"></td>
    		<td><i>请确认预抵时间</i></td>
    	</tr>
    	<tr>
    		<td>Cancel Time</td>
    		<td><input type="text" readonly="readonly" value="" id="cCancel"></td>
    		<td><i>请确认预订取消时间</i></td>
    	</tr>
    	<tr>
    		<td>Room Type</td>
    		<td><input type="text" readonly="readonly" value="${roomTypeBean.name }"></td>
    		<td><i>请确认入住时间</i></td>
    	</tr>
    	<tr>
    		<td>Unit Price</td>
    		<td><input type="text" readonly="readonly" value="${roomTypeBean.price }"></td>
    		<td><i>请确认房间单价</i></td>
    	</tr>
    	<tr>
    		<td>Total Price</td>
    		<td><input type="text" readonly="readonly" value="" id="total"></td>
    		<td><i>请确认房间总价</i></td>
    	</tr>
    	<tr>
    		<td>One Person</td>
    		<td><input type="text" readonly="readonly" value="" id="firstperson"></td>
    		<td><i>请确认首个入住人姓名</i></td>
    	</tr>
    	<tr>
    		<td><input type="submit" onclick="addReserve()" value="PayMoney"/></td>
    		<td><strong style="color: red;" id="mes"></strong></td>
    		<td><input type="button" id="back" value="EditBooking"/></td>
    	</tr>
    </table>
    </div>
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
  <script type="text/javascript" src="user/assets/js/private/reserve.js"></script>
  <!-- /Scripts -->
  <script type="text/javascript">
  	var i=1;
	function add(){
	if(i<${roomTypeBean.people}){
		var content=$.parseHTML("<div class='row'><div class='col-md-6'>"+
         " <div class='form-group'>"+
            "<label>CheckInPerson</label>"+
            "<input class='form-control checkInPerson' type='text' placeholder='Enter other person' />"+
          "</div></div></div>");
		$("#person").append(content);
		i++; 
     }else{
     	alert("该类型房间最多入住${roomTypeBean.people}人");
     }
	}
	
  		function fp_ready() {
			// setting custom defaults
			Flatpickr.l10n.firstDayOfWeek = 1;

			//Regular flatpickr
			document.getElementById("arrive").flatpickr();
			document.getElementsByClassName("cancel").flatpickr();
			var calendars = document.getElementsByClassName("flatpickr").flatpickr();
		}
		var money=${roomTypeBean.price }*getDays($("#checkIn").val(), $("#checkOut").val());
		var content = "unit:${roomTypeBean.price}/toatl:"+money+".0";
		$("#money").val(content);
		$("#total").removeAttr('readonly');
		$("#total").val("￥"+money+".0");
		$("#total").attr('readonly','readonly');
		
  </script>
  <script async src="admin/js/public/flatpickr.js" onload="fp_ready()"></script>
	
</body>
</html>