<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="gov.dnt.tame.common.*"%>

<html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<head>
	<link rel="stylesheet" type="text/css" href="<html:rewrite page='/assets/styles/stod.css'/>">
	<link rel="stylesheet" type="text/css" href="<html:rewrite page='/assets/styles/dynCalendar.css'/>">
	<title>國庫署 債務資訊管理系統</title>
	<meta http-equiv="Expires" content="-1" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Cache-Control" content="no-cache" />
	<meta http-equiv="content-type" content="text/html; charset=MS950" />
	<script language="Javascript" src="<html:rewrite page="/assets/scripts/CommonFunction.js"/>"></script>
	<script language="Javascript" src="<html:rewrite page="/assets/scripts/validations.js"/>"></script>
	<script language="Javascript" src="<html:rewrite page="/assets/scripts/autocomplete.js"/>"></script>
	<script language="Javascript" src="<html:rewrite page="/assets/scripts/autotab.js"/>"></script>
	<script language="Javascript" src="<html:rewrite page="/assets/scripts/characterValidate.js"/>"></script>
	<script language="Javascript" src="<html:rewrite page="/assets/scripts/addContextMask.js"/>"></script>
	<script language="Javascript" src="<html:rewrite page="/assets/scripts/dynCalendar.js"/>"></script>
	<script language="Javascript" src="<html:rewrite page="/assets/scripts/browserSniffer.js"/>"></script>
	<script language="Javascript" src="<html:rewrite page="/assets/scripts/getData.js"/>"></script>
	<script language="Javascript" src="<html:rewrite page="/assets/scripts/DateUtil.js"/>"></script>
	<script language="Javascript" src="<html:rewrite page="/assets/scripts/masks.js"/>"></script>
	<script language="Javascript" src="<html:rewrite page="/assets/scripts/disableFKey.js"/>"></script>
	<script language="Javascript">
		function doAlertMessage()
		{
			<logic:present name="AlertMessage">
				alert("<bean:write name="AlertMessage"/>");
			</logic:present>
		}
		//自動加千分位
		function changeMoneyMask(document)
		{
			var forms = document.forms.length;
			var C_currform = document.MainForm;
			var oNumberMask = new Mask("#,###.###", "number");
			if(null != C_currform)
			{	
				for(var i = 0 ; i < C_currform.length ; i++)
				{
					var name = C_currform[i].name;
					if("Amount" == name.match("Amount") || "amount" == name.match("amount") || "Price" == name.match("Price") || "price" == name.match("price"))
					{
						if(C_currform[i].type == "text")
						{
							var texts = document.MainForm.elements[name].length;
							for(var k = 0;k<texts;k++)
							{
								oNumberMask.attach(document.MainForm.elements[name][k]);
								document.MainForm.elements[name][k].style.textAlign = "right";
								document.MainForm.elements[name][k].value = replaceAll(document.MainForm.elements[name][k].value,",","")
								document.MainForm.elements[name][k].value = addMoneyMask(document.MainForm.elements[name][k].value);
							}
							if(null == texts)
							{
								oNumberMask.attach(document.MainForm.elements[name]);
								document.MainForm.elements[name].style.textAlign = "right";
								document.MainForm.elements[name].value = replaceAll(document.MainForm.elements[name].value,",","");
								document.MainForm.elements[name].value = addMoneyMask(document.MainForm.elements[name].value);
							}
						}	
					}	
					if("Rate" == name.match("Rate") || "rate" == name.match("rate"))
					{
						if(C_currform[i].type == "text")
						{
							var texts = document.MainForm.elements[name].length;
							for(var k = 0;k<texts;k++)
							{
								document.MainForm.elements[name][k].style.textAlign = "right";
							}
							if(null == texts)
							{
							
								document.MainForm.elements[name].style.textAlign = "right";
							}
						}	
					}	
				}	
			}	
		}
	</script>
	<tiles:get name="scripts" flush="true"/>
</head>
<body  onload="changeMoneyMask(this.document);doBodyOnLoad(this.document);">
<script type="text/javascript">
	doAlertMessage();
</script>
<div id="body">
	<tiles:importAttribute scope="request"/>
	<tiles:get name="body" flush="true"/>
</div>
</body>
</html>