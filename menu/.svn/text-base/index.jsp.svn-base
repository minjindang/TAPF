<%@ page language="java" contentType="text/html;charset=big5" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<head>
<title>國庫署  債務資訊管理系統</title>
	<meta http-equiv="Content-Type" content="text/html; charset=big5">

    <script language="Javascript" src="../assets/scripts/button.js"></script>
	<script language="Javascript" src="../assets/scripts/CommonFunction.js"></script>
   	<script language="Javascript">
		function doBodyOnLoad(document)
		{
			document.MainForm.account.focus();
		}
		function doAlertMessage()
		{
			<logic:present name="AlertMessage">
				alert("<bean:write name="AlertMessage"/>");
			</logic:present>
		}
		function checkElements()
		{
			currform = document.MainForm;
			if ("" == currform.account.value)
			{
				alert("請輸入使用者帳號!!");
				currform.account.focus();
				return false;
			}

			if ("" == currform.password.value)
			{
				alert("請輸入密碼!!");
				currform.password.focus();
				return false;
			}
			currform.submit();
			return true;
		}
		function keydown()
		{
			if ("13" == event.keyCode)
				checkElements();
		}
	</script>
<style type="text/css">
<!--
body {
	margin: 0px;
	background-image: url(../assets/images/login/login_back.jpg);
	background-repeat: no-repeat;
	background-position: 0px 520px;
}

input {
	font-family: Verdana, "細明體";
	font-size: 13px;
	color: #315066;
	background-color: #EBF0F3;
	border-top: 1px solid #85ABD6;
	border-right: 1px solid #5E91C8;
	border-bottom: 1px solid #5E91C8;
	border-left: 1px solid #85ABD6;
}

.button {
	color: #364269;
	font-family: Verdana, "細明體";
	font-size: 12px;
	letter-spacing: 1px;
	background-image:;
	height: 20px;
	border: 1px solid #6699CC;
	padding-top: 2px;
	background-image: url(../assets/images/login/login_buttonback.jpg);
}
-->
</style>
</head>
<body onload="doBodyOnLoad(this.document);">

<script type="text/javascript">
	doAlertMessage(); 
</script>

<form name="MainForm" action="MAIN" method="post" target="_top">

<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td><img src="../assets/images/login/login_01.jpg" width="762" height="354"></td>
		<td width="245" height="520" rowspan="2" valign="top" background="../assets/images/login/login_03.jpg">&nbsp;</td>
	</tr>
	<tr>
		<td height="166" valign="top" background="../assets/images/login/login_02.jpg">
			<table width="480" height="96" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="237" height="31">&nbsp;</td>
					<td width="93">&nbsp;</td>
					<td width="150">
						<input type="text" value="" size="19" maxLength="16" name="account" onkeyup="this.value=this.value.toUpperCase();">
					</td>
				</tr>
				<tr>
					<td height="32">&nbsp;</td>
					<td height="32">&nbsp;</td>
					<td>
						<input type="password" size="19" maxLength="16" value="" name="password" onkeydown="javascript:keydown(this);">
					</td>
				</tr>
				<tr>
					<td height="33">&nbsp;</td>
					<td height="33" colspan="2" valign="bottom">
						<div align="right">
							<input type="submit" class="button" value="登入">
							<input type="reset" class="button" value="重置">
						</div>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

</form>
</body>
</html>