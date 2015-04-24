<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<!--  logic:redirect forward="welcome"/-->
<SCRIPT LANGUAGE="JavaScript">
<!--
function doOpenNW() 
{
    currform = document.container;
    var aWindow=window.open("do/Login","DynamicWindowsName","width="+(screen.availWidth-10)+",height="+(screen.availHeight-36)+",top=0,left=0,scrollbars=yes,titlebar=yes,fullscreen=no");
    aWindow.document.write("<center>???...???...</center>");
    aWindow.document.close;
    aWindow.location = "do/Login";
    aWindow.focus;
    window.opener=null;
	window.close();
}
//-->
</SCRIPT>
<body oncontextmenu="return false" onload="javascript:doOpenNW()">