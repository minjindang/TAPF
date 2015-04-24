<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/FAM/FAMA0101AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("FAMA01")%>'/>
	<tiles:put name='action' value='FAMA01F'/>
	<tiles:put name='mform' value='/FAM/FAMA0101MForm.jsp'/>
	<tiles:put name='mbar' value='/FAM/FAMA0101MBar.jsp'/>
	<tiles:put name='dform' value='/FAM/FAMA0102LForm.jsp'/>
	<tiles:put name='dbar' value='/FAM/FAMA0102LBar.jsp'/>
</tiles:insert>
