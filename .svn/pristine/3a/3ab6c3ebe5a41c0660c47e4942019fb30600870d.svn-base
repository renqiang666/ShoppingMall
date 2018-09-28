<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>宾客</title>
<link href="admin/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="admin/js/public/jquery-3.3.1.js"></script>
<script type="text/javascript">
	function guestSearch(){
		
		var select=$('#select1').val();
		var condition=$('#condition').val();
		if(select=='byId'&&condition.length!=0){
			if(checkIden(condition)){
				searchAjax(select,condition);
			}else{
				alert("请输入正确的身份证");
			}				
		}else if(select=='byName'&&condition.length!=0){
			searchAjax(select,condition);
		}else if(select=='byRoomId'&&condition.length!=0){
			if(!isNaN(condition)){
				searchAjax(select,condition);
			}else{
				alert("请正确输入房间号")
			}
		}else{
			searchAjax(select,condition);
		}
		
	}
	function searchAjax(select,condition){
		$.ajax({
			url:"/HotelManagement/searchGuest.action",
			method:"post",
			async:true,
			data:"select1="+select+"&condition="+condition,
			success:function(data){
				var str="";
				for(var i=0;i<data.length;i++){
					var guest=data[i];
				 	str+="<tr><td>"+guest.id+"</td>"+"<td>"
					+guest.name+"</td>"+"<td>"
					+guest.sex+"</td>"+"<td>"
					+guest.tele+"</td>"+"<td>"
					+guest.room.id+"</td>"
					+"</tr>"; 
				}
				$("#gblist").html(str);
				
			}
		});
	}
	function checkIden(condition){
		var cd = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
		if(cd.test(condition)==false){
			return false;
		}else{
			return true;
		}
	}
</script>
</head>
<body>
	
 	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="admin/index.jsp">首页</a></li>
    <li>营业查询</li>
    <li><a href="/HotelManagement/GuestAction_findAll.action">已入住宾客</a></li>
    </ul>
    </div>
    
    <div class="formbody">
	    <div id="usual1" class="usual"> 
		    <ul class="seachform1">
		     <li>
		    	<div class="vocation">
			    <select class="select1" id="select1">
			    <option value="byId">按身份证号</option>
			    <option value="byName">按姓名</option>
			    <option value="byRoomId">房间号</option>
			    </select>
			    </div>
		    </li>
		    <li><input type="text" class="scinput1" id="condition"/></li>
		    </ul>
		    <ul class="seachform1">
		    <li class="sarchbtn"><button type="button" class="scbtn" onclick="guestSearch()">查询</button></li>  
		    </ul>
		    <div class="formtitle"><span>宾客列表</span></div>
		    
		    <table class="tablelist">
		    	<thead>
		    	<tr>
		        <th>身份证号<i class="sort"><img src="admin/img/px.gif" /></i></th>
		        <th>姓名</th>
		        <th>性别</th>
		        <th>手机号</th>
		        <th>房间号</th>
		        </tr>
		        </thead>
		        <tbody id="gblist">
		        <c:forEach  items="${guests}" var="guest" varStatus="st">
					<tr>
					<td>${guest.id}</td>
					<td>${guest.name}</td>  
					<td>${guest.sex}</td>  
					<td>${guest.tele}</td>  
					<td>${guest.room.id}</td>  
				    </tr>
				</c:forEach>
		        </tbody>
		    </table>
		</div> 
    </div>
</body>

</html>