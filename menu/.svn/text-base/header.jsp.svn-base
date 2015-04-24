<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ page import="java.util.*" %>
<html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<head>
	<title>國庫署  債務資訊管理系統</title>
	<meta http-equiv="Expires" content="-1" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Cache-Control" content="no-cache" />
	<meta http-equiv="content-type" content="text/html; charset=MS950" />
</head>
<STYLE type=text/css>
DIV.buttonBar {
	CURSOR: hand;
	PADDING-LEFT: 0px;
	Z-INDEX: 1;
	POSITION: absolute;
	TOP: 78px;
	LEFT: 10px;

}
</STYLE>
<script language="Javascript">
<!--
function getML(id)
{
	if (id!="")
	    parent.bottom.location.href = "/tapf/do/MENU?ID="+id;
}

function doLogout()
{
	parent.location.href = "/tapf/do/Logout";
}
//-->
</script>
<body background="../assets/images/header2/back.gif">
<DIV class="buttonBar">

<table border="0" cellpadding="0" cellspacing="0">
	<tr>
<%
		List list = (List) request.getAttribute("menuBar");
		int i=1;
		for (Iterator it = list.iterator();it.hasNext();)
		{
			Map param = (Map) it.next();
			if(!param.isEmpty())
			{
				String	id		=	param.get("ID").toString();
				String	name	=	(String) param.get("NAME");
%>
		<td>
			<img hspace="0" border="0" src="../assets/images/button/<%=id%>b.gif"
				onclick="getML('<%=id%>');"
				onMouseOver="this.src='../assets/images/button/<%=id%>a.gif'"
				onMouseOut="this.src='../assets/images/button/<%=id%>b.gif'"
				alt="<%=name%>"/>
<%
			}
			i++;
%>
		</td>
<%
		}
%>
		<td>
			<img border="0" src="../assets/images/button/homeb.gif"
				onclick="doLogout();"
				onMouseOver="this.src='../assets/images/button/homea.gif'"
				onMouseOut="this.src='../assets/images/button/homeb.gif'"
				alt="回首頁"/>
		</td>
	</tr>
</table>

</DIV>
</body>
</html>