<!--
�{���ت��GEAMA05��r
�{���N���GEAMA05
�{������G0950301
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle((String)(session.getAttribute("SYSID"))) %>'/>
	<tiles:put name='action' value='EAMB0501F'/>
	<tiles:put name='mform' value='/EAM/EAMB0501MForm.jsp'/>
	<tiles:put name='mbar' value='/EAM/EAMB0501MBar.jsp'/>
	<tiles:put name='dform' value='/EAM/EAMB0501LForm.jsp'/>
	<tiles:put name='dbar' value='/EAM/EAMB0501LBar.jsp'/>
</tiles:insert>
