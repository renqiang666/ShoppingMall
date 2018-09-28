function showPersonInfo(){
	$.ajax({
		url:"ShowPersonInfoServlet",
		type:"post",
		dataType:"json",
		data:{
		},
		success:function(data){
			var users=data.users;
			var usersContent="";
			usersContent+="<div class='head'style='height:20px;width:683px;background-color:lightskyblue;color: white;' align='center'>个人信息</div>"+
			"<div style='height:20px;background-color:lightskyblue;color: white;' align='center'>照片</div>"+
			"<div style='height:20px;background-color:lightskyblue;color: white;' align='center'>姓名</div>"+
			"<div style='height:20px;background-color:lightskyblue;color: white;' align='center'>账号</div>"+
			"<div style='height:20px;background-color:lightskyblue;color: white;' align='center'>余额</div>"+
			"<div style='height:20px;background-color:lightskyblue;color: white;' align='center'>邮件地址</div>"+
			"<div align='center' class='info'><img src='"+users[0].headImg+"'style='width:100px;height:100px;vertical-align:center;'></div>"+
			"<div align='center' class='info'>"+users[0].name+"</div>"+
			"<div align='center' class='info'>"+users[0].account+"</div>"+
			"<div align='center' class='info'>"+users[0].balance+"</div>"+
			"<div align='center' class='info'>"+users[0].email+"</div>"+
			"<div class='head' style='height:20px;width:683px;background-color:lightskyblue;color: white;' align='center'>收货信息</div>"+
			"<div style='width:150px;height:20px;background-color:lightskyblue;color: white;' align='center'>ID</div>"+
			"<div style='width:150px;height:20px;background-color:lightskyblue;color: white;' align='center'>收货人</div>"+
			"<div style='width:150px;height:20px;background-color:lightskyblue;color: white;' align='center'>收货地址</div>"+
			"<div style='width:150px;height:20px;background-color:lightskyblue;color: white;' align='center'>收货人电话</div>"+
			"<div style='width:75px;height:20px;background-color:lightskyblue;color: white;' align='center'>操作</div>";
			for(var i=0;i<users.length;i++){
				usersContent+="<div style='width:150px;' align='center' class='info'>"+(i+1)+"</div>"+
				"<div style='width:150px;' align='center' class='info'>"+users[i].receiveName+"</div>"+
				"<div style='width:150px;' align='center' class='info'>"+users[i].address+"</div>"+
				"<div style='width:150px;' align='center' class='info'>"+users[i].phone+"</div>"+
				"<div style='width:75px;' align='center' class='info'><input type='button' value='删除' style='margin:0 auto;margin-top:40px;'></div>";
			}
			usersContent+="<input type='button' value='新增收货信息' style='margin:0 auto;margin-left:300px;margin-top:10px;'>";
			$("#body").html(usersContent);
		}
	})
};
showPersonInfo();