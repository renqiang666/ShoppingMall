<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会员</title>
<link href="admin/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="admin/js/public//jquery-3.3.1.js"></script>
<script type="text/javascript">
	function menmbersSearch(){
		var select=$('#select1').val();
		var condition=$('#condition').val();
		if(select=='forTel'&&condition.length!=0){
			var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
			if(myreg.test(condition)){
				menmbersSearchAjax(select,condition);
			}else{
				alert("请输入正确的手机号")
			}
		}else if(condition.length==0){
			searchAllMenmbersAjax(1);
		}else{
			menmbersSearchAjax(select,condition);
		}
	}
	function searchAllMenmbersAjax(pageNum){
		$.ajax({
			url:"/HotelManagement/pageMenmbers.action",
			method:"post",
			async:true,
			data:"pageNum="+pageNum,
			success:function(data){
				var members=data.list;
				var str="";
				for(var i=0;i<members.length;i++){
					var m=members[i];
				 	str+="<tr><td>"+m.mId+"</td>"+"<td>"
					+m.mName+"</td>"+"<td>"
					+m.mConsume+"</td>"+"<td>"
					+m.lb.className+"</td>"
					+"</tr>"; 
				}
				str+="<tr><td colspan='4'>";
				if(!data.isFirstPage){
					str+="<button type='button' onclick='searchAllMenmbersAjax(1)'>首页</button>&nbsp;";
				}if(data.hasPreviousPage){
					str+="<button type='button' onclick='searchAllMenmbersAjax("+data.prePage+")'>上一页</button>&nbsp;";
				}
				str+="共："+data.pages+"&nbsp;页&nbsp;";
				if(data.hasNextPage){
					str+="<button type='button' onclick='searchAllMenmbersAjax("+data.nextPage+")'>下一页</button>&nbsp;"
				}
				if(!data.isLastPage){
					str+="<button type='button' onclick='searchAllMenmbersAjax("+data.pages+")'>末页</button>"
				}
				$("#mblist").html(str);
			}
		});
	}
	function menmbersSearchAjax(select,condition){
		$.ajax({
			url:"/HotelManagement/searchMenmbers.action",
			method:"post",
			async:true,
			data:"select1="+select+"&condition="+condition,
			success:function(data){
				var str="";
				for(var i=0;i<data.length;i++){
					var m=data[i];
				 	str+="<tr><td>"+m.mId+"</td>"+"<td>"
					+m.mName+"</td>"+"<td>"
					+m.mConsume+"</td>"+"<td>"
					+m.lb.className+"</td>"
					+"</tr>"; 
				}
				$("#mblist").html(str);
			}
		});
	}
</script>
</head>
<body>
	
 	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>会员管理</li>
    <li>会员查询</li>
    </ul>
    </div>
    
    <div class="formbody">
	    <div id="usual1" class="usual"> 
		    <ul class="seachform1">
		     <li>
		    	<div class="vocation">
			    <select class="select1" id="select1">
			    <option value="forTel">按手机号</option>
			    <option value="forName">按姓名</option>
			    </select>
			    </div>
		    </li>
		    <li><input type="text" class="scinput1" id="condition"/></li>
		    </ul>
		    <ul class="seachform1">
		    <li class="sarchbtn"><button type="button" class="scbtn" onclick="menmbersSearch()">查询</button></li>  
		    </ul>
		    <div class="formtitle"><span>会员列表</span></div>
		    
		    <table class="tablelist">
		    	<thead>
		    	<tr>
		        <th>手机号<i class="sort"><img src="admin/img/px.gif" /></i></th>
		        <th>姓名</th>
		        <th>历史消费</th>
		        <th>会员等级</th>
		        </tr>
		        </thead>
		        <tbody id="mblist">
		        <c:forEach  items="${page.list}" var="menmber" varStatus="st">
					<tr>
					<td>${menmber.mId}</td>
					<td>${menmber.mName}</td>  
					<td>${menmber.mConsume}</td>  
					<td>${menmber.lb.className}</td>  
				    </tr>
				</c:forEach>
				<tr>
					<td colspan='4'>
					<c:if test="${!page.isFirstPage }">
						<button type='button' onclick='searchAllMenmbersAjax(1)'>首页</button>&nbsp;
					</c:if>
					<c:if test="${page.hasPreviousPage }">
						<button type='button' onclick="searchAllMenmbersAjax('${page.prePage }')">上一页</button>&nbsp;
					</c:if>
					共：${page.pages }&nbsp;页&nbsp;
					<c:if test="${page.hasNextPage }">
						<button type='button' onclick="searchAllMenmbersAjax('${page.nextPage }')">下一页</button>&nbsp;
					</c:if>
					<c:if test="${!page.isLastPage }">
						<button type='button' onclick="searchAllMenmbersAjax('${page.pages}')">末页</button>
					</c:if>
					</td>
				</tr>
		        </tbody>
		    </table>
		</div> 
    </div>
</body>

</html>