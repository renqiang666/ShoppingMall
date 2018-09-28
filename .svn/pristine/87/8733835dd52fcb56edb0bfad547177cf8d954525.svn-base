<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>入住详情</title>
<link href="admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="admin/css/right.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript" src="admin/js/public/jquery-3.3.1.js"></script>
<script type="text/javascript" src="admin/js/public/aes.js"></script>
<script type="text/javascript" src="admin/js/public/pad-zeropadding.js"></script>
<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="/HotelManagement/findAllByPage.action"
				target="rightFrame">开房</a></li>
		</ul>
	</div>
	<div class="rightinfo">

		<div class="tools">

			<ul class="toolbar">
				<li id="ss"><span><img src="admin/img/t01.png" /></span>添加入住</li>
				<li id="as"><span><img src="admin/img/t01.png" /></span>入住登记</li>
				<li id="es"><span><img src="admin/img/t02.png" /></span>延期</li>
				<li><input id="searchByRid" placeholder="请输入房间号" /><span><img
						width="24px" src="admin/img/search.png" onclick="findByRid()" /></li>
				<li><input id="hiddenRoomId" class="roomId" type="hidden" /><span><img
						src="admin/img/t03.png" /></span> <inptut type="button"
						onclick="delGuests()">删除入住人</inptut></li>
				<li onclick="searchRoom(1)"><span><img
						src="admin/img/lc00.png" width="24px" /></span><select id="roomType">
						<option value="5">全部房间</option>
						<option value="1">单人间</option>
						<option value="2">双人间</option>
						<option value="3">大床房</option>
						<option value="4">总统套房</option>
				</select></li>
			</ul>
		</div>
		<table class="tablelist">
			<thead>
				<tr>
					<th></th>
					<th>房间号</th>
					<th>入住单号</th>
					<th>入住人</th>
					<th>房间类型</th>
					<th>入住时间</th>
					<th>离开时间</th>
					<th>入住天数</th>
					<th>押金</th>
					<th>已付金额</th>
					<th>操作</th>
				</tr>
			</thead>

			<tbody id="content-td">
				<c:forEach begin="0" step="1" items="${CheckInList}" var="list">
					<tr>
						<td><input class="box" type="radio" name="single"
							onclick="transfer(${list.room.id})" /></td>
						<td>${list.room.id}</td>
						<td>${list.id}</td>
						<td><span> <c:forEach begin="0" step="1"
									items="${GuestList}" var="guest">
									<c:if test="${guest.room.id==list.room.id}">
										<c:out value="${guest.name}" />
									</c:if>
								</c:forEach></span></td>
						<td>${list.room.roomType.name}</td>
						<td><fmt:formatDate value="${list.arriveTime}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><fmt:formatDate value="${list.leaveTime}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${list.stayDays}</td>
						<td>${list.pledgeMoney}</td>
						<td>${list.paidMoney}</td>
						<td><a href="CheckDetail.action?cid=${list.id}">退房</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="pagin">
			<div class="message">共${page.total}条记录，当前显示第${page.pageNum}页</div>
			<ul class="paginList">
				<li class="paginItem"><a href="javascript:;"><span
						onclick="prePage()" class="pagepre"></span></a></li>
				<li class="paginItem" id="currentPage"><a href="javascript:;">1</a></li>
				<li class="paginItem"><a href="javascript:;"><span
						onclick="nextPage()" class="pagenxt"></span></a></li>
			</ul>
		</div>
		<form id="ssc" action="/HotelManagement/addCheckIn.action"
			method="post" style="none">
			<div style="font-size:25">添加入住</div>
			<br> <br>
			<div>
				<label>房号：</label><input type="text" id="newRoomId" name="room.id" />
			</div>
			<br>
			<div>
				<label>天数：</label><input type="text" id="stayOne" name="stayDays"
					onblur="colPrice()" />
			</div>
			<br>
			<div>
				<label>押金：</label><input type="text" name="pledgeMoney" 
					readonly="readonly" value="100" />
			</div>
			<br>

			<div>
				<label>付款：</label><input type="text" name="paidMoney" id="paidOne" maxlength="6"/>
			</div>
			<br>
			<div>
				<button type="submit">提交</button>
				&nbsp&nbsp&nbsp&nbsp <input type="button" style="width:50px" id="sc"
					value="取消" />
			</div>
		</form>
		<form id="ass" action="/HotelManagement/addGuest.action" method="post"
			style="none">
			<div style="font-size:25">入住登记</div>
			<br> <br>
			<div>
				<label>房号：</label><input class="roomId" type="text" name="room.id"
					readonly="readonly" />
			</div>
			<br>
			<div>
				<label>证件：</label><input type="text" name="id" maxlength="18"/>
			</div>
			<br>
			<div>
				<label>姓名：</label><input type="text" name="name" maxlength="20"/>
			</div>
			<br>
			<div>
				<label>性别：</label><select name="sex" id="sexs">
					<option>男</option>
					<option>女</option>
				</select>
			</div>
			<br>
			<div>
				<label>电话：</label><input type="text" name="tele" id="phone"
					onblur="check(this.id,'bt1')" maxlength="11" />
			</div>
			<br>
			<div>
				<button type="submit" id="bt1">提交</button>
				&nbsp&nbsp&nbsp&nbsp <input type="button" style="width:50px" id="aa"
					value="取消" />
			</div>
		</form>
		<form id="ess" action="/HotelManagement/extendCheckIn.action"
			method="post" style="none">
			<div style="font-size:25">房间延期</div>
			<br> <br>
			<div>
				<label>房号：</label><input class="roomId" type="text" name="room.id"
					readonly="readonly" />
			</div>
			<br>
			<div>
				<label>延期：</label><input type="text" id="stayTwo" name="stayDays"
					onblur="colExtendPrice()" maxlength="2"/>
			</div>
			<br>
			<div>
				<label>付款：</label><input type="text" name="paidMoney" id="paidTwo" maxlength="6"/>
			</div>
			<br>
			<div>
				<button type="submit">提交</button>
				&nbsp&nbsp&nbsp&nbsp <input type="button" style="width:50px" id="ee"
					value="取消" />
			</div>
		</form>
	</div>
	<div id="roomlist"></div>

	<script type="text/javascript" src="admin/js/private/show_check.js"></script>
	<script type="text/javascript">
		function nextPage() {
			if (${page.pageNum} == ${page.lastPage}) {
				window.location.href = "findAllByPage.action?page=1";
			} else {
				window.location.href = "findAllByPage.action?page="
						+ ${page.nextPage};
			}
		}
		function prePage() {
			if (${page.pageNum} == ${page.firstPage}) {
				window.location.href = "findAllByPage.action?page=1";
			} else {
				window.location.href = "findAllByPage.action?page="
						+ ${page.prePage};
			}
		}
		function delGuests() {
			var roomId = document.getElementById('hiddenRoomId').value;
			window.location.href = "delGuest.action?rid=" + roomId;
		}
		function colPrice() {
			$.ajax({
				url : "colPrice.action",
				method : "post",
				async : true,
				data : {
					roomId : $("#newRoomId").val(),
					day : $("#stayOne").val()
				},
				success : function(data) {
					$("#paidOne").val(decr(data.price));
				}
			})
		}
		function colExtendPrice() {
			$.ajax({
				url : "colPrice.action",
				method : "post",
				async : true,
				data : {
					roomId : $(".roomId").val(),
					day : $("#stayTwo").val()
				},
				success : function(data) {
					$("#paidTwo").val(decr(data.price));
				}
			})
		}
		function encr(data) {
			var key = CryptoJS.enc.Latin1.parse('class33iamironma');
			var iv = CryptoJS.enc.Latin1.parse('iamironmaclass33');
			// 加密
			var encrypted = CryptoJS.AES.encrypt(data, key, {
				iv : iv,
				mode : CryptoJS.mode.CBC,
				padding : CryptoJS.pad.ZeroPadding
			});

			return encrypted.toString();
		}
		function decr(data) {
			// 解密
			var key = CryptoJS.enc.Latin1.parse('class33iamironma');
			var iv = CryptoJS.enc.Latin1.parse('iamironmaclass33');
			var decrypted = CryptoJS.AES.decrypt(data, key, {
				iv : iv,
				padding : CryptoJS.pad.ZeroPadding
			});
			return decrypted.toString(CryptoJS.enc.Utf8);
		}
		
	</script>
</body>

</html>
