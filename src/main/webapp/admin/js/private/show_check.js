$(function() {
	$("#ss").click(function() {
		$("#ssc").fadeIn();
		$("#ass").fadeOut();
		$("#ess").fadeOut();
	})
})
$(function() {
	$("#sc").click(function() {
		$("#ssc").fadeOut();

	})

})
$(function() {
	$("#as").click(function() {
		$("#ass").fadeIn();
		$("#ssc").fadeOut();
		$("#ess").fadeOut();
	})

})
$(function() {
	$("#aa").click(function() {
		$("#ass").fadeOut();
	})

})
$(function() {
	$("#es").click(function() {
		$("#ess").fadeIn();
		$("#ass").fadeOut();
		$("#ssc").fadeOut();
	})

})
$(function() {
	$("#ee").click(function() {
		$("#ess").fadeOut();
	})

})

function transfer(roomId) {
	var res = $(".box").is(":checked");
	if (res) {
		$(".roomId").val(roomId);
	} else {
		$(".roomId").val("");
	}
}

function check(num, bt) {
	var phone = document.getElementById(num).value;
	if (phone == "") {
		document.getElementById(bt).disabled = true;
	} else if (!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(phone))) {
		document.getElementById(bt).disabled = true;
	} else {
		document.getElementById(bt).disabled = false;
	}
}
function findByRid() {
	var rid = document.getElementById('searchByRid').value;
	window.location.href = "/HotelManagement/findCheckInByRid.action?rid="
			+ rid;
}
function searchRoom(pageNum) {
	var roomTypeId = document.getElementById('roomType').value;
	$.ajax({
		url : "/HotelManagement/RoomDisplayAction_findRoomInfoByType.action",
		method : "post",
		async : true,
		data : "pageNum=" + pageNum + "&type=" + roomTypeId,
		success : function(data) {
			var rooms = data.list;
			var str = "";
			for (var i = 0; i < rooms.length; i++) {
				if (i % 12 == 0) {
					str += "<tr style='height:100px;'>";
				}
				if (rooms[i].roomState.id == 3) {
					str += "<td style='width:100px;'><div class='lived'>"
							+ rooms[i].id + "</div></td>";
				} else if (rooms[i].roomState.id == 2) {
					str += "<td style='width:100px;'><div class='cleaning'>"
							+ rooms[i].id + "</div></td>";
				} else {
					str += "<td style='width:100px;'><div class='empty'>"
							+ rooms[i].id + "</div></td>";
				}
				if ((i + 1) % 12 == 0 || (i + 1) == rooms.length) {
					str += "</tr>";
				}

			}
			str += "<tr><td colspan='12'>";
			if (!data.isFirstPage) {
				str += "<button type='button' onclick='searchRoom(1,"
						+ roomTypeId + ")'>首页</button>&nbsp;";
			}
			if (data.hasPreviousPage) {
				str += "<button type='button' onclick='searchRoom("
						+ data.prePage + "," + roomTypeId
						+ ")'>上一页</button>&nbsp;";
			}
			str += "共：" + data.pages + "&nbsp;页&nbsp;";
			if (data.hasNextPage) {
				str += "<button type='button' onclick='searchRoom("
						+ data.nextPage + "," + roomTypeId
						+ ")'>下一页</button>&nbsp;"
			}
			if (!data.isLastPage) {
				str += "<button type='button' onclick='searchRoom("
						+ data.pages + "," + roomTypeId + ")'>末页</button>"
			}
			$("#roomlist").html(str);
		}
	});
}
