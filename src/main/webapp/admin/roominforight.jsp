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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/public/jquery.js"></script>
<script language="javascript">
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
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
    <li>房间设置</li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li><span><img src="img/t01.png" /></span><a href="addRoom.jsp">添加</a></li>
        <li><span><img src="img/t02.png" /></span><a href="changeRoomState.jsp">修改</a></li>
        <li ><span><img src="img/t03.png" /></span><a href="deleteRoom.jsp">删除</a></li>
        </ul>
        
        
        
    
    </div>
    
    
    <table class="imgtable">
    
    <thead>
    <tr>
    <th width="100px;">例图</th>
    <th>房间类型</th>
    <th>可入住数量(/间)</th>
    <th>已入住数量(/间)</th>
    <th>待打扫数量(/间)</th>
    <th>总计(/间)</th>
    </tr>
    </thead>
    
    <tbody>
    
    <tr>
    <td class="imgtd"><img src="img/singleroom.jpg" style="width:80px;height:60px;"/></td>
    <td><a href="#">单人间</a></td>
    <td id="a1"></td>
    <td id="b1"></td>
    <td id="c1"></td>
    <td id="d1"></td>
    </tr>
    
    <tr>
    <td class="imgtd"><img src="img/doubleroom.jpg" style="width:80px;height:60px;"/></td>
    <td><a href="#">双人间</a></td>
    <td id="a2"></td>
    <td id="b2"></td>
    <td id="c2"></td>
    <td id="d2"></td>
    </tr>
    
    <tr>
    <td class="imgtd"><img src="img/bigroom.jpg" style="width:80px;height:60px;"/></td>
    <td><a href="#">大床房</a></td>
    <td id="a3"></td>
    <td id="b3"></td>
    <td id="c3"></td>
    <td id="d3"></td>
    </tr>
    
    <tr>
    <td class="imgtd"><img src="img/president.jpg" style="width:80px;height:60px;"/></td>
    <td><a href="#">总统套房</a></td>
    <td id="a4"></td>
    <td id="b4"></td>
    <td id="c4"></td>
    <td id="d4"></td>
    </tr>
    
    <tr>
    <td class="imgtd"><img src="/HotelManagement/user/assets/images/best-rooms/4.jpg" style="width:80px;height:60px;"/></td>
    <td><a href="#">海景房</a></td>
    <td id="a5"></td>
    <td id="b5"></td>
    <td id="c5"></td>
    <td id="d5"></td>
    </tr>
    
    <tr>
    <td class="imgtd"><img src="/HotelManagement/user/assets/images/best-rooms/5.jpg" style="width:80px;height:60px;"/></td>
    <td><a href="#">桑拿房</a></td>
    <td id="a6"></td>
    <td id="b6"></td>
    <td id="c6"></td>
    <td id="d6"></td>
    </tr>
    
    </tbody>
    
    </table>
    
    
    
    
    

    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="img/ticon.png" /></span>
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
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="img/ticon.png" /></span>
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
    
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	function findRoomTypeDetailInfo(){
		$.ajax({
			url:"/HotelManagement/findAllRoomTypeDetailInfo.action",
			method:"post",
			async:true,
			success:function(data){
				$("#a1").html(data.单人间可入住);
				$("#a2").html(data.双人间可入住);
				$("#a3").html(data.大床房可入住);
				$("#a4").html(data.总统套房可入住);
				$("#a5").html(data.海景房可入住);
				$("#a6").html(data.桑拿房可入住);
				$("#b1").html(data.单人间已入住);
				$("#b2").html(data.双人间已入住);
				$("#b3").html(data.大床房已入住);
				$("#b4").html(data.总统套房已入住);
				$("#b5").html(data.海景房已入住);
				$("#b6").html(data.桑拿房已入住);
				$("#c1").html(data.单人间待打扫);
				$("#c2").html(data.双人间待打扫);
				$("#c3").html(data.大床房待打扫);
				$("#c4").html(data.总统套房待打扫);
				$("#c5").html(data.海景房待打扫);
				$("#c6").html(data.桑拿房待打扫);
				var one=new Array("a","b","c");
				var two=new Array("1","2","3","4","5","6");
				for(var i=0;i<one.length;i++){
				for(var j=0;j<two.length;j++){
					if(!parseInt($("#"+one[i]+two[j]).html())>0){
						$("#"+one[i]+two[j]).html(0);
					}
				}
				}
				
// 				算各类型房间总和
				var a=parseInt($("#a1").html())+parseInt($("#b1").html())+parseInt($("#c1").html());
				var b=parseInt($("#a2").html())+parseInt($("#b2").html())+parseInt($("#c2").html());
				var c=parseInt($("#a3").html())+parseInt($("#b3").html())+parseInt($("#c3").html());
				var d=parseInt($("#a4").html())+parseInt($("#b4").html())+parseInt($("#c4").html());
				var e=parseInt($("#a5").html())+parseInt($("#b5").html())+parseInt($("#c5").html());
				var f=parseInt($("#a6").html())+parseInt($("#b6").html())+parseInt($("#c6").html());
				
				$("#d1").html(a);
				$("#d2").html(b);
				$("#d3").html(c);
				$("#d4").html(d);
				$("#d5").html(e);
				$("#d6").html(f);

			}
		});
	}
	findRoomTypeDetailInfo();
	</script>
    
</body>

</html>
