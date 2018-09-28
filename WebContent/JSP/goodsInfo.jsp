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
            width:100%;
            height:700px;
            clear:both;
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
        .goodsimg{
            height:170px;
            border:1px solid lightgray;
        }
        .goodsinfo{
            text-align:center;
            height:20px;
            border:1px solid lightgray;
        }
        #nextpage{
            width:280px;
            height:5%;
            border:1px solid lightgray;
            float:left;
            margin-left:37%;
        }
        #buyButton{
            width:100px;
            height:50px;
            float:left;
            position:absolute;
            left:50%;
        }
        #mes{
            width:200px;
            height:40px;
            position:absolute;
            left:45%;
            top:60%;
            color: red;
            text-align:center;
        }
        .page{
            width:15px;
            height:100%;
            border:1px solid blue;
            float:left;
            font-family:微软雅黑;
            text-align:center;
        }
        td{
            width: 300px;
            border:1px solid lightgray;
            align:center;
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
    <div style="float:left;padding-top:10px;font-size:28px;height:44px;font-family: 微软雅黑;position: absolute;left:40%;">
        欢迎来到怡安优选饰品商城
    </div>
    <div id="reback_to_mall">
        <a style="font-family: 微软雅黑;" href="JSP/goods.jsp" >返回商城</a>
    </div>
</div>
<div id="body">
    <div id="loginimg">
        <table align="center" cellspacing="0">
            <tr class="goodsimg">
                <td rowspan='5' style="text-align:center;"><img src="${param.goodsimg}" style="width:300px;height:300px;"/></td>
                <td align="center">简介</td>
                <td align="center">${param.briefintroduction}</td>
            </tr>
            <tr class="goodsinfo">
                <td>货号</td>
                <td id="goodsid">${param.goodsid}</td>
            </tr>
            <tr class="goodsinfo">
                <td>名字</td>
                <td id="goodsname">${param.goodsname}</td>
            </tr>
            <tr class="goodsinfo">
                <td>品牌</td>
                <td id="goodsbrand">${param.brand}</td>
            </tr>
            <tr class="goodsinfo">
                <td>库存</td>
                <td id="goodsbalance">${param.balance}</td>
            </tr>
        </table>
         <div id="buyButton">
            <input type="button" value="添加购物车" onclick="addInCar()" style="width:100px;height:25px;color:red;font-family:微软雅黑;font-weight: bolder;"/>
         </div>
         <div id="mes">
            
         </div>
    </div> 
</div>
</body>
<script type="text/javascript" src="JS/Public/addInCar.js"></script>
</html>