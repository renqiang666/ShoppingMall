<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=yes">
<head>
<script type="text/javascript" src="/HotelManagement/admin/js/public/jquery-3.3.1.js"></script>
<script async src="time/dist/flatpickr.js" onload="fp_ready()"></script>
<script type="text/javascript">
function changeOverTimeRule(){
	var stime=$('#stime').val();
	var etime=$('#etime').val();
	if(stime==""&&etime==""){
		$("#mes").html("不能全部为空值");
	}
	else if(stime>=etime){
		$("#mes").html("退房时间不能大于或等于超时半天时间！");
	}
	else{
		$("#mes").html("");
		$.ajax({
			url:"/HotelManagement/updateOverTimeRule.action",
			method:"post",
			async:true,
			data: "newOverHalfDayStartTime="+$('#stime').val()+"&newOverAllDayStartTime="+$('#etime').val(),
			success:function(data){
				alert(data);
				window.location.href="/HotelManagement/admin/feecountright.jsp";
			}
		});
	}
}
</script>
<script async>
	function fp_ready() {
		// setting custom defaults
		Flatpickr.l10n.firstDayOfWeek = 1;

		//Regular flatpickr
		//document.getElementById("flatpickr-tryme").flatpickr();
		document.getElementsByClassName("calendar").flatpickr();

		var calendars = document.getElementsByClassName("flatpickr").flatpickr();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" id=cal_style type="text/css"
	href="time/dist/flatpickr.min.css">
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>管理信息</li>
    <li>计费设置</li>
    <li>修改超时计费规则</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    <li><label>退房时间</label><input  class=flatpickr   data-enable-time=true data-no-calendar=true value="09:00" style="width:100px;border-top:solid 1px #c3ab7d; border-left:solid 1px #c3ab7d; border-right:solid 1px #e7d5ba; border-bottom:solid 1px #e7d5ba; background:url(../img/inputbg.gif) repeat-x;width:200px; height:32px; line-height:32px;" id="stime"></li>
    <li><label>超时半天时间</label><input  class=flatpickr   data-enable-time=true data-no-calendar=true value="09:00" style="width:100px;border-top:solid 1px #c3ab7d; border-left:solid 1px #c3ab7d; border-right:solid 1px #e7d5ba; border-bottom:solid 1px #e7d5ba; background:url(../img/inputbg.gif) repeat-x;width:200px; height:32px; line-height:32px;" id="etime"></li>
    <li style="float:left;"><label>&nbsp;</label><input name="" type="button" class="rqbtn" value="确认修改" onclick="changeOverTimeRule()"/></li><div id="mes" style="width:250px;height:32px;line-height:32px;color:red;float:left;margin-left:50px;"></div>
    </ul>
       
    </div>


</body>
</html>
