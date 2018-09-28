function addInCar(){
	$.ajax({
		url:"AddCarServlet",
		type:"post",
		dataType:"json",
		data:{
			goodsid:$("#goodsid").html()
		},
		success:function(data){
			$("#mes").html(data);
		}
	})
}
