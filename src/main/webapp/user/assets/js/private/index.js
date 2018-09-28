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
	
	function check(){
		var stime=$("#datetimepicker1").val();
	 	var etime=$("#datetimepicker2").val();
		    if(stime==""||etime==""){
		    	alert("时间不能有空值！");
		    }else if(stime>etime){
		    	alert("入住时间不能小于退房时间！");
		    }else if(stime<getNowFormatDate()){
		    	alert("入住时间不能小于当前日期！");
		    }else{
				var view={"checkIn":stime,
					"checkOut":etime,
					"roomTypeId":$("#roomType").find("option:selected").val()};
				$.ajax({
					url:"checkAvailable.action",
					type:"post",
					dataType: "json",
					async: true,
					contentType : "application/json;charset=utf-8",
					data: JSON.stringify(view),
					success: function(data){
						if(data == "false"){
							alert("很抱歉,当前类型房间在您选定日期内已被预定完,您可以选择其他类型的房间,给您造成的不便请谅解!");
						}else{
							window.location.href=data;	
						}
					}
			});
		}
	}