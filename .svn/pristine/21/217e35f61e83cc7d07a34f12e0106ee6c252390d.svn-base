<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>欢迎登录后台管理系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="admin/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="admin/js/public/jquery.js"></script>
<script src="admin/js/public/cloud.js" type="text/javascript"></script>
<script src="admin/js/public/jquery-3.3.1.js" type="text/javascript"></script>
<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script>

</head>

<body style="background-color:#df7611; background-image:url(admin/img/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>


	<div class="logintop">
		<span>欢迎登录酒店后台管理界面平台</span>
		<ul>
			<li><a href="#">回首页</a></li>
			<li><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
		</ul>
	</div>

	<div class="loginbody">

		<span class="systemlogo"></span>

		<div class="loginbox loginbox3">
			<ul>
				<li><input id="uname" type="text" class="loginuser"/></li>
				<li><input id="upwd" type="password" class="loginpwd"/></li>
				<li><input  type="button" class="loginbtn" value="登录" onclick="login()"/></li>
				<div id="hint"></div>
			</ul>
		</div>
	</div>

	<script>
	function login(){
	if($('#uname').val()==""){
	$("#hint").html("请输入账号");
	}
	else if($('#upwd').val()==""){
	$("#hint").html("请输入密码");
	}
	else{
	$.ajax({
		url:"ManageLoginAction.action",
		method:"post",
		dataType:"json",
		data:"uname="+$('#uname').val()+"&upwd="+$('#upwd').val(),
		success:function(message){
			$("#hint").html(message);
			if(message=="超管登录"){
			window.location.href="admin/main.jsp";
			}
			if(message=="管理登录"){
			window.location.href="admin/operatormain.jsp";
			}
			
		}
	});
	}
}
</script>
</body>
</html>