<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addmanager.jsp' starting page</title>
    
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
    <li>添加管理员</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>管理员基本信息</span></div>
    
    <ul class="forminfo">
    <li><label>管理员账号：</label><input id="uname" type="text" class="dfinput" /><i id="unamehint" style="color: red"></i></li>
    <li><label>管理员密码：</label><input id="upwd" type="text" class="dfinput" /><i id="upwdhint"></i></li>
    <li><label>&nbsp;</label><input name="" type="button" class="btn" onclick="addmanager()" value="添加"/></li>
    </ul>
    </div>

<script>
	function addmanager(){
	if($("#uname").val()==""){
		$("#unamehint").html("账号为空");
	}
	else if($("#upwd").val()==""){
		$("#upwdhint").html("账号为空");
	}
	else{
	$.ajax({
		url:"addManagerAction.action",
		method:"post",
		dataType:"json",
		data:{
		   uname:$("#uname").val(),
		   upwd:$("#upwd").val()
		},
		success:function(message){
			
			$("#unamehint").html(message);
		}
	});
	}
}
</script>
</body>
</html>
