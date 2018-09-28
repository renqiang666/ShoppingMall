function changeInfor(){
		$.ajax({
			url:"/HotelManagement/changeMail.action",
			type:"post",
			dataType:"json",
			data:{
				mail:$("#email").val(),
			},
			success:function(data){	
				if(data=="Email updated successfully"){
					window.location.reload();
				}else{
					alert(data);
				}
			}
		});
}
function showInfor(){
	$.ajax({	 
		url:"/HotelManagement/showInfo.action",
		type:"post",
		dataType:"json", 
		data:{
		},
		success:function(data){		
			$("#nicname").val(""+data.name+"");
			$("#location").val(""+data.iden+"");
			$("#email").val(""+data.email+"");
			
			if($("#email").val()=="null"){
				$("#cemail").html("添加信息");
				$("#email").val("");
			}
			
		}
	});
}

showInfor()