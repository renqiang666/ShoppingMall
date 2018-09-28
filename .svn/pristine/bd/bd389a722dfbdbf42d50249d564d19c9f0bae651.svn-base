<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'manager.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="admin/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="admin/js/public/jquery.js"></script>
<script src="admin/js/public/jquery-3.3.1.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".click").click(function() {
			$(".tip").fadeIn(200);
		});

		$(".tiptop a").click(function() {
			$(".tip").fadeOut(200);
		});

		$(".sure").click(function() {
			$(".tip").fadeOut(100);
		});

		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});

	});
</script>
</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">

	
			<li>首页</li>
			<li>会员查询</li>

		</ul>
	</div>

	<div class="rightinfo">



		

		<div class="formtitle1">
			<span>会员</span>
		</div>

		<table class="tablelist">
			<thead>
				<tr>
					<th>会员id<i class="sort"><img src="admin/img/px.gif" /></i></th>
					<th>姓名</th>
					<th>消费金额</th>
					<th>会员等级</th>
					<th>享受折扣</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="menmbers">

			</tbody>
		</table>


		<div class="pagin">
			<div id="message" class="message"></div>
			<ul class="paginList">
				<li onclick="prePage()" class="paginItem"><span class="pagepre"></span></a></li>
				<li id="test" class="paginItem"></li>
				<li onclick="nextPage()" class="paginItem"><span
					class="pagenxt"></span></a></li>
			</ul>
		</div>


		<div class="tip">
			<div class="tiptop">
				<span>提示信息</span><a></a>
			</div>

			<div class="tipinfo">
				<span><img src="admin/img/ticon.png" /></span>
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

<script type="text/javascript" src="admin/js/private/menmbers.js"></script>
</body>
</html>
