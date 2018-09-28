<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript" src="/HotelManagement/admin/js/public/jquery-3.3.1.js"></script>
<script type="text/javascript">
function addRoom(){
	var room=$('#roomid').val();
	var floor=$('#floor').val();
	var type=$('#type').val();
	var state=$('#state').val();
	if(type=="单人间"){
		type=1;
	}else if(type=="双人间"){
		type=2;
	}else if(type=="大床房"){
		type=3;
	}else if(type=="总统套房"){
		type=4;
	}else if(type=="海景房"){
		type=5;
	}else if(type=="桑拿房"){
		type=6;
	}
	if(state=="可入住"){
		state=1;
	}else if(state=="待打扫"){
		state=2;
	}else if(state=="已入住"){
		state=3;
	}
	if(room==""||floor==""||type==""||state==""){
		$("#mes3").html("不能有空值！");
	}else{
		$("#mes3").html("");
		$.ajax({
			url:"/HotelManagement/insertRoom.action",
			method:"post",
			async:true,
			data:"id="+$('#roomid').val()+'&floor='+$('#floor').val()+'&typeId='+type+'&stateId='+state,
			success:function(data){
				alert(data);
				window.location.href="/HotelManagement/admin/roominforight.jsp";
			}
		});
	}

}
//验证房间号是否合法
function roomIdentity(){
	var value=$("#roomid").val();
	//如果房间号是字符串，非法
	if(value.length!=4){
		$("#mes1").html("数据位数非法！");
		$('#commit').attr("disabled",true);
		$('#commit').css("background-color","#7f7f7f");
		return 0;
	}
	else if(valueIdentity(value,value.length)==0){
		$("#mes1").html("数据非法！");
		$('#commit').attr("disabled",true);
		$('#commit').css("background-color","#7f7f7f");
		return 0;
	}else{
		$.ajax({
			url:"/HotelManagement/findRoomByRoomId.action",
			method:"post",
			async:true,
			data:"roomId="+$('#roomid').val(),
			success:function(data){
				if(data=="已有该房间"){
					$("#mes1").html("已有该房间，不能添加！");
					$('#commit').attr("disabled",true);
					$('#commit').css("background-color","#7f7f7f");
				}else{
					$("#mes1").html("");
					$('#commit').attr("disabled",false);
					$('#commit').css("background-color","orange");
				}
			}
		});
	}	
}
//验证楼层是否合法
function floorIdentity(){
 	if($("#roomid").val()!=""){
		var value=$("#floor").val();
		var room=$("#roomid").val();
		if(value.length!=1&&value.length!=2){
			$("#mes2").html("数据位数非法！");
			$('#commit').attr("disabled",true);
			$('#commit').css("background-color","#7f7f7f");
		}
		else if(valueIdentity(value,value.length)==0){
			$("#mes2").html("数据非法！");
			$('#commit').attr("disabled",true);
			$('#commit').css("background-color","#7f7f7f");
		}
		else{
			//定义楼层的位数
			var floorLength=value.toString().length;
			//截取与楼层位数一样的房间号前floorLength位
			var roomFloor=room.substr(0, floorLength);
			if(roomFloor!=value){
				$("#mes2").html("房间号与楼层不符！");
				$('#commit').attr("disabled",true);
				$('#commit').css("background-color","#7f7f7f");
			}
			else{
				$("#mes2").html("");
				$('#commit').attr("disabled",false);
				$('#commit').css("background-color","orange");
			}
		}
		
 	}else{
 		$("#mes1").html("数据位数非法！");
		$('#commit').attr("disabled",true);
		$('#commit').css("background-color","#7f7f7f");
 	}
}
//验证是否为数字
function valueIdentity(value,length){
	for(var i=0;i<length;i++){
		var tempValue=value.substr(i,1);
		if(!(tempValue>=0&&tempValue<=9)){
		    return 0;
		}
	}
	return 1;
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>管理信息</li>
    <li>房间设置</li>
    <li>添加房间</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    <li style="float:left;"><label>房间号</label><input  type="text" class="dfinput" id="roomid" onblur="roomIdentity()"/><i>请输入4位数字房间号</i></li><div id="mes1" style="width:200px;height:32px;line-height:32px;color:red;float:left;margin-left:50px;"></div>
    <li style="float:left;"><label>楼层</label><input  type="text" class="dfinput" id="floor" onblur="floorIdentity()"/></li><div id="mes2" style="width:200px;height:32px;line-height:32px;color:red;float:left;margin-left:50px;"></div>
    <li style="float:left;"><label>房间类型</label><select style="border:1px black solid;width:100px;" id="type">
      <option>单人间</option>
      <option>双人间</option>
      <option>大床房</option>
      <option>总统套房</option>
      <option>海景房</option>
      <option>桑拿房</option>
    </select></li>
    <li style="float:left;"><label>房间状态</label><select style="border:1px black solid;width:100px;" id="state">
      <option>可入住</option>
      <option>待打扫</option>
      <option>已入住</option>
    </select></li>
    <li style="float:left;"><label>&nbsp;</label><input id="commit" type="button" class="rqbtn" value="确认添加" onclick="addRoom()"/></li><div id="mes3" style="width:200px;height:32px;line-height:32px;color:red;float:left;margin-left:50px;"></div>
    </ul>
    
    
    </div>


</body>
</html>
