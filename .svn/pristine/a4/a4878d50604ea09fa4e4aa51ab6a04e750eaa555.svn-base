<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>无标题文档</title>
<link href="admin/css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
  	.fee{
            font-size:20px;
            float:left;
            margin-bottom:5px;
        }
</style>
<script type="text/javascript" src="admin/js/public/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});


</script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>管理信息</li>
    <li>计费设置</li>
    </ul>
    </div>
    
    <div class="rightinfo">
    <div class="tools">  
        <div class="formtitle1"><span>退房规定</span></div>
    </div>
    <table class="tablelist">
    <thead>
    	<tr>
        <th style="width:15%;">退房时间</th>
        <th style="width:15%;">超时半天时间</th>
        <th style="width:55%;">说明</th>
        <th style="width:15%;">操作</th>
        </tr>
        </thead>
        <tbody id="overTimeBody">
		<tr>
			<td id="stime"></td>
			<td id="etime"></td>
			<td id="detail" style="text-align:center;"></td>
			<td id="operation"></td>
		</tr>
              
        </tbody>
    </table>
    <div class="tools">  
        <div class="formtitle1"><span>全场折扣</span></div>
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>编号<i class="sort"><img src="admin/img/px.gif" /></i></th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>折扣值</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody id="discountbody">
              
        </tbody>
    </table>
  
   
    <div class="pagin">
        <div style="float:left;"><a href="admin/addfeecount.jsp" class="tablelink">添加</a></div>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="admin/img/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>
<script>
function showAllDiscount(){
	$.ajax({
		url:"/HotelManagement/findAllDiscount.action",
		method:"post",
		async:true,
		success:function(data){
			var content="";
			if(data.length==0){
				content+="<tr> <td colspan='6' style='text-align:center;'>本店最近无全场折扣！</td> </tr>";
			}else{
				for(var i=0;i<data.length;i++){
					content+="<tr><td>"+(i+1)+"</td>"
					+"<td>"+data[i].startTime+"</td>"
					+"<td>"+data[i].endTime+"</td>"
					+"<td>"+data[i].value+"</td>"
					+"<td><a href='admin/changefeecount.jsp?id="+data[i].id+"&stime="+data[i].startTime+"&etime="+data[i].endTime+"' class='tablelink'>修改</a><a style='cursor:pointer;' onclick='deletefeecount("+data[i].id+")' class='tablelink'> 删除</a></tr>";
				}
				
			}	
			$("#discountbody").html(content);
		}
	});
}
function showOverTimeRule(){
	$.ajax({
		url:"/HotelManagement/findHotelOverTimeRule.action",
		method:"post",
		async:true,
		success:function(data){
			$("#stime").html(data.overHalfDayStartTime);
			$("#etime").html(data.overAllDayStartTime);
			var content="";
			content+="每天"+data.overHalfDayStartTime+"前退房，退房时间如超过"+data.overHalfDayStartTime+"未超过"+data.overAllDayStartTime+"，追加半天房费，超过"+data.overAllDayStartTime+"，追加一天房费";
			$("#detail").html(content);
			$("#operation").html("<a href='admin/changeOverTimeRule.jsp 'class='tablelink'>修改</a>");
		}
	});
}
function deletefeecount(id){
	$.ajax({
		url:"/HotelManagement/deleteDiscountById.action",
		method:"post",
		async:true,
		data:"id="+id,
		success:function(data){
			window.location.reload();
		}
	});
}

showOverTimeRule();
showAllDiscount();
</script>
</html>
