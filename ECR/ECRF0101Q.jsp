<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/ECR/ECRF0101QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("ECRF01")%>'/>
	<tiles:put name='action' value='ECRF01F'/>
	<tiles:put name='form' value='/ECR/ECRF0101QForm.jsp'/>
	<tiles:put name='bar' value='/ECR/ECRF0101QBar.jsp'/>
</tiles:insert>