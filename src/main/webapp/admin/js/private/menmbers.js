		function showMenmbers(ppag) {
			$.ajax({
				url : "showMenmbersAction.action",
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
							var str = "<tr>" +
								"<td id='mid" + i + "'>" + g.mId + "</td>" +
								"<td id='mname" + i + "'>" + g.mName + "</td>" +
								"<td id='mconsume" + i + "'>" + g.mConsume + "</td>" +
								"<td id='mclassname" + i + "'>" + g.lb.className + "</td>" +
								"<td id='mclassdiscount" + i + "'>" + g.lb.classDiscount*10+"折" + "</td>" +
								"<td>" +
								"<a onclick='delmanager("+g.mId+")' class='tablelink'>删除</a></td>"
							"</tr>";
							$("#menmbers").append(str);
						}
						var t = "共<i class=\"blue\">" + message.total + "</i>条记录，<i class=\"blue\" id=\"totalPage\">" + message.lastPage + "</i>&nbsp;页，当前显示第&nbsp;<i class=\"blue\" id=\"currentPage\">" + ppag + "</i>页";
						$("#message").html(t);
						$("#test").html(ppag);
	
					
				}
			});
		}
		showMenmbers(1);
		function nextPage() {
			var current = parseInt($("#currentPage").html());
			var total = parseInt($("#totalPage").html());
			if (total > current) {
				$("#menmbers").html("");
				showMenmbers(current + 1);
			}
		}
		function prePage() {
			var current = parseInt($("#currentPage").html());
			var total = parseInt($("#totalPage").html());
			if (current > 1) {
				$("#menmbers").html("");
				showMenmbers(current - 1);
			}
		}
		function delmanager(id){
			$.ajax({
				url:"delMenmbersAction.action",
				method : "post",
				async : true,
				dataType : "json",
				data : "mid=" +id,
				success:function (message){
				alert(message);
				if(message=="删除成功"){
				window.location.reload();
			}
		}
	}); 
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