<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/APR/APRA3001QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("APRA30")%>'/>
	<tiles:put name='action' value='APRA3001'/>
	<tiles:put name='form' value='/APR/APRA3001QForm.jsp'/>
	<tiles:put name='bar' value='/APR/APRA3001QBar.jsp'/>
</tiles:insert>
