/**
 * 
 */
function onceMore(){
	window.location.reload();
}
//获取当前时间，格式YYYY-MM-DD
function getNowFormatDate() {
	    var date = new Date();
	    var seperator1 = "-";
	    var year = date.getFullYear();
	    var month = date.getMonth() + 1;
	    var strDate = date.getDate();
	    if (month >= 1 && month <= 9) {
	        month = "0" + month;
	    }
	    if (strDate >= 0 && strDate <= 9) {
	        strDate = "0" + strDate;
	    }
	    var currentdate = year + seperator1 + month + seperator1 + strDate;
	    return currentdate;
	}

function updatePeople(){
	var name = $("#people_name").val();
	var tel = $("#people_tel").val();
	var reg=/^[1][3,4,5,7,8][0-9]{9}$/;
	if(name==""){
		$("#people_name_error").html("用户名不能为空");
	}else if(tel==""){
		$("#people_tel_error").html("手机号不能为空");
	}else if(!reg.test(tel)){
		$("#people_tel_error").html("请输入正确的手机号");
	}else{
		var people = {"id":$("#people_id").val(),
				 "name":name,
				 "tel":tel,
				 "message":$("#people_context").val()};
					$.ajax({
						url:"updatePeopleByManager.action",
						type: "post",
						async: true,
						dataType:"json",
						contentType: "application/json;charset=utf-8",
						data:JSON.stringify(people),
						success:function(data){
						if(data=="更新成功"){
							window.location.reload();
						}else{
							alert(data);		
						}
					}
				});
	}
	 
}

function updateRoom(){
	var stime=$("#checkIn").val();
    var etime=$("#checkOut").val();
    var attime=$("#arrive").val();
    var overtime=$("#cancel").val();
    
    if(stime==""){
    	$("#checkIn_error").html("入住时间不能为空！");
    }else if(stime<getNowFormatDate()){
    	$("#checkIn_error").html("入住时间不能小于当前日期！");
    }else if(etime==""){
    	$("#checkOut_error").html("退房时间不能为空！");
    }else if(stime>=etime){
    	$("#checkOut_error").html("退房时间不能小于等于入住时间！");
    }else if(attime==""){	
    	$("#arrive_error").html("预抵时间不能为空！");
    }else if(overtime==""){
    	$("#cancel_error").html("取消时间不能为空！");
    }else if(stime!=attime.substr(0,10)){
    	$("#arrive_error").html("预抵时间必须与入住时间在同一天");
    }else if(stime!=overtime.substr(0,10)){
    	$("#cancel_error").html("取消时间必须与入住时间在同一天");
    }else if(attime>overtime){
    	$('#cancel_error').html("预抵时间必须在取消时间之前");
    }else{
    	var room = {
    			"id":$("#room_id").val(),
    			"checkIn":stime,
    			"checkOut":etime,
    			"arrive":attime,
    			"cancel":overtime
    			};
    				$.ajax({
    					url:"updateRoomByManager.action",
    					type: "post",
    					async: true,
    					dataType:"json",
    					contentType: "application/json;charset=utf-8",
    					data:JSON.stringify(room),
    					success:function(data){
    					if(data=="更新成功"){
    						window.location.reload();
    						$("#tab1").attr({"class":""});
    						$("#tab2").attr({"class":"selected"});
    					}else{
    						alert(data);
    					}
    				}
    			});
    }
}