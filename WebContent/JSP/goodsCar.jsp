<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>goodsCar</title>
<style type="text/css">
        #head_part{
            width: 100%;
            height: 30%;
            background-color: white;
            float:left;
            border-bottom: darkgray 1px solid;
        }
        #logo_container{
            width:30%;
            height:100%;
            float: left;
            margin-left: 10%;
        }
        #reback_to_mall{
            width:30%;
            height:100%;
            float: right;
            padding-top: 60px;
        }
        #body{
            width:1010px;
            height:500px;
            clear:both;
            margin:0 auto;
        }
        #button{
            width:100px;
            height:25px;
            color:red;
            font-family:微软雅黑;
            position:relative;
            right:150px;"
        }
        #loginimg{
            width:74%;
            height:90%;
            float:left;
            position:absolute;
            left:13%;
        }
        .goodsimg td{
            width:33%;
        }
        a:visited,a:link{
            color: darkgray;
        }
        a:hover,a:active{
            color: red;
        }
        .realGoods{
             text-align:center;
             line-height:100px;
        }
        .realGoods img{
              width:100px;
              height:100px;
        }
        #buyButton{
            width:100px;
            height:20px;
            clear:both;
            float:left;
            margin:0 auto;
        }
        #body div{
             width:200px;
             height:100px;
             float:left;
             border:1px solid lightgray;
             text-algin:center;
        }
            #mes{
            width:200px;
            height:50px;
            clear:both;
            text-align:center;
            position:absolute;
            left:43%;
            bottom:100px;
        }
        table{
        table-layout:fixed;
        }
        td img{
            width: 100px;
            height:100px;
        }
    </style>
</head>
<script type="text/javascript" src="JS/Private/jquery.1.9.1.js"></script>
<body>
<div id="head_part">
    <div id="logo_container">
        <img src="Image/Log.png"/>
    </div>
    <div style="float:left;padding-top:10px;font-size:28px;height:44px;font-family: 微软雅黑;position: absolute;left:45%;">
        我的购物车
    </div>
    <div id="reback_to_mall">
        <a style="font-family: 微软雅黑;" href="JSP/goods.jsp" >返回商城</a>
    </div>
</div>
<div id="body">
</div>
</body>
<script type="text/javascript" src="JS/Public/showCar.js"></script>
</html>