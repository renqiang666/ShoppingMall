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
<title>register</title>
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
            height:550px;
            clear:both;
        }
        #loginimg{
            width:74%;
            height:90%;
            float:left;
            position:absolute;
            left:13%;
        }
        #loginform{
            width:300px;
            height:350px;
            position: relative;
            left:800px;
            top:80px;
            background:rgba(255,255,255,0.8);
            border-radius: 20px;
            padding-top: 5px;
        }
        .login{
            width:90%;
            height:10%;
            margin: 15px auto;
        }
        .formbox{
            height:80%;
            float:left;
            margin-left: 5px;
            margin-top: 1px;
        }
        .userinfo{
            float:left;
            line-height:40px;
            width:70px;
            text-align: right;
            font-family: 微软雅黑;
            color: darkgray;
        }
        #refreashdiv{
            float:left;
            line-height:40px;
            width:100px;
            text-align: right;
            font-family: 微软雅黑;
            color: darkgray;
        }
        #button{
             background-color: deepskyblue;
             width: 100%;
             height: 100%;
             color: white;
             font-family: 微软雅黑;
        }
        #mes{
            width:50%;
            color: red;
            text-align:center;
        }
        a:visited,a:link{
            color: darkgray;
        }
        a:hover,a:active{
            color: red;
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
        欢迎注册怡安优选饰品商城
    </div>
    <div id="reback_to_mall">
        <a style="font-family: 微软雅黑;" href="JSP/goods.jsp">返回商城</a>
    </div>
</div>
<div id="body">
    <div id="loginimg">
        <image src="Image/login.jpg"></image>
    </div>
    <div id="loginform">
        <div class="login">
            <div class="userinfo">注册账号</span></div><input id="account" type="text" name="user" class="formbox" style="width:180px;">
        </div>
        <div class="login">
            <div class="userinfo">注册密码</span></div><input id="userpass" type="password" name="pass" class="formbox" style="width:180px;">
        </div>
        <div class="login">
            <div class="userinfo">确认密码</span></div><input id="repass" type="password" name="repass" class="formbox" style="width:180px;">
        </div>
        <div class="login">
            <div class="userinfo">验证码</div>
            <input id="identitycode" type="password" name="identyid" class="formbox" style="width:80px;">
            <div id="refreashdiv">
            <img id="refreashimg" style="width:80px;height:35px;float:left;" onclick="getCode()"/>
            </div>
        </div>
        <div class="login" style="width:50%;color: lavender;margin-top:10px;" >
            <input type="button" value="注册" id="button" onclick="register()">
        </div>
        <div class="login" id="mes"></div>
    </div>
</div>
</body>
<script type="text/javascript" src="JS/Public/register.js"></script>
<script type="text/javascript" src="JS/Public/codeImg.js"></script>
</html>