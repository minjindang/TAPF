<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GAMA04")%>'/>
	<tiles:put name='action' value='GAMA04F'/>
	<tiles:put name='mform' value='/GAM/GAMA0401QForm.jsp'/>
	<tiles:put name='mbar' value='/GAM/GAMA0401QBar.jsp'/>
	<tiles:put name='dform' value='/GAM/GAMA0401LForm.jsp'/>
	<tiles:put name='dbar' value='/GAM/GAMA0401LBar.jsp'/>
</tiles:insert>
