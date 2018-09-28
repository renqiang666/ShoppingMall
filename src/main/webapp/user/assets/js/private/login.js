function accountLogin(){
	var account=encr($("#account").val());
	var pass=encr($("#password").val());
	var code=encr($("#vercode").val());
	$.ajax({
		url:"/HotelManagement/accountLogin.action",
		type:"post",
		dataType:"json",
		data:{
			account:account,
			pass:pass,
			vercode:$("#vercode").val(),
		},
		success:function(data){
			$("#rhint").html(data);
			if(data=="登陆成功"){				
				window.location.href="/HotelManagement/roomtype.action";
			}else{
				getCode();
			}
		}
	});
	
}
function getLoginCode(){
	var account=encr($("#tel").val());
	$.ajax({
		url:"/HotelManagement/loginCode.action",
		type:"post",
		dataType:"json",
		data:{
			account:account,
		},
		success:function(data){
			$("#hint").html(data);
			}
	});
}
function telLogin(){
	var account=encr($("#tel").val());
	var code=encr($("#rpic").val());
	$.ajax({
		url:"/HotelManagement/telLogin.action",
		type:"post",
		dataType:"json",
		data:{
			ifTel:account,
			ifCode:code,
		},
		success:function(data){
			$("#hint").html(data);
			if(data=="登陆成功"){	
				window.location.href="/HotelManagement/roomtype.action";
			}
			}
	});
}

function checka() {
    var totalMinute = document.getElementById("account").value;
    var temp = "";
    for (var i=0; i<totalMinute.length; i++) {
        var code = totalMinute.charCodeAt(i);
        if (code >= 48 && code <= 57  ) {
            temp += totalMinute.charAt(i);
        }
    }
    if(totalMinute.length>11){	
    		temp = totalMinute.substring(0, 11);   	
    }
    document.getElementById("account").value = temp;
}

function checkt() {
    var totalMinute = document.getElementById("tel").value;
    var temp = "";
    for (var i=0; i<totalMinute.length; i++) {
        var code = totalMinute.charCodeAt(i);
        if (code >= 48 && code <= 57  ) {
            temp += totalMinute.charAt(i);
        }
    }
    if(totalMinute.length>11){
        temp = totalMinute.substring(0, 11);
    }
    document.getElementById("tel").value = temp;
}
function getCode(){
	document.getElementById("vercodepicture").src="/HotelManagement/PictureCheckCodeServlet?a="+Math.random();
}
getCode();