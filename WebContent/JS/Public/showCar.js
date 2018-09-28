function showCar(){
	$.ajax({
		url:"ShowCarServlet",
		type:"post",
		dataType:"json",
		data:{
		},
		success:function(data){
			var goods=data.goods;
			var goodsContent="";
			if(goods.length>0){
				goodsContent+="<div style='height:20px;' align='center'>实物图片</div>"+
				"<div style='height:20px;' align='center'>商品号</div>"+
				"<div style='height:20px;' align='center'>商品名称</div>"+
				"<div style='height:20px;' align='center'>单价</div>"+
				"<div style='height:20px;' align='center'>购买数量</div>";
				for(var i=0;i<goods.length;i++){
					goodsContent+="<div class='realGoods'><a href='JSP/goodsInfo.jsp?goodsimg="+goods[i].imgsrc+"&briefintroduction="+goods[i].briefintroduction+"&goodsid="+goods[i].goodsid+"&goodsname="+goods[i].goodsname+"&brand="+goods[i].brand+"&balance="+goods[i].goodsbalance+"件'><img src="+goods[i].imgsrc+"></a></div>"+
					"<div class='realGoods' id='g"+i+"'>"+goods[i].goodsid+"</div>"+
					"<div class='realGoods'>"+goods[i].goodsname+"</div>"+
					"<div class='realGoods'>"+goods[i].price+"</div>"+
					"<div class='realGoods'><div style='width:100%;height:22px;margin-top:30px;'><input type='button' value='添加' onclick='add("+i+")'><input type='text' style='width:40px;text-align:center;' value='"+goods[i].goodscount+"'/><input type='button' value='减少' onclick='decrease("+i+")'></div></div>";
				}
				goodsContent+="<input type='button' value='结账' style='margin-left:600px;' id='button' onclick='checkOut()'/>";
				$("#body").html(goodsContent);
				 var $mymes=$("<div id='mes' style='color:red;border:1px transparent solid;'></div>");
				 $("body").append($mymes);
				 $("#mes").html(data);
			}
			else{
				alert("购物车为空！");
				window.location.href="JSP/goods.jsp";				
			}
		}
	})
}
function add(i){
	$.ajax({
		url:"AddCarServlet",
		type:"post",
		dataType:"json",
		data:{
			goodsid:$("#g"+i).html()
		},
		success:function(data){
			$("#mes").html(data);
			if(data=="添加成功！"){
				showCar();
			}	
		}
	});
}
function decrease(i){
	$.ajax({
		url:"DecreaseCarServlet",
		type:"post",
		dataType:"json",
		data:{
			goodsid:$("#g"+i).html()
		},
		success:function(data){
			$("#mes").html(data);
			if(data=="减少成功！"){
				showCar();
			}	
		}
	});
}
function checkOut(){
	window.location.href="JSP/selectAdress.jsp";
}
showCar();