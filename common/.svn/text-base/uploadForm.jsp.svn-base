<%@ page language="java" contentType="text/html;charset=MS950" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<table width="100%" border="0" cellspacing="0" cellpadding="0"><tr><td align="center" class="title"><%=request.getAttribute("title")%></td></tr></table>

<form name="MainForm" action="<%=request.getAttribute("action")%>" method="post" ENCTYPE="multipart/form-data" >
<%
	String mform = request.getAttribute("mform").toString();
	String mbar = request.getAttribute("mbar").toString();
	String dform = request.getAttribute("dform").toString();
	String dbar = request.getAttribute("dbar").toString();
%>
	<tiles:insert page="<%=mform%>" flush="true"/>
	<tiles:insert page="<%=mbar%>" flush="true"/>

<logic:present name="collection">

	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td align="center" class="title">
				<%=request.getAttribute("title")%>-²M³æ
			</td>
		</tr>
	</table>

	<tiles:insert page="<%=dform%>" flush="true"/>
	<tiles:insert page="<%=dbar%>" flush="true"/>

</logic:present>
</form>
<iframe name="reqfram" width="-1" height="-1" frameborder="0" title="iframe" >
