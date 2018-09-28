<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'left.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="admin/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="admin/js/public/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson .header").click(function(){
		var $parent = $(this).parent();
		$(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();
		
		$parent.addClass("active");
		if(!!$(this).next('.sub-menus').size()){
			if($parent.hasClass("open")){
				$parent.removeClass("open").find('.sub-menus').hide();
			}else{
				$parent.addClass("open").find('.sub-menus').show();	
			}
			
			
		}
	});
	
	// 三级菜单点击
	$('.sub-menus li').click(function(e) {
        $(".sub-menus li.active").removeClass("active")
		$(this).addClass("active");
    });
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('.menuson').slideUp();
		if($ul.is(':visible')){
			$(this).next('.menuson').slideUp();
		}else{
			$(this).next('.menuson').slideDown();
		}
	});
})	
</script>

</head>

<body style="background:#fff3e1;">
	<div class="lefttop">
		<span></span>操作
	</div>

	<dl class="leftmenu">

		<dd>
			<div class="title">
				<span><img src="admin/img/leftico02.png" /></span>客户开单
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="/HotelManagement/findAllByPage.action" target="rightFrame">开房</a><i></i></li>
				
			</ul>
		</dd>

		<dd>
			<div class="title">
				<span><img src="admin/img/leftico04.png" /></span>预定管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="showRoomTypeByManager.action" target="rightFrame">添加预定</a><i></i></li>
				<li><cite></cite><a href="admin/show_reserve.jsp" target="rightFrame">预订查询</a><i></i></li>
			</ul>

		</dd>

		<dd>
			<div class="title">
				<span><img src="admin/img/leftico04.png" /></span>营业查询
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="/HotelManagement/RoomDisplayAction_index.action" target="rightFrame" target="rightFrame">房间查询</a><i></i></li>
				<li><cite></cite> <a href="/HotelManagement/SerialDisplayAction_display.action" target="rightFrame" target="rightFrame">营业列表</a><i></i></li>
				<li><cite></cite><a href="/HotelManagement/GuestAction_findAll.action" target="rightFrame" target="rightFrame">已入住宾客</a><i></i></li>
				<li><cite></cite><a href="/HotelManagement/MenmbersAction_findAll.action" target="rightFrame">会员查询</a><i></i></li>
			</ul>
			 <dd>
			 </dl>
</body>
</html>
