function submit(){
	$.ajax({
		url:"CheckOutServlet",
		type:"post",
		dataType:"json",
		data:{
		},
		success:function(data){
			$("#mes").html(data);
		}
	})
};