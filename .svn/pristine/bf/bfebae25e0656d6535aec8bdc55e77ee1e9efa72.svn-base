function comment(page) {
document.location="/HotelManagement/comment.action?page="+page;
}
  function firstPage(page){
  	comment(page);	
  	}
  function nextPage(page){
	  comment(page);
	}
  function lastPage(page){
	  comment(page);
	}
  function endPage(page){
	  comment(page);
	}
 function check(){
	 // 在最后一页是禁用next和end按键
	 if($("#current").html() == $("#total").html()){
		 $("#next").attr('disabled',true);
		 $("#end").attr('disabled',true);
	 }
	 // 在第一页时禁用first和last按键
	 if($("#current").html() == 1){		 
		 $("#first").attr('disabled',true);
		 $("#last").attr('disabled',true);
	 }
 }