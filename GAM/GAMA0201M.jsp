<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/GAM/GAMA0201MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GAMA02")%>'/>
	<tiles:put name='action' value='GAMA02F'/>
	<tiles:put name='form' value='/GAM/GAMA0201MForm.jsp'/>
	<tiles:put name='bar' value='/GAM/GAMA0201MBar.jsp'/>
</tiles:insert>
