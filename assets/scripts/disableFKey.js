
function keyFunction() {
	//alert("Key code = " + event.keyCode);
	if (event.keyCode==27) {
				alert("Esc �����إ\��w�Q�����I");
		//return false;
	} else if ((event.keyCode>112) && (event.keyCode<=123)) {
		alert("F2~F12�����إ\��w�Q�����I");
		event.keyCode = 32;
		return false;
	} else if ((event.shiftKey) && (event.keyCode==80)) {
		//alert("Shift + "+event.keyCode);
		//return false;
	} else if ((event.ctrlKey) && (event.keyCode==80)) {
		alert("Ctrl + P �����إ\��w�Q�����I");
		return false;
	} else if ((event.ctrlKey) && (event.keyCode==78)) {
			alert("Ctrl + N �����إ\��w�Q�����I");
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