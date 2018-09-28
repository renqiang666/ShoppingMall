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
    
    <div class="formtitle"><span id="classname"></span></div>
    
    <ul class="forminfo">
    <li><label>享受折扣：</label><input id="discount" onblur="valueIdentity()" placeholder="请输入0-1的折扣系数" type="text" class="dfinput" /><i id="dhint" style="color: red"></i></li>
    <li><label>最低消费：</label><input id="consnume" placeholder="请输入最低消费金额" type="text" class="dfinput" /><i id="chint" style="color: red" ></i></li>
    <li><label>&nbsp;</label><input id="commit" onclick="upleveldiscount()" type="button" class="btn" value="提交"/></li>
    </ul>
    </div>
    <script>
	function upleveldiscount(){
	
	var id = ${param.id};
	if($("#discount").val()==""){
		$("#dhint").html("请输入修改信息");
	}
	else if($("#consnume").val()==""){
		$("#chint").html("请输入修改信息");
	}
	else{
	$.ajax({
		url:"upLevelDiscountAction.action",
		method:"post",
		dataType:"json",
		data:
		   "cid="+id+"&cdiscount="+$('#discount').val()+"&cconsnume="+$('#consnume').val(),
		success:function(message){
			
			if(message=="更新成功"){
			window.location.href="admin/leveldiscount.jsp";
			}
			if(message=="修改信息错误！折扣不能高于下一等级"){
			$("#dhint").html("修改信息错误！折扣不能高于下一等级");
			}
			if(message=="修改信息错误！折扣不能低于上一等级"){
			$("#dhint").html("修改信息错误！折扣不能低于上一等级");
			}
			if(message=="修改信息错误！最低消费金额不能高于下一等级"){
			$("#chint").html("修改信息错误！最低消费金额不能高于下一等级");
			}
			if(message=="修改信息错误！最低消费金额不能低于于上一等级"){
				$("#chint").html("修改信息错误！最低消费金额不能低于于上一等级");
			}
			if(message=="请输入正确数字"){
			$("#dhint").html("请输入正确数字");
			}
		}
	});
	}
}
function valueIdentity(){

	var value=$("#discount").val();
	if(!(value>0&&value<1)){
		$("#dhint").html("数据值非法！");
		$('#commit').attr("disabled",true);
		$('#commit').css("background-color","#7f7f7f");
	}else{
		var otherValue=value*100-parseInt(value*100);
		if(otherValue){
			$("#dhint").html("小数位数非法！");
			$('#commit').attr("disabled",true);
			$('#commit').css("background-color","#7f7f7f");
		}
		else{
			$("#dint").html("");
			$('#commit').attr("disabled",false);
			$('#commit').css("background-color","orange");
		}
	}
	
	
}
function findLevelId(){
	var id = ${param.id};
	$.ajax({
		url:"findLevelByIdAction.action",
		method:"post",
		dataType:"json",
		data:
		   "cid="+id,
		success:function(message){
			$("#classname").html(message.className);
		}
	});
}
findLevelId();
</script>
</body>
</html>
