/**
 * 
 */
function showAll(currentPage){
	$.ajax({
		url:"showReserveMessage.action",
		async: true,
		type: "post",
		dataType: "json",
		data:"current="+currentPage,
		success: function(data){
			var msg=data.list;
			var context="";
			for (var i=0;i<msg.length;i++){
			var s="";
			if(msg[i].state==10){
     				s="待付款";
     		}else if(msg[i].state==20){
     				s="已付款";
     		}else if(msg[i].state==30){
     				s="已取消";
     		}else if(msg[i].state==40){
     				s="交易关闭";
     		}else if(msg[i].state==0){
     			s="线下预订";
     		}
				context+="<tr>"+
        		"<td>"+msg[i].id+"</td>"+
        		"<td>"+msg[i].reservePeopleName+"</td>"+
        		"<td>"+msg[i].tel+"</td>"+
       			"<td>"+msg[i].arrive+"</td>"+
       			/*"<td>"+msg[i].cancel+"</td>"+*/
       			"<td>"+msg[i].checkIn+"</td>"+
     			"<td>"+msg[i].checkOut+"</td>"+
     			"<td>"+msg[i].checkInPeople+"</td>"+
     			"<td>"+msg[i].roomType+"</td>"+
     			"<td>"+msg[i].money+"</td>"+
     			"<td>"+s+"</td>"+
    			"<td><a href=\"/HotelManagement/showReserveMessageDetail.action?id="+msg[i].id+"&reservePeopleId="+msg[i].reservePeopleId+"\" class=\"tablelink\">查看</a>"+ 
    			"	<a href=\"/HotelManagement/deleteMsgAboutReserve.action?id="+msg[i].id+"&reservePeopleId="+msg[i].reservePeopleId+"\" class=\"tablelink\"> 删除</a>"+
    			"</td>"+
       		 "</tr>";
			}
			var t=
    	"共<i class=\"blue\">"+data.total+"</i>条记录，<i class=\"blue\" id=\"totalPage\">"+data.lastPage+"</i>&nbsp;页，当前显示第&nbsp;<i class=\"blue\" id=\"currentPage\">"+currentPage+"</i>页";
			$("#tbody").html(context);
			$("#message").html(t);
		}
	});
}
showAll(1);
function nextPage(){
	var current=parseInt($("#currentPage").html());
	var total=parseInt($("#totalPage").html());
	if(current+1>total){
		showAll(1);
	}else{
		showAll(current+1);
	}
}
function prePage(){
	var current=parseInt($("#currentPage").html());
	var total=parseInt($("#totalPage").html());
	if(current-1==0){
		showAll(total);
	}else{
		showAll(current-1);
	}
}
function findMsg(){
	var name=$("#reserveName").val();
	var id=$("#reserveId").val();
	if(name.length!=0 && id.length!=0){
		alert("请不要同时输入两个查询条件");
		$("#reserveId").val("");
		$("#reserveName").val("");
	}else if(name.length!=0){
		Search(1, name, "/HotelManagement/showReserveMessageByName.action");
	}else if(id.length!=0){
		Search(1, id, "/HotelManagement/showReserveMessageById.action");
	}
}
function Search(currentPage,param,path){
	$.ajax({
		url:path,
		async: true,
		type: "post",
		dataType: "json",
		data:"currentPage="+currentPage+"&param="+param,
		success: function(data){
			var msg=data.list;
			var context="";
			for (var i=0;i<msg.length;i++){
			var s="";
			if(msg[i].state==10){
     				s="待付款";
     		}else if(msg[i].state==20){
     				s="已付款";
     		}else if(msg[i].state==30){
     				s="已取消";
     		}else if(msg[i].state==40){
     				s="交易关闭";
     		}else if(msg[i].state==0){
     			s="线下预订";
     		}
				context+="<tr>"+
        		"<td>"+msg[i].id+"</td>"+
        		"<td>"+msg[i].reservePeopleName+"</td>"+
        		"<td>"+msg[i].tel+"</td>"+
       			"<td>"+msg[i].arrive+"</td>"+
       			/*"<td>"+msg[i].cancel+"</td>"+*/
       			"<td>"+msg[i].checkIn+"</td>"+
     			"<td>"+msg[i].checkOut+"</td>"+
     			"<td>"+msg[i].checkInPeople+"</td>"+
     			"<td>"+msg[i].roomType+"</td>"+
     			"<td>"+msg[i].money+"</td>"+
     			"<td>"+s+"</td>"+
    			"<td><a href=\"/HotelManagement/showReserveMessageDetail.action?id="+msg[i].id+"&reservePeopleId="+msg[i].reservePeopleId+"\" class=\"tablelink\">查看</a>"+ 
    			"	<a href=\"/HotelManagement/deleteMsgAboutReserve.action?id="+msg[i].id+"&reservePeopleId="+msg[i].reservePeopleId+"\" class=\"tablelink\"> 删除</a>"+
    			"</td>"+
       		 "</tr>";
			}
			var t=
    	"共<i class=\"blue\">"+data.total+"</i>条记录，<i class=\"blue\" id=\"totalPage\">"+data.lastPage+"</i>&nbsp;页，当前显示第&nbsp;<i class=\"blue\" id=\"currentPage\">"+currentPage+"</i>页";
			$("#tbody").html(context);
			$("#message").html(t);
		}
	});
}