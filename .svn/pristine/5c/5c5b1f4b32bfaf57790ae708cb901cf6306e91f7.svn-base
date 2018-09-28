<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <script src="https://cdn-hangzhou.goeasy.io/goeasy.js"></script>
      <script type="text/javascript">
          var goEasy = new GoEasy({
              appkey: "BS-43914fbee2864e5a88a08afa6e81b754"
          });
          goEasy.subscribe({
              channel: "my_channel",
              onMessage: function (message) {
                  alert("您有新的订单请注意" + message.content);
                  window.location.href='showReserveMessageById.action?param='+message.content+"&currentPage=1";
              }
          });
      </script>	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <frameset rows="88,*,31" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="admin/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset cols="187,*" frameborder="no" border="0" framespacing="0">
    <frame src="admin/operatorleft.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame src="admin/index.jsp" name="rightFrame" id="rightFrame" title="rightFrame" />
  </frameset>
  <frame src="admin/footer.jsp" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" title="bottomFrame" />
</frameset>
  	<noframes><body>
  	</body></noframes>
</html>
