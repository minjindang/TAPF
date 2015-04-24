<%@ page language="java" contentType="text/html;charset=Big5" %>
<html>
<head>
<title>Report Viewer</title>
<link rel="stylesheet" type="text/css" href="/tapf/assets/styles/stod.css">
</head>
<body BGCOLOR="#ffffff" LINK="#000099">
<div align="center">
<SCRIPT LANGUAGE="JavaScript">
<!--
	var _info = navigator.userAgent; 
	var _ns = false; 
	var _ns6 = false;
	var _ie = (_info.indexOf("MSIE") > 0 && _info.indexOf("Win") > 0 && _info.indexOf("Windows 3.1") < 0);
//-->
</SCRIPT>

<COMMENT>
	<SCRIPT LANGUAGE="JavaScript1.1">
	<!--
		var _ns = (navigator.appName.indexOf("Netscape") >= 0 && ((_info.indexOf("Win") > 0 && _info.indexOf("Win16") < 0 && java.lang.System.getProperty("os.version").indexOf("3.5") < 0) || (_info.indexOf("Sun") > 0) || (_info.indexOf("Linux") > 0) || (_info.indexOf("AIX") > 0) || (_info.indexOf("OS/2") > 0)));
		var _ns6 = ((_ns == true) && (_info.indexOf("Mozilla/5") >= 0));
	//-->
	</SCRIPT>
</COMMENT>
<%
	String ReportHandler = "/tapf/do/" + (String) request.getParameter("ReportHandler");
%>

<SCRIPT LANGUAGE="JavaScript">
<!--
	if (_ie == true)
		document.writeln('<OBJECT classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93" WIDTH="800" HEIGHT="600" codebase="http://java.sun.com/update/1.5.0/jinstall-1_5_0_02-windows-i586.cab#Version=1,5,0,20"><NOEMBED><XMP>');
	else if (_ns == true && _ns6 == false)
		document.writeln('<EMBED type="application/x-java-applet;version=1.5" CODE="EmbeddedViewerApplet.class" CODEBASE="applets" ARCHIVE="jasperreports-1.0.3-applet.jar" WIDTH="600" HEIGHT="400" REPORT_URL="<%=ReportHandler%>" scriptable="false" pluginspage="http://java.sun.com/update/1.5.0/jinstall-1_5_0_02-windows-i586.cab#Version=1,5,0,20"><NOEMBED><XMP>');
//-->
</SCRIPT>

<APPLET CODE="EmbeddedViewerApplet.class" CODEBASE="/TAME/common" ARCHIVE="jasperreports-1.0.3-applet.jar" WIDTH="800" HEIGHT="600"></XMP>
    <PARAM NAME="CODE" VALUE="EmbeddedViewerApplet.class" >
	<PARAM NAME="CODEBASE" VALUE="/TAME/common" >
	<PARAM NAME="ARCHIVE" VALUE="jasperreports-1.0.3-applet.jar" >
    <PARAM NAME="type" VALUE="application/x-java-applet;version=1.5">
    <PARAM NAME="scriptable" VALUE="false">
    <PARAM NAME="REPORT_URL" VALUE="<%=ReportHandler%>">
</APPLET>
</NOEMBED>
</EMBED>
</OBJECT>
</APPLET>
<br><input type="button" value="Ãö³¬" class="formcss_rbutton" onclick="window.close();"> </br>
</div>
</body>
</html>
