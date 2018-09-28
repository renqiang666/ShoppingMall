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
<script src="js/public/jquery-3.3.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/public/jquery.js"></script>
<script async src="time/dist/flatpickr.js" onload="fp_ready()"></script>
<script type="text/javascript">
function changeDiscount(){
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
</script>
<script async>
	function fp_ready() {
		// setting custom defaults
		Flatpickr.l10n.firstDayOfWeek = 1;

		//Regular flatpickr
		document.getElementById("stime").flatpickr();
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
			<li>查看管理员工作日志</li>
			
		</ul>
	</div>

	<div class="rightinfo">



		<ul class="prosearch">
			<li><label>查询：</label> <i>日期</i><input id="stime"
				class="dfinput" class="flatpickr" data-date-format="Y-m-d"
				placeholder="请输入日期" style="width:200px;">
			</li>
			<li><input onclick="findtime(1)" name="" type="button" class="sure" value="提交" /></li>
		</ul>
		<div class="formtitle1">
			<span id="managerid">管理员</span>
		</div>

		<table class="tablelist">
			<thead>
				<tr>
					<th>编号<i class="sort"><img src="img/px.gif" /></i></th>
					<th>姓名</th>
					<th>上班时间</th>
					<th>下班时间</th>
					<th>状态</th>
				</tr>
			</thead>
			<tbody id="manager">

			</tbody>
		</table>


		<div id="pagin" class="pagin">
			<!-- <div id="message" class="message"></div>
			<ul class="paginList">
				<li onclick="prePage()" class="paginItem"><span class="pagepre"></span></a></li>
				<li id="test" class="paginItem"></li>
				<li onclick="nextPage()" class="paginItem"><span
					class="pagenxt"></span></a></li>
			</ul> -->
		</div>


		<div class="tip">
			<div class="tiptop">
				<span>提示信息</span><a></a>
			</div>

			<div class="tipinfo">
				<span><img src="img/ticon.png" /></span>
				<div class="tipright">
					<p>是否确认对信息的修改 ？</p>
					<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
				</div>
			</div>

			<div class="tipbtn">
				<input name="" type="button" class="sure" value="确定" />&nbsp; <input
					name="" type="button" class="cancel" value="取消" />
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
	<script type="text/javascript" src="js/private/managertime.js"></script>
</body>
</html>
