<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show_reserve.jsp' starting page</title>
  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="admin/js/public/jquery-3.3.1.js"></script>
<link href="admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="admin/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="admin/js/public/jquery.js"></script>
<script type="text/javascript" src="admin/js/public/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="admin/js/public/select-ui.min.js"></script>
<script type="text/javascript" src="admin/js/public/kindeditor.js"></script>

  
<script type="text/javascript">
$(document).ready(function(e) {

	$(".select3").uedSelect({
		width : 152
	});
});
</script>
</head>

<body class="sarchbody">

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">预定管理</a></li>
    <li><a href="admin/show_reserve.jsp">预订查询</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    
    <ul class="seachform1">
    
    <li><label>预订姓名</label><input type="text" class="scinput1" id="reserveName" value=""/></li>
    <li><label>预订编号</label><input  type="text" class="scinput1" id="reserveId" value=""/></li>

    </ul>
    <ul class="seachform1">
    <li class="sarchbtn"><label>&nbsp;</label>
    <input type="button" class="scbtn" value="查询" onclick="findMsg()"/>  
    <a href="/HotelManagement/admin/show_reserve.jsp"><input type="button" class="scbtn" value="查询所有"/></a>
    </ul>

    <div class="formtitle"><span>预订列表</span></div>
    
    <table class="tablelist">
    <thead>
    	<tr>
        <th>编号<i class="sort"><img src="admin/img/px.gif" /></i></th>
        <th>预订人姓名</th>
        <th>联系方式</th>
        <th>预抵时间</th>
<!--         <th>取消时间</th> -->
        <th>入住时间</th>
        <th>退房时间</th>
        <th>入住人姓名</th>
        <th>房间类型</th>
        <th>付款金额</th>
        <th>订单状态</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody id="tbody">
		
        </tbody>
    </table>
     <div class="pagin">
     	<div class="message" id="message"></div>
        <ul class="paginList">
        <li class="paginItem" onclick="prePage()"><span class="pagepre"></span></li>
        <li class="paginItem" onclick="nextPage()"><span class="pagenxt"></span></li>
        </ul>
     </div>
	</div> 

    </div>


</body>
<script type="text/javascript" src="admin/js/private/show_reserve.js"></script>
</html>
