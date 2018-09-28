<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'detail_reserve.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="admin/js/public/jquery-3.3.1.js"></script>
<link href="admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="admin/css/select.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" id=cal_style type="text/css"	href="admin/css/flatpickr.min.css">
<script type="text/javascript" src="admin/js/public/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="admin/js/public/select-ui.min.js"></script>
<script type="text/javascript" src="admin/js/public/kindeditor.js"></script>
<script type="text/javascript" src="admin/js/private/update_people_room.js"></script>
<script async type="text/javascript">
	$(document).ready(function(e) {
		$(".select1").uedSelect({
			width : 345
		});
		$(".select2").uedSelect({
			width : 167
		});
		$(".select3").uedSelect({
			width : 100
		});
	});
</script>


</head>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">预订管理</a></li>
			<li><a href="admin/show_reserve.jsp">预订查询</a></li>
			<li><a href="showReserveMessageDetail.action?id=${map['reserveRoomBean'].id }&reservePeopleId=${map['reservePeopleBean'].id }">预定详情</a></li>
		</ul>
	</div>
	<div class="formbody">

		<div id="usual1" class="usual">

			<div class="itab">
				<ul>
					<li><a href="#tab1" class="selected">预订人信息</a></li>
					<li><a href="#tab2">预订信息</a></li>
					<li><a href="#tab3">房间类型信息</a></li>
					<li><a href="#tab4">入住人信息</a></li>
				</ul>
			</div>
			<div id="tab1" class="tabson">
				<ul class="forminfo" id="guest_info">
					<li><label>预订人姓名<b>*</b></label><input id="people_id" type="hidden" value="${map['reservePeopleBean'].id }">
						<input id="people_name" type="text" class="dfinput" value="${map['reservePeopleBean'].name }" style="width:518px;" />
						<i style="color: red;" id="people_name_error"></i>
					</li>
					<li><label>联系方式&nbsp;<b>*</b></label>
						<input id="people_tel" type="text" class="dfinput" value="${map['reservePeopleBean'].tel }" style="width:518px;" />
						<i style="color: red;" id="people_tel_error"></i>
					</li>
					<li><label>客户留言&nbsp;<b>*</b></label>
						<input id="people_context" type="text" class="dfinput" value="${map['reservePeopleBean'].message }" style="width:518px;" />
					</li>	
					<li><label>&nbsp;</label>
						<input type="button" class="btn" value="修改预定" onclick="updatePeople()"/>
					</li>				
				</ul>
			</div>


			<div id="tab2" class="tabson">

				<ul class="forminfo" id="room_info">
					
					<li><label>入住时间&nbsp;<b>*</b></label>
					<input type="hidden" value="${map['reserveRoomBean'].id }" id="room_id">
					<input id="checkIn" class="flatpickr dfinput"
						data-date-format="Y-m-d" placeholder="入住时间"
						style="width:518px;">
						<strong><i style="color: blue;">当前入住时间：</i><fmt:formatDate value="${map['reserveRoomBean'].checkIn }" pattern="yyyy-MM-dd"/></strong>
					<i style="color: red;" id="checkIn_error"></i>
					</li>
					
					<li><label>退房时间&nbsp;<b>*</b></label>
					<input id="checkOut" class="flatpickr dfinput"
						data-date-format="Y-m-d" placeholder="退房时间"
						style="width:518px;">
						<strong><i style="color: blue;">当前退房时间：</i><fmt:formatDate value="${map['reserveRoomBean'].checkOut }" pattern="yyyy-MM-dd"/></strong>
					<i style="color: red;" id="checkOut_error"></i>
					</li>
					
					<li><label>预抵时间&nbsp;<b>*</b></label>
					<input id="arrive" class="flatpickr dfinput" data-enable-time=true
						data-time_24hr=true data-enable-seconds=true placeholder="预抵时间"
						style="width:518px;">
						<strong><i style="color: blue;">当前预抵时间：</i><fmt:formatDate value="${map['reserveRoomBean'].arrive }" pattern="yyyy-MM-dd HH:mm:ss"/></strong>
					<i style="color: red;" id="arrive_error"></i>	
					</li>
					
					<li><label>取消时间&nbsp;<b>*</b></label>
					<input id="cancel" class="flatpickr dfinput" data-enable-time=true
							data-time_24hr=true  data-enable-seconds=true placeholder="取消时间"
							style="width:518px;">
					<strong><i style="color: blue;">当前取消时间：</i><fmt:formatDate value="${map['reserveRoomBean'].cancel }" pattern="yyyy-MM-dd HH:mm:ss"/></strong>
					<i style="color: red;" id="cancel_error"></i>	
					</li>
					<li><label>&nbsp;</label>
						<input type="button" class="btn" value="修改预定" onclick="updateRoom()"/>
					</li>
				</ul>	
			</div>
			
			<div id="tab3" class="tabson">
			
				<ul class="forminfo" id="checkIn_info">
				<c:forEach items="${map['reserveNumberList'] }" var="ReserveNumberBean">
					<li><label>房间类型<b>*</b></label>
						<input type="hidden" value="${ReserveNumberBean.id }" id="number_id">
						<input type="text" readonly="readonly" value="${ReserveNumberBean.roomType.name }" class="dfinput"/>
					</li>
					<li><label>预定数量&nbsp;<b>*</b></label>
						<input type="text" readonly="readonly" class="dfinput roomCount" value="${ReserveNumberBean.count }" style="width:518px;" />
						<i style="color: red;" id="count_error"></i>
					</li>
					<li><label>&nbsp;</label>
						<a href="showReserveNumberDetailByManager.action?id=${ReserveNumberBean.id }"><input type="button" class="btn" value="修改预定"/></a>
						<a href="deleteNumberByManager.action?id=${ReserveNumberBean.id }"><input type="button" class="btn" value="删除预定"/></a>
					</li>
				</c:forEach>
					
				</ul>
	
			</div>
			
			<div id="tab4" class="tabson">


				<ul class="forminfo" id="checkIn_info">
					<c:forEach items="${map['checkInPersonList'] }" var="CheckInPersonBean">
						<li><label>入住人姓名<b>*</b></label>
							<input type="hidden" class="person_id" value="${CheckInPersonBean.id }">
							<input type="text" class="dfinput checkInPerson" readonly="readonly" value="${CheckInPersonBean.name }" style="width:518px;" />
							<i style="color: red;" id="name_error"></i>
						</li>
						<li><label>&nbsp;</label>
							<a href="showReservePeopleDetailByManager.action?id=${CheckInPersonBean.id }"><input type="button" class="btn" value="修改预定"/></a>
							<a href="deletePersonByManager.action?id=${CheckInPersonBean.id }"><input type="button" class="btn" value="删除预定"/></a>
						</li>
					</c:forEach>
				</ul>
			</div>
			
		</div>

		<script type="text/javascript">
			$("#usual1 ul").idTabs();
		</script>

		<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
		</script>

	</div>
</body>
<!-- 时间插件begin -->
<script async>
	function fp_ready() {
		// setting custom defaults
		Flatpickr.l10n.firstDayOfWeek = 1;

		//Regular flatpickr
		document.getElementById("checkIn").flatpickr();
		document.getElementById("checkOut").flatpickr();

		var calendars = document.getElementsByClassName("flatpickr").flatpickr();
	}
</script>
<script async src="admin/js/public/flatpickr.js" onload="fp_ready()"></script>
<!-- 时间插件end -->

</html>
