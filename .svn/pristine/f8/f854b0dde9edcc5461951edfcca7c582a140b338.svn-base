<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit_reserve.jsp' starting page</title>
    <script type="text/javascript" src="admin/js/public/jquery-3.3.1.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="admin/css/style.css" rel="stylesheet" type="text/css" />
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
    
    <div class="formtitle"><span>入住人修改</span></div>
    
    <ul class="forminfo">
    
    <li><label>姓名</label>
    	<input type="hidden" id="person_id" value="${bean.id }"/>
    	<input id="person_name" value="${bean.name }" type="text" class="dfinput"/>
		<i style="color: red;" id="name_error"></i>
    </li>
    <li><label>&nbsp;</label>
    	<input type="button"  class="btn" value="确认修改" onclick="updatePerson()"/>
    </li>
    </ul>
    
    
    </div>


</body>
<script type="text/javascript">
var name = $("#person_name").val();
if(name==""){
	$("#name_error").html("入住人姓名不能为空");
}else{
	function updatePerson(){
	var person = {"id":$("#person_id").val(),
	"name":$("#person_name").val()};
		$.ajax({
			url:"updatePersonByManager.action",
			type: "post",
			async: true,
			dataType:"json",
			contentType: "application/json;charset=utf-8",
			data:JSON.stringify(person),
			success:function(data){
			if(data=="更新成功"){
				window.location.href="showReserveMessageDetail.action?id=${sessionScope.reserveRoomId}&reservePeopleId=${sessionScope.reservePeopleId}";
				$("#tab1").attr({"class":""});
				$("#tab4").attr({"class":"selected"});
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
</html>
