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
$(function() {
	$("#aaa").click(function() {
		$.ajax({
			url:"determineLogin.action",
			type:"get",
			dataType:"json",
			success:function(data){
				if(data== false){
					alert("当前没有登陆,请登录!");
				}else{
					$("#cArrive").removeAttr('readonly');
					$("#cCancel").removeAttr('readonly');
					$("#firstperson").removeAttr('readonly');
					$("#cArrive").val($("#arrive").val());
					$("#cCancel").val($("#cancel").val());
					$("#firstperson").val($(".checkInPerson").val());
					$("#cArrive").attr('readonly','readonly');
					$("#cCancel").attr('readonly','readonly');
					$("#firstperson").attr('readonly','readonly');
					$("#confirmation").fadeIn();
				}
				
			}
	})
})
})
$(function(){
	$("#back").click(function(){
		$("#confirmation").fadeOut();
	})
})
function addReserve() {
	 	var stime=$("#checkIn").val();
	    var etime=$("#checkOut").val();
	    var attime=$("#arrive").val();
	    var overtime=$("#cancel").val();
	    if(attime==""||overtime==""){
	    	$("#mes").html("时间不能有空值！");
	    }else if(stime!=attime.substr(0,10)){
	    	$("#mes").html("预抵时间必须与入住时间在同一天");
	    }else if(stime!=overtime.substr(0,10)){
	    	$("#mes").html("取消时间必须与入住时间在同一天");
	    }else if(attime>overtime){
	    	$('#mes').html("预抵时间必须在取消时间之前");
	    }else if($("#firstman").val()==""){
	    	$('#mes').html("至少填写一个入住人信息");
	    }else{	
			var list = new Array();
			
			var people = {};
			people.message = $("#message").val();
			list.push({
				reservePeopleBean : people
			});
			
			var room = {};
			room.checkIn = stime;
			room.checkOut = etime;
			room.arrive = attime;
			room.cancel = overtime;
			list.push({
				reserveRoomBean : room
			});
			
			var type={};
			type.id=$("#typeId").val();
			list.push({
				roomTypeBean : type
			})
			
			
			$(".checkInPerson").each(function() {
				var checkInPerson = {};
				checkInPerson.name = $(this).val();
				list.push({
					checkInPersonBean : checkInPerson
				});
			})
			$.ajax({
				url : "/HotelManagement/reserveRoom.action",
				type : "post",
				dataType : "json",
				data : JSON.stringify(list),
				contentType : "application/json;charset=utf-8",
				success : function(data) {
					if (data == "预订成功") {
						alert("预定成功，前往付款界面!");
						window.location.href = "goAlipay.action";
					} else{
						alert(data);
					}
				}
			});
		}
}
	
	function getDays(date1 , date2){
		var date1Str = date1.split("-");//将日期字符串分隔为数组,数组元素分别为年.月.日
		//根据年 . 月 . 日的值创建Date对象
		var date1Obj = new Date(date1Str[0],(date1Str[1]-1),date1Str[2]);
		var date2Str = date2.split("-");
		var date2Obj = new Date(date2Str[0],(date2Str[1]-1),date2Str[2]);
		var t1 = date1Obj.getTime();
		var t2 = date2Obj.getTime();
		var dateTime = 1000*60*60*24; //每一天的毫秒数
		var minusDays = Math.floor(((t2-t1)/dateTime));//计算出两个日期的天数差
		var days = Math.abs(minusDays);//取绝对值
		return days;
}