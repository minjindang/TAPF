<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/ECR/ECRF0301QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("ECRF03")%>'/>
	<tiles:put name='action' value='ECRF0301'/>
	<tiles:put name='form' value='/ECR/ECRF0301QForm.jsp'/>
	<tiles:put name='bar' value='/ECR/ECRF0301QBar.jsp'/>
</tiles:insert>