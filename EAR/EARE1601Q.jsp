<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EAR/EARE1601QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle((String)(session.getAttribute("SYSID"))) %>'/>
	<tiles:put name='action' value='EARE1602'/>
	<tiles:put name='form' value='/EAR/EARE1601QForm.jsp'/>
	<tiles:put name='bar' value='/EAR/EARE1601QBar.jsp'/>
</tiles:insert>