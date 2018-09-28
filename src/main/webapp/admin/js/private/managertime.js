function findallrecord(ppag){
	$.ajax({
		url : "../recordAction.action",
		method : "post",
		async : true,
		dataType : "json",
		data : "current=" + ppag,
		success : function(message) {
			var meg = message.list
			var str = "";
			var ml = meg.length;
			for (var i = 0; i < ml; i++) {
				var g = meg[i];
				if(g.vmOffTime==null){
				var str = "<tr>" +
				"<td id='vmid" + i + "'>" + g.vmId + "</td>" +
				"<td id='mname" + i + "'>" + g.vmName + "</td>" +
				"<td id='vmontime" + i + "'>" + g.vmOnTime + "</td>" +
				"<td id='vmofftime" + i + "'>" +"未打卡"+ "</td>" +
				"<td id='vmstatus" + i + "'>" + g.vmStatus+ "</td>" +
				"<td>" +
				"</tr>";
				
				$("#manager").append(str);
				
				}
				else{
					var str = "<tr>" +
					"<td id='vmid" + i + "'>" + g.vmId + "</td>" +
					"<td id='mname" + i + "'>" + g.vmName + "</td>" +
					"<td id='vmontime" + i + "'>" + g.vmOnTime + "</td>" +
					"<td id='vmofftime" + i + "'>" + g.vmOffTime+ "</td>" +
					"<td id='vmstatus" + i + "'>" + g.vmStatus+ "</td>" +
					"<td>" +
					"</tr>";
					$("#manager").append(str);
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
	});
}
findallrecord(1);

function nextPage() {
	var current = parseInt($("#currentPage").html());
	var total = parseInt($("#totalPage").html());
	if (total > current) {
		$("#manager").html("");
		findallrecord(current + 1);
	}
}
function prePage() {
	var current = parseInt($("#currentPage").html());
	var total = parseInt($("#totalPage").html());
	if (current > 1) {
		$("#manager").html("");
		findallrecord(current - 1);
	}
}
function nextPagetime() {
	var current = parseInt($("#currentPage").html());
	var total = parseInt($("#totalPage").html());
	if (total > current) {
		$("#manager").html("");
		findtime(current + 1);
	}
}
function prePagetime() {
	var current = parseInt($("#currentPage").html());
	var total = parseInt($("#totalPage").html());
	if (current > 1) {
		$("#manager").html("");
		findtime(current - 1);
	}
}
function findtime(ppag){
	var time=$("#stime").val();
	alert(time);
	$.ajax({
		url : "../findTimeAction.action",
		method : "post",
		async : true,
		dataType : "json",
		data : "date=" + time+ "&current=" + ppag,
		success : function(message) {
			$("#managerid").html("");
			$("#manager").html("");
			var meg = message.list
			var str = "";
			var ml = meg.length;
			for (var i = 0; i < ml; i++) {
				var g = meg[i];
				var str = "<tr>" +
				"<td id='vmid" + i + "'>" + g.vmId + "</td>" +
				"<td id='mname" + i + "'>" + g.vmName + "</td>" +
				"<td id='vmontime" + i + "'>" + g.vmOnTime + "</td>" +
				"<td id='vmofftime" + i + "'>" + g.vmOffTime+ "</td>" +
				"<td id='vmstatus" + i + "'>" + g.vmStatus+ "</td>" +
				"<td>" +
				"</tr>";
				$("#manager").append(str);
			}
			var pagin="<div id='message' class='message'></div>"+
			"<ul class='paginList'>"+
"<li onclick='prePagetime()' class='paginItem'><span class='pagepre'></span></a></li>"+
"<li id='test' class='paginItem'></li>"+
"<li onclick='nextPagetime()' class='paginItem'><span class='pagenxt'></span></a></li>"
"</ul>"
			$("#pagin").append(pagin);
			var t = "共<i class=\"blue\">" + message.total + "</i>条记录，<i class=\"blue\" id=\"totalPage\">" + message.lastPage + "</i>&nbsp;页，当前显示第&nbsp;<i class=\"blue\" id=\"currentPage\">" + ppag + "</i>页";
			$("#message").html(t);
			$("#test").html(ppag);
			$("#managerid").html(time);
		}
	});
}
