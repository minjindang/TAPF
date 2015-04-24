
function keyFunction() {
	//alert("Key code = " + event.keyCode);
	if (event.keyCode==27) {
				alert("Esc 的內建功能已被取消！");
		//return false;
	} else if ((event.keyCode>112) && (event.keyCode<=123)) {
		alert("F2~F12的內建功能已被取消！");
		event.keyCode = 32;
		return false;
	} else if ((event.shiftKey) && (event.keyCode==80)) {
		//alert("Shift + "+event.keyCode);
		//return false;
	} else if ((event.ctrlKey) && (event.keyCode==80)) {
		alert("Ctrl + P 的內建功能已被取消！");
		return false;
	} else if ((event.ctrlKey) && (event.keyCode==78)) {
			alert("Ctrl + N 的內建功能已被取消！");
		return false;
	} else if ((event.altKey) && (event.keyCode==80)) {
		//alert("Alt + "+event.keyCode);
		//return false;
	} else if (event.keyCode == 13) {
		event.keyCode = 9;
		return true;
	}

}
document.onkeydown=keyFunction;