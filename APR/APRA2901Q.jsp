<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/APR/APRA2901QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("APRA29")%>'/>
	<tiles:put name='action' value='APRA2901'/>
	<tiles:put name='form' value='/APR/APRA2901QForm.jsp'/>
	<tiles:put name='bar' value='/APR/APRA2901QBar.jsp'/>
</tiles:insert>
