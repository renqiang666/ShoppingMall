<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
    <meta http-equiv="Content-Type" content="textml; charset=utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="shortcut icon" type="text/css" href="/HotelManagement/user/assets/images/favicon/favicon.png">
    <link rel="stylesheet" type="text/css" href="/HotelManagement/user/assets/css/style.css">
    <link rel="stylesheet" type="text/css" href="/HotelManagement/user/assets/css/responsive.css">
    <style type="text/css">
		a{
			text-decoration: none;
		}
		#login{
			width:22%;
            height:45%;
            min-width:304px;
            min-height:350px;
            position: fixed;
            Z-index:1;
            top: -60%;
            right: 40%;
            border: 1px solid black;
            animation:addLogin 0.5s infinite alternate;
            animation-play-state: paused;
			z-index: 100000;
			background-color: white;
        }

        #loginHead{
            width: 99.5%;
            height: 18%;
            min-width:300px;
            min-height:60px;
            margin-left: 3px;
        }
        .loginHead{
            width: 49.5%;
            height: 90%;
            min-width:150px;
            min-height:50px;
            float: left;
            line-height: 50px;
            font-size: 20px;
            font-family: Tahoma;
            text-align: center;
        }

        #lright{
            background-color:#FAFAFA;
        }
        .para{
            width: 99%;
            min-width:296px;
            height: 18%;
            min-height: 60px;
        }
        .para div{
            float: left;
            line-height: 60px;
        }
        .paraLeft{
            width: 35%;
            min-width:105px;
            text-align: center;
        }
        .paraRight{
            width: 63%;
            min-width:189px;
            text-align: center;
          
        }
        .paraRight input{
            height:25px;
            margin-top: 18px;
            font-size:16px;
            width:180px;
        }
        #getCode{
        	margin-top:17px;
            margin-left: 20px;
            width: 80px;
            height: 32px;
            background-color: #dde7ff;
            font-size: 16px;
            border: none;
            border-radius: 2px;
            cursor: pointer;
        }

        #vercodepicture{
            width: 70px;
            height: 40px;
            border: 1px solid black;
         	float:left;
            margin-top: 10px;

        }
        #loginBottom{
            width: 100%;
            height: 100px;
        }
        #loginBottom div{
            text-align: center;
            height: 60px;
            line-height: 60px;
        }
        #loginBottom2{
            width: 100%;
            height: 100px;
        }
        #loginBottom2 div{
            margin-top: 20px;
            text-align: center;
            height: 50px;
            line-height: 50px;
        }
        #loginin{    
        	margin-top:15px;
            line-height: 4px;
            width: 150px;
            height: 40px;
            background-color: #7dddff;
            border: none;
            border-radius: 5px;
            font-size: 20px;
            cursor: pointer;
            color: #222222;
        }
        #telin{
            line-height: 4px;
            width: 150px;
            height: 40px;
            background-color: #7dddff;
            border: none;
            border-radius: 5px;
            font-size: 20px;
            cursor: pointer;
            color: #222222;
        }
        #loginin:hover{
            color: #111111;
            font-size: 21px
        }
        #telin:hover{
            color: #111111;
            font-size: 21px
        }
        #loginBody1{
        	
        	width:99%;
        	min-width:300px;
        	height:50%;
        	min-height:180px;
            display: table;
        }
        #loginBody2{
        	width:99%;
        	min-width:300px;
        	height:33%;
        	min-height:120px;
            margin-top: 10px;
            display: none;
        }
        #loginBottom{
            display: table;
        }
        #loginBottom2{
            display: none;
        }
        #reduce{
            position: absolute;
            top:95%;
            right:2%;
            cursor: pointer;

        }
        @keyframes addLogin{
            100%{
                top: 65px;
            }
        }
	</style>
  </head>
  
