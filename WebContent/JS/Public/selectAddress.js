function selectAddress(){
	$.ajax({
		url:"ShowPersonInfoServlet",
		type:"post",
		dataType:"json",
		data:{
		},
		success:function(data){
			var users=data.users;
			var usersContent="";
			usersContent+="<div class='head' style='height:20px;width:683px;background-color:lightskyblue;color: white;' align='center'>收货信息</div>"+
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
				"<div style='width:75px;' align='center' class='info'><input type='button' value='选择' id='"+i+"' style='margin:0 auto;margin-top:40px;' onclick=submit();></div>";
			}
//			usersContent+="<div id='mes' style='color:red;'></div>";
			$("#body").html(usersContent);
			 var $mymes=$("<div id='mes' style='color:red;border:1px transparent solid;'></div>");
			 $("body").append($mymes);
			 $("#mes").html(data);
		}
	})
};
selectAddress();