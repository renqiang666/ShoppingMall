function todayRest(id){
	// 今日剩余
	var roomType = {"id":id}
		$.ajax({
			url:"/HotelManagement/todayrest.action",
			method:"post",
			async:true,
			contentType:"application/json;charset=utf-8",
			dateType:"json",
			data:JSON.stringify(roomType),
			success:function(message){
				
			}
		});
}

