function login(){
	$.ajax({
		url:"LoginServlet",
		type:"post",
		dataType:"json",
		data:{
			account:$("#account").val(),
			pass:$("#userpass").val(),
			code:$("#identitycode").val()
		},
		success:function(data){
			$("#mes").html(data);
	        if(data=="登录成功！"){
	        	window.location.href="JSP/goods.jsp";
	        }
		}
	});
	
}