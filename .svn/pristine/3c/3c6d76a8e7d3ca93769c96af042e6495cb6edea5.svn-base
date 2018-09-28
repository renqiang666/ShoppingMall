/**
 * 
 */
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
function addReserve() {
	var reg=/^[1][3,4,5,7,8][0-9]{9}$/;
	var stime=$("#checkIn").val();
    var etime=$("#checkOut").val();
    var attime=$("#arrive").val();
    var overtime=$("#cancel").val();
    var pname=$("#people_name").val();
    var tel = $("#people_tel").val();
    var msg=$("#people_context").val();
    var cname=$("#checkInPerson").val();
    $(".roomCount").each(function(){
    	if($(this).val()<=0){
    		$("#count-mes").html("请输入正确的预定数量(至少为1)");
    	}
    })
    if(pname==""){
    	$("#name-mes").html("预订人姓名不能为空")	
    }else if(tel==""){
    	$("#tel-mes").html("手机号不能为空");	
    }else if(!reg.test(tel)){
    	$("#tel-mes").html("请输入正确的手机号");
    }else if(stime==""){
    	$("#in-mes").html("入住时间不能为空！");
    }else if(stime<getNowFormatDate()){
    	$("#in-mes").html("入住时间不能小于当前日期！");
    }else if(etime==""){
    	$("#out-mes").html("退房时间不能为空！");
    }else if(stime>=etime){
    	$("#out-mes").html("退房时间不能小于等于入住时间！");
    }else if(attime==""){	
    	$("#ar-mes").html("预抵时间不能为空！");
    }else if(overtime==""){
    	$("#ca-mes").html("取消时间不能为空！");
    }else if(stime!=attime.substr(0,10)){
    	$("#ar-mes").html("预抵时间必须与入住时间在同一天");
    }else if(stime!=overtime.substr(0,10)){
    	$("#ca-mes").html("取消时间必须与入住时间在同一天");
    }else if(attime>overtime){
    	$('#ca-mes').html("预抵时间必须在取消时间之前");
    }else if(cname==""){
    	$("#cname-mes").html("请至少输入一位入住人姓名");	
    }else{
		var i = 0;
		var list = new Array();
		$(".roomType").each(function() {
			var roomType = {};
			roomType.id = $(this).find("option:selected").val();
			list.push({
				roomTypeBean : roomType
			});
			i++;
		});
		$(".roomCount").each(function() {
			var number = {};
			number.count = $(this).val();
			list.push({
				reserveNumberBean : number
			});
			
		})
		var people = {};
			people.name = pname;
			people.tel = tel;
			people.message = msg;
		list.push({
			reservePeopleBean : people
		});

		var person = {};
			person.name = cname;
		list.push({
			checkInPersonBean : person
		});

		var room = {};
			room.checkIn = stime;
			room.checkOut = etime;
			room.cancel = overtime;
			room.arrive = attime;
		list.push({
			reserveRoomBean : room
		});

		list.push({
			i : i
		});
		$.ajax({
			url : "/HotelManagement/addReserveFromManager.action",
			type : "post",
			dataType : "json",
			data : JSON.stringify(list),
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				alert(data);
				if(data=="添加成功!"){
					window.location.reload();
				}
				
			}
		});
	}
}
	