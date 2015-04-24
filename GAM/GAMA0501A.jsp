<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/GAM/GAMA0501AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GAMA05")%>'/>
	<tiles:put name='action' value='GAMA05F'/>
	<tiles:put name='form' value='/GAM/GAMA0501AForm.jsp'/>
	<tiles:put name='bar' value='/GAM/GAMA0501ABar.jsp'/>
</tiles:insert>
