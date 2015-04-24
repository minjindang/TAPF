<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EAR/EARE0101QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle((String)(session.getAttribute("SYSID"))) %>'/>
	<tiles:put name='action' value='EARE0101'/>
	<tiles:put name='form' value='/EAR/EARE0101QForm.jsp'/>
	<tiles:put name='bar' value='/EAR/EARE0101QBar.jsp'/>
</tiles:insert>