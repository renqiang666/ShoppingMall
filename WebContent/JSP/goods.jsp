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
<title>goods</title>
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
        #choice{
            width:50%;
            height:50%;
            float: right;
            padding-top: 50px;
        }
        .choice{
            width:100px;
            height:10px;
            float: left;
            margin-left: 10px;
            font-family:微软雅黑;
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
            text-align:center;
        }
        a:visited,a:link{
            color: darkgray;
        }
        a:hover,a:active{
            color: red;
        }
        .goodsimg{
            height:170px;
            border:1px solid red;
        }
        .goodsinfo{
            text-align:center;
            height:10px;
            border:1px solid red;
            font-size:15px;
        }
        #nextpage{
            width:280px;
            height:5%;
            float:left;
            margin-left:37%;
        }
        .page{
            width:15px;
            height:100%;
            float:left;
            font-family:微软雅黑;
            text-align:center;
        }
        td{
            width: 300px;
            border:1px solid lightgray;
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
    <div id="choice">
    <div class="choice">
        <a style="font-family: 微软雅黑;" href="JSP/goods.jsp" >返回商城首页</a>
    </div>
      <div class="choice" style="width:50px;">
        <a style="font-family: 微软雅黑;" href="JSP/login.jsp" >登录</a>
    </div>
    <div class="choice" style="width:50px;">
        <a style="font-family: 微软雅黑;" href="JSP/register.jsp" >注册</a>
    </div>
    <div class="choice">
        <a style="font-family: 微软雅黑;" href="JSP/changepass.jsp" >密码修改</a>
    </div>
    <div class="choice">
        <a style="font-family: 微软雅黑;" href="JSP/goodsCar.jsp" >查看购物车</a>
    </div>
     <div class="choice">
        <a style="font-family: 微软雅黑;" href="JSP/personInfo.jsp" >个人信息</a>
    </div>
    </div>
</div>
<div id="body">
    <div id="loginimg">
        <table align="center" cellspacing="0">
            <tr class="goodsimg">
                <td><a id="a1"><img id="img1" style="width:200px;height:180px;"/></a></td>
                <td><a id="a2"><img id="img2" style="width:200px;height:180px;"/></a></td>
                <td><a id="a3"><img id="img3" style="width:200px;height:180px;"/></a></td>
            </tr>
            <tr class="goodsinfo">
                <td id="n1"></td>
                <td id="n2"></td>
                <td id="n3"></td>
            </tr>
            <tr class="goodsinfo">
                <td id="p1"></td>
                <td id="p2"></td>
                <td id="p3"></td>
            </tr>
            <tr class="goodsinfo">
                <td id="i1"></td>
                <td id="i2"></td>
                <td id="i3"></td>
            </tr>
            <tr class="goodsimg">
                <td><a id="a4"><img id="img4" style="width:200px;height:180px;"/></a></td>
                <td><a id="a5"><img id="img5" style="width:200px;height:180px;"/></a></td>
                <td><a id="a6"><img id="img6" style="width:200px;height:180px;"/></a></td>
            </tr>
            <tr class="goodsinfo">
                <td id="n4"></td>
                <td id="n5"></td>
                <td id="n6"></td>
            </tr>
            <tr class="goodsinfo">
                <td id="p4"></td>
                <td id="p5"></td>
                <td id="p6"></td>
            </tr>
            <tr class="goodsinfo">
                <td id="i4"></td>
                <td id="i5"></td>
                <td id="i6"></td>
            </tr>
        </table>
        <div id="nextpage">
            <div style="float:left;margin-right:5px;">
            <input type="button" value="首页" onclick="showFirstPage()"/>
            </div>
            <div style="float:left;margin-right:5px;margin-leftt:5px;">
            <input type="button" value="上一页" onclick="lastPage()" style="background-color: deepskyblue;margin: 0 auto;float: left;">
            </div>
            <div class="page" id="currentPage"></div>
            <div class="page">/</div>
            <div class="page" id="totalPage" style="margin-right:5px;"></div>
            <div style="float:left;margin-right:5px;margin-leftt:5px;">
            <input type="button" value="下一页" onclick="nextPage()" style="background-color: deepskyblue;margin: 0 auto;float: left;">
            </div>
            <div style="float:left;">
            <input type="button" value="末页" onclick="showLastPage()"/>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="JS/Public/goods.js"></script>
</html>