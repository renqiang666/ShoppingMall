<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'manager_reserve.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="admin/js/public/jquery-3.3.1.js"></script>
<link href="admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="admin/css/select.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>首页</li>
			<li>预订管理</li>
			<li><a href="showRoomTypeByManager.action">添加预定</a></li>
		</ul>
	</div>

	<div class="formbody">


		<div id="usual1" class="usual">

			<div class="itab">
				<ul>
					<li><a href="" class="selected">预订房间</a></li>
				</ul>
			</div>

			<div id="tab1" class="tabson">

				<ul class="forminfo" id="guest_info">
					<li><label>预订人姓名<b>*</b></label>
						<input type="text" class="dfinput" value="" style="width:518px;" id="people_name"/>
						<i id="name-mes" style="color: red;font-weight: bold;"></i>
					</li>
					<li><label>联系方式&nbsp;<b>*</b></label>
						<input type="text" class="dfinput" value="" style="width:518px;" id="people_tel"/>
						<i id="tel-mes" style="color: red;font-weight: bold;"></i>
					</li>
					<li><label>入住时间&nbsp;<b>*</b></label>
						<input id="checkIn" class="flatpickr dfinput" data-date-format="Y-m-d"
							placeholder="入住时间" style="width:518px;">
							<i id="in-mes" style="color: red;font-weight: bold;"></i>
					</li>
					<li><label>退房时间&nbsp;<b>*</b></label>
						<input id="checkOut" class="flatpickr dfinput" data-date-format="Y-m-d"
							placeholder="离开时间" style="width:518px;">
							<i id="out-mes" style="color: red;font-weight: bold;"></i>
					</li>
					<li><label>预抵时间&nbsp;<b>*</b></label>
						<input class="flatpickr dfinput" data-enable-time="true"data-time_24hr="true" 
							data-enable-seconds=true placeholder="预抵时间" style="width: 518px;" id="arrive">
							<i id="ar-mes" style="color: red;font-weight: bold;"></i>
					</li>
					<li><label>取消时间&nbsp;<b>*</b></label>
						<input class="flatpickr dfinput" data-enable-time="true" data-time_24hr="true"
						 	data-enable-seconds="true" placeholder="取消时间" style="width:518px;" id="cancel">
						 	<i id="ca-mes" style="color: red;font-weight: bold;"></i>
					</li>
					<li><label>客户留言&nbsp;<b>*</b></label>
						<input type="text" class="dfinput" value="" style="width:518px;"  id="people_context"/>
					</li>
					<li><label>入住人姓名<b>*</b></label>
						<input type="text" class="dfinput" value="" style="width:518px;" id="checkInPerson"/>
						<i id="cname-mes" style="color: red;font-weight: bold;"></i>
					</li>

					<li><label>房间类型<b>*</b></label>
						<div class="vocation">
							<select class="select1 roomType">
							<c:forEach items="${list }" var="RoomTypeBean">
								<option value="${RoomTypeBean.id }">${RoomTypeBean.name }</option>
							</c:forEach>	
							</select>
						</div>
					</li>

					<li><label>预定数量&nbsp;<b>*</b></label>
						<input type="text" class="dfinput roomCount" value="" style="width:518px;" />
						<i id="count-mes" style="color: red;font-weight: bold;"></i>
					</li>

					
				</ul>
				<ul class="forminfo">
					<li><label>&nbsp;</label>
						<input type="button" class="btn" value="添加类型" id="addInput" /> 
						<label>&nbsp;</label>
						<input type="button" class="btn" value="添加预定" onclick="addReserve()" />
					</li>
				</ul>
			</div>
		</div>


		<script type="text/javascript">
			$('.tablelist tbody tr:odd').addClass('odd');
		</script>

	</div>
</body>
<script type="text/javascript" src="admin/js/public/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="admin/js/public/select-ui.min.js"></script>
<script type="text/javascript">
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
<!-- 时间插件begin -->
<script>
	function fp_ready() {
		// setting custom defaults
		Flatpickr.l10n.firstDayOfWeek = 1;

		//Regular flatpickr
		document.getElementById("checkIn").flatpickr();
		document.getElementById("checkOut").flatpickr();
		var calendars = document.getElementsByClassName("flatpickr").flatpickr();
	}
</script>
<script  src="admin/js/public/flatpickr.js" onload="fp_ready()"></script>
<link rel="stylesheet" id=cal_style type="text/css"	href="admin/css/flatpickr.min.css">
<!-- 时间插件end -->
<script type="text/javascript" src="/HotelManagement/admin/js/private/add_reserve.js"></script>
<script type="text/javascript">
	var index = 2;
	$("#addInput").click(function() {
			if (index <= 3) {
				var str="<li><label>房间类型<b>*</b></label>"+
					"<div class=\"vocation\">"+
						"<select class=\"select1 roomType\">"+
							"<c:forEach items='${list }' var='RoomTypeBean'>"+
								"<option value='${RoomTypeBean.id }'>${RoomTypeBean.name }</option>"+
							"</c:forEach>"+
						"</select>"+
					"</div></li>"+
					"<li><label>预定数量&nbsp;<b>*</b></label>" +
						"<input type=\"text\" class=\"dfinput roomCount\" value=\"\" style=\"width:518px;\" />" +
					"</li>";
						var context = $.parseHTML(str);
						$("#guest_info").append(context);
						$(document).ready(function(e) {
							$(".select1").uedSelect({
								width : 345
							});
						});
							index++;
						} else {
							alert("最多选择三种房间类型");
						}
					});
</script>
</html>
