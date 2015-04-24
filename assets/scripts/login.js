function SetFocus()
{
	MainForm.USER_PWD.focus();
	MainForm.USER_ID.focus();
}

function CheckForm ()
{
	currform = document.MainForm;
	if(currform.USER_ID.value == "")
	{
		alert("請輸入使用者帳號");
		currform.USER_ID.focus();
		return false;
	}
	if(currform.USER_PWD.value == "")
	{
		alert("請輸入密碼");
		currform.USER_PWD.focus();
		return false;
	}
	return true;
}