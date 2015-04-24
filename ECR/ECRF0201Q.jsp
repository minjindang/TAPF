<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<!--tiles:put name='scripts' value='/ECR/ECRF0201QScript.jsp'/-->
	<tiles:put name='scripts' value='/CIR/CIRA0601QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("ECRF02")%>'/>
	<tiles:put name='action' value='ECRF0201'/>
	<!--tiles:put name='form' value='/ECR/ECRF0201QForm.jsp'/-->
	<tiles:put name='form' value='/CIR/CIRA0601QForm.jsp'/>
	<!--tiles:put name='bar' value='/ECR/ECRF0201QBar.jsp'/-->
	<tiles:put name='bar' value='/CIR/CIRA0601QBar.jsp'/>
</tiles:insert>