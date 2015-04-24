<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EAR/EARE0201QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("EARE02")%>'/>
	<tiles:put name='action' value='EARE0201'/>
	<tiles:put name='form' value='/EAR/EARE0201QForm.jsp'/>
	<tiles:put name='bar' value='/EAR/EARE0201QBar.jsp'/>
</tiles:insert>