<body>
<!-- main wrapper -->
<div class="wrapper">
    <!-- header -->
      <header class="header">/
        <div class="header-top">
            <div class="container">
                <div class="row">                     
                    <div class="col-lg-9 col-md-8 col-sm-8 col-xs-12" style="width: 600px;margin-left: 10px">
                        <div class="header-email"><i class="fa fa-envelope-o"></i> <a href="mailto:support@email.com">support@email.com</a></div>
                        <div class="header-phone"><i class="fa fa-phone"></i> <a href="#">8 (043) 567 - 89 - 30</a></div>
                    </div>

                    <%Object account=session.getAttribute("account");
					if(account==null){%>
					<div id="head-right">
              			<div class="header-social pull-right">
              	
	                		 <a onclick="onoff()" style="cursor: pointer;"><i class="fa fa-twitter"></i>Login</a>
	                		
	               			<a href="/HotelManagement/user/register.jsp">Register</a>
	               			<a href="/HotelManagement/user/findPass.jsp">Forget Pass</a>
              			</div>
           			 </div>		
					 <%}else{%>
                    <div id="head-right">
                        <div class="head-right">hello:<%=(String)account%></div>
                        <div class="head-right"><a href="information.jsp">information</a></div>
                        <div class="head-right"><a href="/HotelManagement/ReserveInfo.action?page=1">my order</a></div>
                        <div class="head-right"><a href="/HotelManagement/logout.action">log out</a></div>
                    </div>
                    <%} %>
                </div>
            </div>
        </div>
        </header>
        </div>
         <div id="login" >
        <div id="loginHead">
            <div class="loginHead" onclick="toaccountLogin()" style="cursor: pointer"  id="lleft">Account</div>
            <div class="loginHead" onclick="totelLogin()" style="cursor: pointer"  id="lright">Tel</div>
        </div>
        <div id="loginBody1">
            <div class="para">
                <div class="paraLeft">account:</div>
                <div class="paraRight"><input  type="text" id="account" onkeyup="checka()" placeholder="telephone number"></div>
            </div>
            <div  class="para">
                <div class="paraLeft">password:</div>
                <div class="paraRight"><input  id="password" type="password"></div>
            </div>
            <div  class="para" >
                <div class="paraLeft" >code:</div>
                <div class="paraRight" >
                    <div ><img id="vercodepicture" onclick="getCode()"/></div>
                    <div ><input onkeyup="this.value=this.value.toUpperCase()" style="width: 80px;height: 36px;margin-left:10px;margin-top: 11px;font-size: 16px"  placeholder="write code" id="vercode"></div>
                </div>
            </div>
        </div>
        <div id="loginBody2">
            <div class="para">
                <div class="paraLeft">tel:</div>
                <div class="paraRight"><input  id="tel" onkeyup="checkt()" placeholder="telephone number" type="text"></div>
            </div>
            <div  class="para">
                <div class="paraLeft"><button id="getCode" onclick="getLoginCode()">get code</button></div>
                <div class="paraRight">
                    <input type="text" style="width: 151px;height: 32px;margin-left: 29px;font-size: 16px"  id="rpic" placeholder="write code">
                </div>
            </div>
        </div>
        <div id="loginBottom">
            <div ><button id="loginin" onclick="accountLogin()">log &nbsp; in</button></div>
            <div id="hint1"></div>
        </div>
        <div id="loginBottom2">
            <div ><button id="telin" onclick="telLogin()">log &nbsp; in</button></div>
            <div id="hint2"></div>
        </div>
        <div id="reduce" onclick="reduce()">▲</div>
    </div>
<!-- /footer -->
<script type="text/javascript" src="/HotelManagement/user/assets/js/private/login1.js"></script>
<script type="text/javascript" src="/HotelManagement/user/assets/js/private/aes.js"></script>
<script type="text/javascript" src="/HotelManagement/user/assets/js/private/pad-zeropadding.js"></script>
<script type="text/javascript" src="/HotelManagement/user/assets/js/private/secret.js"></script>
<script type="text/javascript" src="/HotelManagement/user/assets/js/jQuery-2.2.2.js"></script>
</body>
</html>

