function showManager(ppag) {
	$.ajax({
		url : "showManagerAction.action",
		method : "post",
		async : true,
		dataType : "json",
		data:"current="+ppag,
		success : function(message) {
			var meg=message.list
			var str="";
			var ml = meg.length;
			for (var i = 0; i < ml; i++) {
				var g=meg[i];
				var str="<tr>"+
				"<td id='uid"+i+"'>"+g.userId+"</td>"+
				"<td id='uname"+i+"'>"+g.userName+"</td>"+
				"<td>"+
				"<a href='admin/managerlog.jsp?id="+g.userId+"'class='tablelink'>查看</a>"+"   "+
				"<a onclick='delmanager("+g.userId+")' class='tablelink'>删除</a></td>"
				"</tr>";
				$("#manager").append(str); 
			}
			var t=
				"共<i class=\"blue\">"+message.total+"</i>条记录，<i class=\"blue\" id=\"totalPage\">"+message.lastPage+"</i>&nbsp;页，当前显示第&nbsp;<i class=\"blue\" id=\"currentPage\">"+ppag+"</i>页";
			$("#message").html(t);
			$("#test").html(ppag);
		}
	});
}
showManager(1);

function delmanager(id){
	$.ajax({
		url:"delManagerAction.action",
		method : "post",
		async : true,
		dataType : "json",
		data : "userid=" +id,
		success:function (message){
			alert(message);
			if(message=="删除成功"){
				window.location.reload();
			}
		}
	});
}
function nextPage(){
	var current=parseInt($("#currentPage").html());
	var total=parseInt($("#totalPage").html());
	if(total>current){
		$("#manager").html(""); 
		showManager(current+1);
	}
}
function prePage(){
	var current=parseInt($("#currentPage").html());
	var total=parseInt($("#totalPage").html());
	if(current>1){
		$("#manager").html(""); 
		showManager(current-1);
	}
}

function a(){
	var b=$("#userid").val();
	if($("#userid").val()==""){
		$("#hint").html("请输入查询id");
	}
	else{
	window.location.href="admin/managerlog.jsp?id="+b;
	}
}
