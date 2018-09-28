<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit_reserve_number.jsp' starting page</title>
    <script type="text/javascript" src="admin/js/public/jquery-3.3.1.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="admin/css/style.css" rel="stylesheet" type="text/css" />
	<link href="admin/css/select.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="admin/js/public/jquery.idTabs.min.js"></script>
	<script type="text/javascript" src="admin/js/public/select-ui.min.js"></script>
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
    <li><a href="showReserveMessageDetail.action?id=${sessionScope.reserveRoomId}&reservePeopleId=${sessionScope.reservePeopleId}">预订详情</a></li>
    <li><a href="javascript:;" onclick="fresh()">修改预订房间</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>房间类型数量修改</span></div>
    
    <ul class="forminfo">
    
    <li><label>已选类型</label>
    	<input type="hidden" id="number_id" value="${map['bean'].id }"/>
    	<input id="person_name" readonly="readonly" value="${map['bean'].roomType.name }" type="text" class="dfinput"/><i></i>
    </li>
    <li><label>修改类型<b>*</b></label>
		<div class="vocation">
			<select class="select1" id="number_type">
			<c:forEach items="${map['list'] }" var="RoomTypeBean">
				<option value="${RoomTypeBean.id }">${RoomTypeBean.name }</option>
			</c:forEach>	
			</select>
		</div>
	</li>
	<li><label>预定数量&nbsp;<b>*</b></label>
		<input id="number_count" type="text" class="dfinput" value="${map['bean'].count }" style="width:518px;" />
		<i style="color: red;" id="count_error"></i>
	</li>
    <li><label>&nbsp;</label>
    	<input type="button"  class="btn" value="确认修改" onclick="updateNumber()"/>
    </li>
    </ul>
    
    </div>
<script type="text/javascript">
var num =$("#number_count").val();
if(num==""){
	$("#count_error").html("房间数不能为空");
}else if(num<=0){
	$("#count_error").html("请输入正确的房间数");
}else{
	function updateNumber(){
	var list=new Array();
	
	var number={};
	number.id=$("#number_id").val();
	number.count=$("#number_count").val();
	list.push({reserveNumberBean:number})
	
	var type={}
	type.id=$("#number_type").find("option:selected").val();
	list.push({roomTypeBean:type})
	
	var room={}
	room.id=${sessionScope.roomId}
	list.push({reserveRoomBean:room})
	
		$.ajax({
			url:"updateNumberByManager.action",
			type: "post",
			async: true,
			dataType:"json",
			contentType : "application/json;charset=utf-8",
			data:JSON.stringify(list),
			success:function(data){
			if(data=="更新成功"){
				window.location.href="showReserveMessageDetail.action?id=${sessionScope.reserveRoomId}&reservePeopleId=${sessionScope.reservePeopleId}";
				$("#tab1").attr({"class":""});
				$("#tab3").attr({"class":"selected"});
			}else{
				alert(data);
			}
		}
	});
	}
}
	function fresh(){
		window.location.reload();
	}
</script>
</body>

</html>
