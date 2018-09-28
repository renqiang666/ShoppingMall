function showPage(ppage) {
    $.ajax({
        url: "/CheckInList.action",
        method: "post",
        async: true,
        dataType: "json",
        data: "currentPage=" + ppage + "",
        success: function (data) {
            var check = data.list;
            var currentPage = data.pageNum;
            var totalPage = data.lastPage;
            var totalNum = data.total;
            var firsts = data.firstPage;
            var content = "";
            var firstPage = "<a href='javascript:;'onclick='showPage(" + firsts + ")'>首页</a>";
            for (var i = 0; i < check.length; i++) {
                var checks = check[i];
                var arriveTim=timetrans(checks.arriveTime);
                var leaveTim=timetrans(checks.leaveTime);
                content +="<tr>"+
                    "<td><input name='' type='checkbox' value='' /></td>" +
                    "<td>"+checks.room.id+"</td>" +
                    "<td>"+checks.id+"</td>\n" +
                    "<td>"+arriveTim+"</td>\n" +
                    "<td>"+leaveTim+"</td>\n" +
                    "<td>"+checks.stayDays+"</td>\n" +
                    "<td>"+checks.pledgeMoney+"</td>\n" +
                    "<td>"+checks.paidMoney+"</td>\n" +
                    "<td>"+checks.paidMoney+"</td>\n" +
                    "<td><a href=\"#\" class=\"tablelink\">查看</a>     <a href=\"#\" class=\"tablelink\">删除</a></td>"+
                    "</tr>"
            }
            $("#currentPage").html(currentPage);
            $("#totalPage").html(totalPage);
            $("#blue").html(totalNum);
            $(".firstPage").html(firstPage);
            $("#content-td").html(content);
        }
    })
}
function timetrans(date){
    var timestamp4 = new Date(date);
    return timestamp4.toLocaleDateString().replace(/\//g, "-") + " " + timestamp4.toTimeString().substr(0, 8);

}
function judgeTime(date,date2){
    
}


showPage(1);

function nextPage() {
    var scurrentPage = $("#currentPage").html();
    var currentPage = parseInt(scurrentPage);
    var nextPages = currentPage + 1;
    var totalPage = parseInt($("#totalPage").html());
    if (nextPages <= totalPage) {
        showPage(nextPages);
    }
}

function lastPage() {
    var scurrentPage = $("#currentPage").html();
    var currentPage = parseInt(scurrentPage);
    var lastPage = currentPage - 1;
    if (lastPage > 0) {
        showPage(lastPage);
    }
}

function endPage() {
    var totalPage = parseInt($("#totalPage").html());
    showPage(totalPage);
}

function startPage() {
    showPage(1);
}
