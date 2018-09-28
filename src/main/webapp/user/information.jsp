<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
    <title>My JSP 'head.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="textml; charset=ISO-8859-1">
	<meta charset="utf-8">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="shortcut icon" type="text/css" href="assets/images/favicon/favicon.png">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link rel="stylesheet" type="text/css" href="assets/css/responsive.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
        .tit{
            margin-top:75px;
            margin-left:30px;
            height: 30px;
            font-size: 20px;
            font-family: 微软雅黑;
        }
        #inforr{
            margin: 30px auto;
            width: 400px;
            height: 160px;
            border: 1px solid #e0ffcc;
            border-radius: 10px;
            background-color: #e0ffcc ;
        }
        .inforr{
            float: left;
        }
        #leftt{
            width: 98px;
            height: 148px;
            border:0;
        }
        .key{
            width: 96px;
            height: 48px;
            text-align: center;
            line-height: 48px;
            border: 0;
            font-size: 16px;
        }
        #center{
            width: 198px;
            height: 148px;
            border:0;
        }
        .value{
            width: 196px;
            height: 48px;
            text-align: center;
            line-height: 55px;
            border:0;
            font-size: 16px;
        }
        .value input{
            margin-top:10px;
            width: 190px;
            height: 25px;
        }
        #rightt{
            width: 98px;
            height: 148px;
            border:0;
        }
        .change{
            margin-left:20px;
            width: 96px;
            height: 48px;
            line-height: 48px;
            cursor: pointer;
            font-size: 16px;
        }
        #pass{
            margin:auto;
            width: 400px;
            height: 140px;
            border: 1px solid #e0ffcc;
            border-radius: 10px;
            background-color: #e0ffcc ;
        }
        #sure{
            margin-top: 15px;
            margin-left: 15px;
            width: 60px;
            height: 60px;
            font-size: 20px;
            line-height: 60px;
            border-radius: 5px;

            cursor: pointer;
        }
        #centerline{
            width: 95%;
            margin-left:30px;
            height: 30px;
            font-size: 20px;
            font-family: 微软雅黑;
            border-top: 1px solid  #e0ffcc;
        }
        #cemail{
            margin-top: 100px;
        }

    </style>
  </head>
<body>
<%@ include file="head.jsp" %>
<!-- main wrapper -->
<div class="wrapper" style="height: 460px;">
	    <!-- header -->
	 
	<div class="tit">Your infornation</div>
	
	<div id="inforr">
	    <div id="leftt" class="inforr">
	        <div class="key">name:</div>
	        <div class="key">iden:</div>
	        <div class="key">eamil:</div>
	
	    </div>
	    <div id="center" class="inforr">
	        <div class="value"><input type="text" id="nicname"></div>
	        <div class="value"><input type="text" id="location"></div>
	        <div class="value"><input type="text" id="email"></div>
	    </div>
	    <div id="rightt" class="inforr">
	
	        <div onclick="changeInfor()" id="cemail" class="change">update</div>
	    </div>
	</div>
	<div class="tit"><a href="jsp/findPass.jsp">update pass</a></div>
</div>


<!-- Scripts -->
<script type="text/javascript" src="assets/js/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/tether.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="assets/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="assets/js/moment.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.smartmenus.js"></script>
<script type="text/javascript" src="assets/js/jquery.parallax.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.shuffle.min.js"></script>
<script type="text/javascript" src="assets/js/owl.carousel.min.js"></script>
<script type="text/javascript" src="assets/js/main.js"></script>
<script type="text/javascript" src="assets/js/private/information.js"></script>
<script type="text/javascript" src="assets/js/private/aes.js"></script>
<script type="text/javascript" src="assets/js/private/pad-zeropadding.js"></script>
<script type="text/javascript" src="assets/js/private/secret.js"></script>
<!-- /Scripts -->
</body>
</html>

