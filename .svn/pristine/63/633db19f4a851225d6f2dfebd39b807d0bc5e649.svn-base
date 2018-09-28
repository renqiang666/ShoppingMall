function sendTel(){
	$.ajax({
		url:"/HotelManagement/judgeAccount.action",
		type:"post",
		dataType:"json",
		data:{
			account:$("#value1").val(),
		},
		success:function(data){
			$("#hint1").html(data);
			}
	});
}

function registerCode(){
	var account=encr($("#value1").val());
	$.ajax({
		url:"/HotelManagement/registerCode.action",
		type:"post",
		dataType:"json",
		data:{
			account:account,
		},
		success:function(data){
			$("#hint7").html(data);
			}
	});
}


function userRegister(){
	var account=encr($("#value1").val());
	var pass=encr($("#value2").val());
	var code=encr($("#registerCode").val());
	$.ajax({
		url:"/HotelManagement/userRegister.action",
		type:"post",
		dataType:"json",
		data:{
			account:account,
			pass:pass,
			name:$("#value4").val(),
			email:$("#value5").val(),
			iden:$("#value6").val(),
			code:code,
		},
		success:function(data){
			$("#hint7").html(data);
			if(data=="注册成功"){
				window.location.href="/HotelManagement/roomtype.action";
			}
			}
	});
}