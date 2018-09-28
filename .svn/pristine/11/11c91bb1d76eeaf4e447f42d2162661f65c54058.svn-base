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
function changeDiscount(){
	var result=timeIdentity();
	//时间验证无问题再提交Action
    if(result==1){
    	$.ajax({
			url:"/HotelManagement/updateDiscountById.action",
			method:"post",
			async:true,
			data: "startTime="+$('#stime').val()+"&endTime="+$('#etime').val()+"&value="+$('#value').val()+"&id="+'${param.id}',
			success:function(data){
				alert(data);
				window.location.href="/HotelManagement/admin/feecountright.jsp";
			}
		});
    }		
}
function timeIdentity(){
	var stime=$('#stime').val();
	var etime=$('#etime').val();
	var value=$('#value').val();
	var oldStime="${param.stime}";
	var oldEtime="${param.etime}";
	if(stime==""&&etime==""&&value==""){
		$("#mes1").html("不能全为空值！");
	}
	else if(stime==""&&etime==""){
		return 1;
	}
	//只跟新开始时间
	else if(stime!=""&&etime==""){
		if(stime<getNowFormatDate()){
			$("#mes1").html("开始时间不能小于当前日期！");
		}else if(stime>oldEtime){
			$("#mes1").html("开始时间不能大于结束时间");
		}else{
			var result=1;
			$.ajax({
				url:"/HotelManagement/findDiscountByGivenDateAndId.action",
				method:"post",
				async:false,
				data: "stime="+stime+"&etime="+oldEtime+"&id="+"${param.id}",
				success:function(data){
					if(data=="该段时间内已有折扣活动！"){
						$("#mes2").html("该段时间内已有折扣活动，不能添加！");
						result=0;
					}else{
						$("#mes2").html("");
						result=1;
					}
				}
			});
			return result;
		}
	}
	//只更新结束时间
	else if(stime==""&&etime!=""){
	if(etime<getNowFormatDate()){
			$("#mes1").html("结束时间不能小于当前日期！");
		}else if(etime<oldStime){
			$("#mes1").html("结束时间不能小于开始时间");
		}else{
			var result=1;
			$.ajax({
				url:"/HotelManagement/findDiscountByGivenDateAndId.action",
				method:"post",
				async:false,
				data: "stime="+oldStime+"&etime="+etime+"&id="+"${param.id}",
				success:function(data){
					if(data=="该段时间内已有折扣活动！"){
						$("#mes3").html("该段时间内已有折扣活动，不能添加！");
						result=0;
					}else{
						$("#mes2").html("");
						result=1;
					}
				}
			});
			return result;
		}
	}
	else if(stime!=""&&etime!=""){
		if(stime<getNowFormatDate()){
			$("#mes1").html("开始时间不能小于当前日期！");
		}else if(etime<stime){
			$("#mes1").html("结束时间不能小于开始时间");
		}else{
			var result=1;
			$.ajax({
				url:"/HotelManagement/findDiscountByGivenDateAndId.action",
				method:"post",
				async:false,
				data:"stime="+stime+"&etime="+etime+"&id="+"${param.id}",
				success:function(data){
					if(data=="该段时间内已有折扣活动！"){
						$("#mes1").html("该段时间内已有折扣活动，不能添加！");
						result=0;
					}else{
						$("#mes1").html("");
					}
				}
			});
			return result;
		}
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
//验证折扣值是否合法
function valueIdentity(){
	var value=$("#value").val();
	//如果value在0到1以外，数据非法
	if(!(value>0&&value<1)&&value!=""){
		$("#mes").html("数据值非法！");
		$('#commit').attr("disabled",true);
		$('#commit').css("background-color","#7f7f7f");
	}else{
		var otherValue=value*100-parseInt(value*100);
		if(otherValue){
			$("#mes").html("小数位数非法！");
			$('#commit').attr("disabled",true);
			$('#commit').css("background-color","#7f7f7f");
		}
		else{
			$("#mes").html("");
			$('#commit').attr("disabled",false);
			$('#commit').css("background-color","orange");
		}
	}
}
</script>
<script async>
	function fp_ready() {
		// setting custom defaults
		Flatpickr.l10n.firstDayOfWeek = 1;

		//Regular flatpickr
		document.getElementById("stime").flatpickr();
		document.getElementById("etime").flatpickr();
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
    <li>修改折扣</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    <li style="float:left;"><label>开始时间</label><input id="stime" class="dfinput" class="flatpickr" data-date-format="Y-m-d"
		placeholder="开始日期" style="width:200px;" >
	<br /></li><div id="mes2" style="width:250px;height:32px;line-height:32px;color:red;float:left;margin-left:50px;"></div>
    <li style="float:left;"><label>结束时间</label><input id="etime" class="dfinput" class="flatpickr" data-date-format="Y-m-d"
		placeholder="结束日期" style="width:200px;">
	<br /></li><div id="mes3" style="width:250px;height:32px;line-height:32px;color:red;float:left;margin-left:50px;"></div>
    <li style="float:left;"><label>折扣值</label><input name="" type="text" class="dfinput" id="value" onblur="valueIdentity()" style="width:200px;"/><i>请输入0到1之间的两位小数</i></li><div id="mes" style="width:100px;height:32px;line-height:32px;color:red;float:left;margin-left:50px;"></div>
    <li style="float:left;"><label>&nbsp;</label><input id="commit" type="button" class="rqbtn" value="确认修改" onclick="changeDiscount()"/></li><div id="mes1" style="width:250px;height:32px;line-height:32px;color:red;float:left;margin-left:50px;"></div>
    </ul>  
    </div>

</body>
</html>
