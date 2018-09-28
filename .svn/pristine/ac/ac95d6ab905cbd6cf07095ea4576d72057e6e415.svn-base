<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, user-scalable=yes">
<head>
<script type="text/javascript" src="/HotelManagement/admin/js/public/jquery-3.3.1.js"></script>
<script type="text/javascript">
//备份至本地
function LocalDBcopy(){
	$.ajax({
		url:"/HotelManagement/LocalDBcopy.action",
		method:"post",
		async:true,
		success:function(data){
			$("#mes").html(data);
		}
	});
}
//备份至服务器
function ServerDBcopy(){
	$.ajax({
		url:"/HotelManagement/ServerDBcopy.action",
		method:"post",
		async:true,
		success:function(data){
			$("#mes1").html(data);
		}
	});
}

function browseFolder(path) { 
    try { 
        var Message = "\u8bf7\u9009\u62e9\u6587\u4ef6\u5939"; //选择框提示信息 
        var Shell = new ActiveXObject("Shell.Application"); 
        var Folder = Shell.BrowseForFolder(0, Message, 64, 17); //起始目录为：我的电脑 
        //var Folder = Shell.BrowseForFolder(0, Message, 0); //起始目录为：桌面 
        if (Folder != null) { 
            Folder = Folder.items(); // 返回 FolderItems 对象 
            Folder = Folder.item(); // 返回 Folderitem 对象 
            Folder = Folder.Path; // 返回路径 
            if (Folder.charAt(Folder.length - 1) != "\\") { 
                Folder = Folder + "\\"; 
            } 
            for(var i=0;i<Folder.length;i++){
            	if(Folder.charAt(i)==" "){
            		$("#mes2").html("路径不能有空格！");
            		return "";
            	}
            }
        	$.ajax({
        		url:"/HotelManagement/LocalDBcopy.action",
        		method:"post",
        		async:true,
        		data:"path="+Folder,
        		success:function(data){
        			$("#mes2").html(data);
        		}
        	});
            return Folder; 
        } 
    } 
    catch (e) { 
        alert(e.message); 
    } 
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" id=cal_style type="text/css"
	href="time/dist/flatpickr.min.css">
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>管理信息</li>
    <li>数据管理</li>
    <li>数据库备份</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
    <li style="float:left;"><label>&nbsp;</label><input name="" type="button" class="rqbtn" value="备份至服务器" onclick="ServerDBcopy()"/></li>
    <div id="mes1" style="width:900px;height:32px;line-height:32px;color:red;margin-left:50px;float:left;"></div>
    
    
     <li style="float:left;margin-top:100px;"><label>&nbsp;</label><input name="" type="button" class="rqbtn" value="选择本地备份路径" onclick="browseFolder('path')"/></li>
    <div id="mes2" style="width:900px;height:32px;line-height:32px;color:red;margin-left:50px;float:left;"></div>
    
    </ul>
	 
    </div>


</body>
</html>
