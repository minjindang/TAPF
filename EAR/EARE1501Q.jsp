<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EAR/EARE1501QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle((String)(session.getAttribute("SYSID"))) %>'/>
	<tiles:put name='action' value='EARE1502'/>
	<tiles:put name='form' value='/EAR/EARE1501QForm.jsp'/>
	<tiles:put name='bar' value='/EAR/EARE1501QBar.jsp'/>
</tiles:insert>