		function findManager(ppag) {
			var id =paramid();
			$.ajax({
				url : "findManagerAction.action",
				method : "post",
				async : true,
				dataType : "json",
				data : "userid=" +id+"&current=" + ppag,
				success : function(message) {
							
 							var meg=message.list;
 							if(meg.length==0){
 								alert("该用户不存在")
 								window.location.href="admin/manager.jsp"
 							}
 							else{
 							var arr=meg[0].listMr;
 							
							for(var i=0;i<arr.length;i++){
								var g=arr[i];
								if(g.mrOffTime==null){
								var str="<tr>"+
								"<td id='mrid"+i+"'>"+g.mrId+"</td>"+
								"<td id='uptime"+i+"'>"+g.mrOnTime+"</td>"+
								"<td id='offtime0"+i+"'>"+"未打卡"+"</td>"+
								"</tr>";
							$("#managerlog").append(str);
								}
								else{
									var str="<tr>"+
									"<td id='mrid"+i+"'>"+g.mrId+"</td>"+
									"<td id='uptime"+i+"'>"+g.mrOnTime+"</td>"+
									"<td id='offtime0"+i+"'>"+g.mrOffTime+"</td>"+
									"</tr>";
								$("#managerlog").append(str);
								}
							}
					var pagin="<div id='message' class='message'></div>"+
						"<ul class='paginList'>"+
						"<li onclick='prePage()' class='paginItem'><span class='pagepre'></span></a></li>"+
						"<li id='test' class='paginItem'></li>"+
						"<li onclick='nextPage()' class='paginItem'><span class='pagenxt'></span></a></li>"
						"</ul>"
			$("#pagin").append(pagin);
			var t = "共<i class=\"blue\">" + message.total + "</i>条记录，<i class=\"blue\" id=\"totalPage\">" + message.lastPage + "</i>&nbsp;页，当前显示第&nbsp;<i class=\"blue\" id=\"currentPage\">" + ppag + "</i>页";
			$("#message").html(t);
			$("#test").html(ppag);
		
						}
				} 
			});
		}
		findManager(1);
		function nextPage() {
	var current = parseInt($("#currentPage").html());
	var total = parseInt($("#totalPage").html());
	if (total > current) {
		$("#managerlog").html("");
		findManager(current + 1);
	}
}
function prePage() {
	var current = parseInt($("#currentPage").html());
	var total = parseInt($("#totalPage").html());
	if (current > 1) {
		$("#managerlog").html("");
		findManager(current - 1);
	}
}