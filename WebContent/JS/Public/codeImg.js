function getCode(){
	document.getElementById("refreashimg").src = "PictureCheckCodeServlet?a=" + Math.random();
}
getCode();