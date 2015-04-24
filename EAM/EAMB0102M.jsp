<!-- EAMB0102M.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/EAM/EAMA0201AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle((String)(session.getAttribute("SYSID"))) %>'/>
	<tiles:put name='action' value='EAMB0102F'/>
	<tiles:put name='mform' value='/EAM/EAMB0102MForm.jsp'/>
	<tiles:put name='mbar' value='/EAM/EAMB0102MBar.jsp'/>
	<tiles:put name='dform' value='/EAM/EAMB0103LForm.jsp'/>
	<tiles:put name='dbar' value='/EAM/EAMB0103LBar.jsp'/>
</tiles:insert>
