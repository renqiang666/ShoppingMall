<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2018/8/13
  Time: 上午11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="admin/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="admin/js/public/aes.js"></script>
    <script type="text/javascript" src="admin/js/public/pad-zeropadding.js"></script>
    <script type="text/javascript" src="admin/js/public/jquery.js"></script>


</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">表单</a></li>
    </ul>
</div>


<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>

    <ul class="forminfo">
        <li><label>订单号</label><input type="text" id="cid" class="dfinput" disabled="disabled" value="${maps.checkInBean.id}"/><i>注意，除了房费不可编辑其他</i>
        </li>
        <li><label>房间号</label><input id="croom" type="text" class="dfinput" disabled="disabled"
                                     value="${maps.checkInBean.room.id}"/><i></i></li>
        <li><label>入住时间</label><input id="arrDay" type="text" class="dfinput" disabled="disabled" value=""/><i></i></li>
        <li><label>预计离开时间</label><input id="leaveDay" type="text" class="dfinput" disabled="disabled" value=""/><i></i>
        </li>
        <li><label>预计入住天数</label><input type="text" class="dfinput" disabled="disabled"
                                        value="${maps.checkInBean.stayDays}"/><i></i></li>
        <li><label>已付押金</label><input type="text" class="dfinput" disabled="disabled"
                                      value="${maps.checkInBean.pledgeMoney}"/><i></i></li>
        <li><label>已付房费</label><input type="text" class="dfinput" disabled="disabled"
                                      value="${maps.checkInBean.paidMoney}"/><i></i></li>
        <li><label>房间价格</label><input type="text" class="dfinput" disabled="disabled"
                                      value="${maps.checkInBean.room.roomType.price}"/><i>今日折扣：
            <c:choose>
                <c:when test="${maps.hotel==null}">今日无优惠
                </c:when>
                <c:otherwise>${maps.hotel.value}</c:otherwise>
            </c:choose></i></li>
        <li><label>会员手机号</label><input id="phoneNum" type="text" class="dfinput" value="" onblur="VipCount()"/><i
                id="phoneTest">如果没有，可不填</i></li>
        <li><label>当前离开时间</label><input id="timeNow" type="text" class="dfinput" disabled="disabled" value=""/><i></i>
        </li>
        <li><label>实际入住天数</label><input id="daynow" type="text" class="dfinput" disabled="disabled"
                                        value="${maps.overTime}"/><i></i></li>
        <li><label>预计应收房费</label><input id="money" type="text" class="dfinput" disabled="disabled"
                                        value="${maps.money}"/><i></i></li>
        <li><label>应付房费</label><input id="paidMoney" type="text" class="dfinput"  onblur="judegNum()"/><i>人民币</i><i id="judegMoney"></i></li>
        <li><label>是否退房</label><input type="text" class="dfinput" value=""/><i></i></li>

           <li><label>&nbsp;</label><input id="exitButton" type="button" class="btn" value="确认退房" onclick="rec()"/></li>


        <li><label>&nbsp;</label><input type="button" class="btn" value="返回主页"/></li>

    </ul>


</div>


</body>
<script type="text/javascript" src="admin/js/private/CheckDetail.js"></script>
<script>
    function rec() {
        if($("#paidMoney").val().length==0){
            $("#judegMoney").css("color","red");
            $("#judegMoney").html("请输入金额");}

        else {
                var mymessage=confirm("确定要退房吗？");
                if(mymessage==true)
                {
                    ExitRoom();
                }
                else if(mymessage==false)
                {
                }

        }
    }

    function ExitRoom() {
        var cid=$("#cid").val();
        var croom=$("#croom").val();
        var arrDay=$("#arrDay").val();
        var phoneNum=$("#phoneNum").val();
        var timeNow=$("#timeNow").val();
        var daynow=$("#daynow").val();
        var paidMoney=$("#paidMoney").val();
        console.log(paidMoney);
        var paidMoneys=encr(paidMoney);
        var jsonObj = {"seConId":cid,"sePaidMoney":paidMoneys,"seArrDay":arrDay,"sePhone":phoneNum,
            "seTimeNow":timeNow,"seDayNow":daynow,"seCRoom":croom};
        $.ajax({
            url:"CheckCounsume.action",
            type:"post",
            anync:true,
            dataType:"json",
            contentType:"application/json;charset=utf-8",
            data:JSON.stringify(jsonObj),
            success:function () {
                alert("退房成功");
                window.location.href="findAllByPage.action"
            }
        })

    }
    function getNowFormatDate() {
        var date = new Date();
        var seperator1 = "-";
        var seperator2 = ":";
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
        document.getElementById("timeNow").value = currentdate;
        return currentdate;


    }

    getNowFormatDate();

    function nowday() {
        var arrDay = $("#arrDay").val();
        var nowDay = getNowFormatDate();
    }

    nowday();

    function GMTToStr(time) {
        var dateStr = time.trim().split(" ");
        var strGMT = dateStr[0] + " " + dateStr[1] + " " + dateStr[2] + " " + dateStr[5] + " " + dateStr[3] + " GMT+0800";
        var date = new Date(Date.parse(strGMT));
        var year = date.getFullYear();  //获取年
        var month = date.getMonth() + 1;    //获取月
        var day = date.getDate(); //获取日
        var hours = date.getHours();
        var minutes = date.getMinutes();
        var sec = date.getSeconds();
        var postDate = year + '-' + month + '-' + day + ' ' + hours + ':' + minutes + ':' + sec;
        return postDate;
    }

    function date(arrtime, leavetime) {
        var arrTime = GMTToStr(arrtime);
        var leaveTime = GMTToStr(leavetime);
        console.log(arrTime);
        $("#arrDay").val(arrTime);
        $("#leaveDay").val(leaveTime);
    }

    date("${maps.checkInBean.arriveTime}", "${maps.checkInBean.leaveTime}");
    function encr(data) {

        var key = CryptoJS.enc.Latin1.parse('class33iamironma');
        var iv = CryptoJS.enc.Latin1.parse('iamironmaclass33');

        //加密
        var encrypted = CryptoJS.AES.encrypt(data, key, {
            iv: iv,
            mode: CryptoJS.mode.CBC,
            padding: CryptoJS.pad.ZeroPadding
        });
        //解密

        return encrypted.toString();
    }
    function decr(data) {
        var key = CryptoJS.enc.Latin1.parse('class33iamironma');
        var iv = CryptoJS.enc.Latin1.parse('iamironmaclass33');
        var decrypted = CryptoJS.AES.decrypt(data, key, {iv: iv, padding: CryptoJS.pad.ZeroPadding});
        return decrypted.toString(CryptoJS.enc.Utf8);
    }


</script>
</html>
