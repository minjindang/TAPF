<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/FAM/FAMA0102AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("FAMA01")%>'/>
	<tiles:put name='action' value='FAMA01F'/>
	<tiles:put name='form' value='/FAM/FAMA0102MForm.jsp'/>
	<tiles:put name='bar' value='/FAM/FAMA0102MBar.jsp'/>
</tiles:insert>
