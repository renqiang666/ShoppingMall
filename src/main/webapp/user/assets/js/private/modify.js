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
function modifyReserveInfo() {
	var stime=$("#checkIn").val();
    var etime=$("#checkOut").val();
    var attime=$("#arrive").val();
    var overtime=$("#cancel").val();
    var msg=$("#people_context").val();
    var cname=$("#person").val();
    if(stime==""){
    	$("#mes").html("入住时间不能为空！");
    }else if(stime<getNowFormatDate()){
    	$("#mes").html("入住时间不能小于当前日期！");
    }else if(etime==""){
    	$("#mes").html("退房时间不能为空！");
    }else if(stime>=etime){
    	$("#mes").html("退房时间不能小于等于入住时间！");
    }else if(attime==""){	
    	$("#mes").html("预抵时间不能为空！");
    }else if(overtime==""){
    	$("#mes").html("取消时间不能为空！");
    }else if(stime!=attime.substr(0,10)){
    	$("#mes").html("预抵时间必须与入住时间在同一天");
    }else if(stime!=overtime.substr(0,10)){
    	$("#mes").html("取消时间必须与入住时间在同一天");
    }else if(attime>overtime){
    	$('#mes').html("预抵时间必须在取消时间之前");
    }else if(cname==""){
    	$("#mes").html("请至少输入一位入住人姓名");	
    }else{
    	var list = new Array();	
    	
    	var room={};
    	room.checkIn=stime;
    	room.checkOut=etime;
    	room.arrive=attime;
    	room.cancel=overtime;
    	room.id = $("#roomId").val();
    	
    	list.push({reserveRoomBean:room});
    		
    	var person = {};
    	person.id=$("#personId").val();
    	person.name = cname;
    	list.push({checkInPersonBean:person});
    	
    	var people = {};
    	people.id=$("#peopleId").val();
    	people.message = msg;
    	list.push({reservePeopleBean:people});

		$.ajax({
			url : "/HotelManagement/modifyReserveInfo.action",
			type : "post",
			dataType : "json",
			data : JSON.stringify(list),
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if(data==true){
					alert("修改成功");
					window.location.href="/HotelManagement/ReserveInfo.action?page=1";
				}else{
					alert("修改失败！");
				}
				
			}
		});
	}
}