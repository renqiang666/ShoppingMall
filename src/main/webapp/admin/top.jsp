<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>无标题文档</title> 
<link href="admin/css/style.css" rel="stylesheet"type="text/css" />
<script language="JavaScript" src="admin/js/public/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body style="background:url(admin/img/topbg.gif) repeat-x;">

	<div class="topleft">
		<a href="admin/main.jsp" target="_parent"><img src="admin/img/logo.png"
			title="系统首页" /></a>
	</div>

	<ul class="nav">
	
	</ul>

	<div class="topright">
		<ul>
			<li><span><img src="admin/img/help.png" title="帮助"
					class="helpimg" /></span><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
			<li><a onclick="outlogin()" href="admin/login.jsp" target="_parent">退出</a></li>
		</ul>

		<div class="user">
			<span><%=session.getAttribute("uname")%></span>
		</div>
	</div>
	<script>
	function outlogin(){
	$.ajax({
		url:"outLoginAction.action",
		method:"post",
		success:function(message){
			alert(message);
			
		}
	});
	}
	</script>
</body>
</html>
