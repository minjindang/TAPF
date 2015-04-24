<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/ECR/ECRE1001QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle((String)(session.getAttribute("SYSID")))%>'/>
	<tiles:put name='action' value='ECRE1001'/>
	<tiles:put name='form' value='/ECR/ECRE1001QForm.jsp'/>
	<tiles:put name='bar' value='/EAR/EARD0101QBar.jsp'/>
</tiles:insert>