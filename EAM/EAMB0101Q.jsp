<!--
�{���ت��GEAMA03��r
�{���N���GEAMA03
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
	<tiles:put name='action' value='EAMB0104F'/>
	<tiles:put name='mform' value='/EAM/EAMB0101QForm.jsp'/>
	<tiles:put name='mbar' value='/EAM/EAMB0101QBar.jsp'/>
	<tiles:put name='dform' value='/EAM/EAMB0101LForm.jsp'/>
	<tiles:put name='dbar' value='/EAM/EAMB0101LBar.jsp'/>
</tiles:insert>
