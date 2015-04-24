<%@ page language="java" contentType="text/html;charset=MS950" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<table width="100%" border="0" cellspacing="0" cellpadding="0"><tr><td align="center" class="title"><%=request.getAttribute("title")%></td></tr></table>

<form name="MainForm" action="<%=request.getAttribute("action")%>" method="post">
<%
	String mform = request.getAttribute("mform").toString();
	String mbar = request.getAttribute("mbar").toString();
	String dform = request.getAttribute("dform").toString();
	String dbar = request.getAttribute("dbar").toString();
	String lform = request.getAttribute("lform").toString();
	String lbar = request.getAttribute("lbar").toString();
	String llform = request.getAttribute("llform").toString();
	String llbar = request.getAttribute("llbar").toString();
%>
	<tiles:insert page="<%=mform%>" flush="true"/>
	<tiles:insert page="<%=mbar%>" flush="true"/>

	<tiles:insert page="<%=dform%>" flush="true"/>
	<tiles:insert page="<%=dbar%>" flush="true"/>

	<tiles:insert page="<%=lform%>" flush="true"/>
	<tiles:insert page="<%=lbar%>" flush="true"/>
	
	<tiles:insert page="<%=llform%>" flush="true"/>
	<tiles:insert page="<%=llbar%>" flush="true"/>

</form>
<iframe name="reqfram" width="-1" height="-1" frameborder="0" title="iframe" >
