<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>流水表</title>
<link href="admin/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="admin/js/public/jquery-3.3.1.js"></script>
<script type="text/javascript" src="admin/js/public/aes.js"></script>
<script type="text/javascript" src="admin/js/public/pad-zeropadding.js"></script>
<script type="text/javascript">
	function serialSearch(pageNum){
		$.ajax({
				url:"/HotelManagement/findSerial.action",
				method:"post",
				async:true,
				data:"startDate="+$('#startDate').val()+"&endDate="+$('#endDate').val()+"&pageNum="+pageNum,
				success:function(data){
					var str="";
					for(var i=0;i<data.list.length;i++){
						var serial=data.list[i];
					 	str+="<tr><td>"+serial.seId+"</td><td>"
						+decr(serial.sePaidMoney)+"</td><td>"
						+serial.seArrDay+"</td><td>"
						+serial.sePhone+"</td><td>"
						+serial.seTimeNow+"</td><td>"
						+serial.seDayNow+"</td><td>"
						+serial.seConId+"</td><td>"
						+serial.seCRoom+"</td>"
						+"</tr>"; 
					}
					str+="<tr><td colspan='8'>";
					if(!data.isFirstPage){
						str+="<button type='button' onclick='serialSearch(1)'>首页</button>&nbsp;";
					}if(data.hasPreviousPage){
						str+="<button type='button' onclick='serialSearch("+data.prePage+")'>上一页</button>&nbsp;";
					}
					str+="共："+data.pages+"&nbsp;页&nbsp;";
					if(data.hasNextPage){
						str+="<button type='button' onclick='serialSearch("+data.nextPage+")'>下一页</button>&nbsp;"
					}
					if(!data.isLastPage){
						str+="<button type='button' onclick='serialSearch("+data.pages+")'>末页</button>"
					}
					$("#gblist").html(str);
				}
			});
	}
	function serialAll(pageNum){
		$.ajax({
				url:"/HotelManagement/displayAllSerial.action",
				method:"post",
				async:true,
				data:"&pageNum="+pageNum,
				success:function(data){
					var str="";
					for(var i=0;i<data.list.length;i++){
						var serial=data.list[i];
					 	str+="<tr><td>"+serial.seId+"</td><td>"
						+decr(serial.sePaidMoney)+"</td><td>"
						+serial.seArrDay+"</td><td>"
						+serial.sePhone+"</td><td>"
						+serial.seTimeNow+"</td><td>"
						+serial.seDayNow+"</td><td>"
						+serial.seConId+"</td><td>"
						+serial.seCRoom+"</td>"
						+"</tr>"; 
					}
					str+="<tr><td colspan='8'>";
					if(!data.isFirstPage){
						str+="<button type='button' onclick='serialAll(1)'>首页</button>&nbsp;";
					}if(data.hasPreviousPage){
						str+="<button type='button' onclick='serialAll("+data.prePage+")'>上一页</button>&nbsp;";
					}
					str+="共："+data.pages+"&nbsp;页&nbsp;";
					if(data.hasNextPage){
						str+="<button type='button' onclick='serialAll("+data.nextPage+")'>下一页</button>&nbsp;"
					}
					if(!data.isLastPage){
						str+="<button type='button' onclick='serialAll("+data.pages+")'>末页</button>"
					}
					$("#gblist").html(str);
				}
			});
	}
	function decr(data) {
	    var key = CryptoJS.enc.Latin1.parse('class33iamironma');
	    var iv = CryptoJS.enc.Latin1.parse('iamironmaclass33');
	    var decrypted = CryptoJS.AES.decrypt(data, key, {iv: iv, padding: CryptoJS.pad.ZeroPadding});
	    return decrypted.toString(CryptoJS.enc.Utf8);
	}
	function fp_ready() {
		Flatpickr.l10n.firstDayOfWeek = 1;
		var calendars = document.getElementsByClassName("flatpickr").flatpickr();
	}
</script>

<style type="text/css">

	.flatpickr{
		border:1px solid black; 
	}
</style>
<script async src="admin/js/public/flatpickr.js" onload="fp_ready()"></script>
<link rel="stylesheet" id=cal_style type="text/css" href="admin/css/flatpickr.min.css">
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
		    	   查询：从&nbsp;&nbsp;<input class="flatpickr" id="startDate" data-enable-time=true data-time_24hr=true placeholder="开始时间">&nbsp;&nbsp;至:&nbsp;&nbsp;<input id="endDate" class="flatpickr" data-enable-time=true data-time_24hr=true placeholder="结束时间">&nbsp;&nbsp;营业情况&nbsp;&nbsp;
		    	 <button type="button" class="scbtn"  onclick="serialSearch(1)">查询</button> 
		    </li>
		    <li><button type="button" class="scbtn" onclick="serialAll(1)">查询所有</button></li>
		    </ul>
		    
		    <div class="formtitle"><span>流水列表</span></div>
		    <table class="tablelist">
		    	<thead>
		    	<tr>
		        <th>流水号<i class="sort"><img src="admin/img/px.gif" /></i></th>
		        <th>金额</th>
		        <th>到店时间</th>
		        <th>手机号</th>
		        <th>结账时间</th>
		        <th>入住天数</th>
		        <th>消费单号</th>
		        <th>房间号</th>
		        </tr>
		        </thead>
		        <tbody id="gblist">
		        <c:forEach  items="${serials}" var="serial">
					<tr>
					<td>${serial.seId}</td>
					<td>${serial.sePaidMoney}</td>  
					<td>${serial.seArrDay}</td>  
					<td>${serial.sePhone}</td>  
					<td>${serial.seTimeNow}</td>  
					<td>${serial.seDayNow}</td>  
					<td>${serial.seConId}</td>  
					<td>${serial.seCRoom}</td>  
				    </tr>
				</c:forEach>
		        </tbody>
		    </table>
		</div> 
    </div>
    
</body>

</html>