function showGoods(ppage){
	$.ajax({
		url:"GoodsServlet",
		type:"post",
		dataType:"json",
		data:{
			page:ppage
		},
		success:function(data){
			var currentPage=data.currentPage;
			var totalPage=data.totalPage;
			var goods=data.goods;
			$("#currentPage").html(currentPage);
			$("#totalPage").html(totalPage);
			for(var i=0;i<goods.length;i++){
				document.getElementById("img"+(i+1)).src =goods[i].imgsrc;
				document.getElementById("a"+(i+1)).href="JSP/goodsInfo.jsp?goodsimg="+goods[i].imgsrc+"&briefintroduction="+goods[i].briefintroduction+"&goodsid="+goods[i].goodsid+"&goodsname="+goods[i].goodsname+"&brand="+goods[i].brand+"&balance="+goods[i].goodsbalance+"件";  
				$("#n"+(i+1)).html(goods[i].goodsname);
				$("#p"+(i+1)).html(goods[i].price+"元");
				$("#i"+(i+1)).html(goods[i].brand);
			}
		}
	})
}
function nextPage(){
	var currentPage=parseInt($("#currentPage").html());
	var totalPage=parseInt($("#totalPage").html());
	var nextPage=currentPage+1;
	if(nextPage<=totalPage){
		showGoods(nextPage);
	}
}
function lastPage(){
	var currentPage=parseInt($("#currentPage").html());
	var lastPage=currentPage-1;
	if(lastPage>0){
		showGoods(lastPage);
	}
}
function showFirstPage(){
	showGoods(1);
}
function showLastPage(){
	var totalPage=parseInt($("#totalPage").html());
	showGoods(totalPage);
}
showGoods(1);