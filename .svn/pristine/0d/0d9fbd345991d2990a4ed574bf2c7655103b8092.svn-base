<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addmenmbers.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="admin/css/style.css" rel="stylesheet" type="text/css" />
	<script src="admin/js/public/jquery-3.3.1.js" type="text/javascript"></script>
  </head>
  
  <body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>添加会员</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    <li><label>手机号：</label><input id="mid" placeholder="请输入11位手机号" type="text" class="dfinput" /><i id="midhint" style="color: red"></i></li>
    <li><label>姓名：</label><input id="mname" placeholder="请输入中文名或英文名" type="text" class="dfinput" /><i id="mnamehint" style="color: red"></i></li>
    <li><label>&nbsp;</label><input onclick="addmenmbers()" type="button" class="btn" value="确认添加"/></li>
    </ul>
    
    
    </div>
<script>
	function addmenmbers(){
	var phone=$("#mid").val();
	var name=$("#mname").val();
	regphone=/^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$/;
	regname=/^[a-zA-Z\u4e00-\u9fa5]+$/;
	phoneisok=regphone.test(phone);
	nameisok=regname.test(name);
	if($("#mid").val()==""){
		$("#midhint").html("请输入会员id");
	}
	else if($("#mname").val()==""){
			$("#mnamehint").html("请输入会员名字");
	}
	else if(!regphone){
		$("#midhint").html("请输入11位正确手机号格式");
	}
	else if(!nameisok){
		$("#mnamehint").html("会员名字只能由中文或者英文字母组成");
	}
	else{
	$.ajax({
		url:"addMenmbersAction.action",
		method:"post",
		dataType:"json",
		data:{
		   mid:$("#mid").val(),
		   mname:$("#mname").val()
		},
		success:function(message){
			$("#midhint").html(message);
			if(message=="添加会员成功"){
			alert(message);
			window.location.reload();
			}
		}
	});
	}
}
</script>

</body>
</html>
