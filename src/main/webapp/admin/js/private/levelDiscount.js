function showleveldiscount(){
	$.ajax({
		url:"showLevelDiscountAction.action",
		method :"post",
		async : true,
		dataType:"json",
		success:function(message){
			var ml=message.length;
			for(var i=0;i<ml;i++){
				var g=message[i];
				var str="<tr>"+
				"<td id='classid"+i+"'>"+g.classId+"</td>"+
				"<td id='classname"+i+"'>"+g.className+"</td>"+
				"<td id='classdiscount"+i+"'>"+g.classDiscount+"</td>"+
				"<td id='classconsume"+i+"'>"+g.classConsume+"</td>"+
				"<td>"+
				"<a href='admin/upleveldiscount.jsp?id="+g.classId+"' class='tablelink'>修改</a></td>"
				"</tr>";
				$("#manager").append(str); 
			}
		}
		
	})
}
showleveldiscount();