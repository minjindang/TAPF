<%@ page language="java" contentType="text/html;charset=MS950" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<table width="100%" border="0" cellspacing="0" cellpadding="0"><tr><td align="center" class="title"><%=request.getAttribute("title")%></td></tr></table>
<form name="MainForm" action="<%=request.getAttribute("action")%>" method="post">
<%
	String	form	=	request.getAttribute("form").toString();
	String	bar		=	request.getAttribute("bar").toString();
%>
	<tiles:insert page="<%=form%>" flush="true"/>
	<tiles:insert page="<%=bar%>" flush="true"/>
</form>
<iframe name="reqfram" width="-1" height="-1" frameborder="0" title="iframe" >