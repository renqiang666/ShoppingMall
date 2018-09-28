<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'findPass.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="assets/js/jQuery-2.2.2.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	#main{
		position: fixed;
		left:34%;
		top:20%;
		width: 24%;
		height:44%;
		border:1px solid black
	}
	.update{
		float:left;
	}
	.f_para{
		line-height:50px;
		margin-top:30px;
		width:99%;
		height:50px;
	}	
	</style>
  </head>
  <body>
  
    <div id="main">
      <%Object account=session.getAttribute("account");
					if(account==null){%>
    	<div class="f_para">
    		<div style="width: 80px;text-align: center;float: left;">tel:</div>
    		<div ><input id="tel" style="margin-top: 13px"  type="text"></div>
    	</div>
    	 <%}%>
		<div  class="f_para" >
			<div class="update"><button  style="width: 50px;margin-left:20px" onclick="getCode()" >get code</button></div>
			<div class="update"><input  style="margin-left:10px;height:35px;" id="code"></div>
		</div>
		<div  class="f_para" >
    		<div style="width: 80px;text-align: center;float: left">new pass:</div>
    		<div><input style="margin-top: 13px" type="password" id="pass"></div>
    	</div>
    	<div style="width: 100%"><button onclick="updatePass()" style="margin-top:20px;margin-left: 35%;">update pass</button></div>
    	<div id="hint" style="margin-left:100px;"></div>
	</div>
  </body>
<script type="text/javascript" src="admin/js/aes.js"></script>
<script type="text/javascript" src="admin/js/pad-zeropadding.js"></script>
<script type="text/javascript" src="js/private/secret.js"></script>
  <script type="text/javascript">
  	function getCode(){
  		var account=encr($("#tel").val());
		$.ajax({
			url:"/HotelManagement/changePassCode.action",
			type:"post",
			dataType:"json",
			data:{
				tel:account,
			},
			success:function(data){	
				$("#hint").html(data);
			}
		});
	}
	function updatePass(){
	var account=encr($("#tel").val());
	var pass=encr($("#pass").val());
	var code=encr($("#code").val());
		$.ajax({
			url:"/HotelManagement/changePass.action",
			type:"post",
			dataType:"json",
			data:{
				tel:account,
				pass:pass,
				code:code,
			},
			success:function(data){
			$("#hint").html(data);
				if(data=="Password updated successfully"){
					window.location.href="login.jsp";
				}else{
					
				}
			}
		});
	}
  </script>
  
</html>
