<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="admin/css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	.lived{
		width:120px;
		height:120px;
		line-height: 120px;
		background-color: #ff0000a8;
		text-align: center;
		font-size: 20px;
		border: 2px solid black;
	}
	.cleaning{
		width:120px;
		height:120px;
		line-height: 120px;
		background-color: #2020e29e;
		text-align: center;
		font-size: 20px;
		border: 2px solid black;
	}
	.empty{
		width:120px;
		height:120px;
		background-color: #2be4118f;
		text-align: center;
		line-height:120px;
		font-size: 20px;
		border: 2px solid black;
	}
	
</style>
<script type="text/javascript" src="admin/js/public/jquery-3.3.1.js"></script>
<script language="javascript">
	function searchRoom(pageNum,type){
		$.ajax({
			url:"/HotelManagement/RoomDisplayAction_findRoomInfoByType.action",
			method:"post",
			async:true,
			data:"pageNum="+pageNum+"&type="+type,
			success:function(data){
				var rooms=data.list;
				var str="";
				for(var i=0;i<rooms.length;i++){
					if(i%6==0){
						str+="<tr style='height:150px;'>";
					}
					if(rooms[i].roomState.id==3){
						str+="<td style='width:150px;'><div class='lived'>"+rooms[i].id+"</div></td>";
					}else if(rooms[i].roomState.id==2){
						str+="<td style='width:150px;'><div class='cleaning'>"+rooms[i].id+"</div></td>";
					}else{
						str+="<td style='width:150px;'><div class='empty'>"+rooms[i].id+"</div></td>";
					}
					if((i+1)%6==0||(i+1)==rooms.length){
						str+="</tr>";
					}
						
					}
				str+="<tr><td colspan='6'>";
				if(!data.isFirstPage){
					str+="<button type='button' onclick='searchRoom(1,"+type+")'>首页</button>&nbsp;";
				}if(data.hasPreviousPage){
					str+="<button type='button' onclick='searchRoom("+data.prePage+","+type+")'>上一页</button>&nbsp;";
				}
				str+="共："+data.pages+"&nbsp;页&nbsp;";
				if(data.hasNextPage){
					str+="<button type='button' onclick='searchRoom("+data.nextPage+","+type+")'>下一页</button>&nbsp;"
				}
				if(!data.isLastPage){
					str+="<button type='button' onclick='searchRoom("+data.pages+","+type+")'>末页</button>"
				}
				$("#roomdisplay").html(str);
			}
		});
	}

</script>
</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="admin/index.jsp">首页</a></li>
    <li>营业查询</li>
    <li><a href="/HotelManagement/RoomDisplayAction_index.action">房间查询</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="roomType">
    	<button type="button" class="scbtn" onclick="searchRoom(1,5)">所有房间</button>
    	<button type="button" class="scbtn" onclick="searchRoom(1,1)">单人房</button>
        <button type="button" class="scbtn" onclick="searchRoom(1,2)">双人房</button>
        <button type="button" class="scbtn" onclick="searchRoom(1,3)">大床房</button>
        <button type="button" class="scbtn" onclick="searchRoom(1,4)">总统套房</button>
        
        
    </div>
    
    	<div class="formtitle"><span>房间列表</span></div>
    	<table id="roomdisplay"  style="margin-left:100px;">
    	</table>
    
    
    
    </div>
    

</body>

</html>
