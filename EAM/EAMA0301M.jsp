<!--
�{���ت��GEAMA02��r
�{���N���GEAMA02
�{������G0950310
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/EAM/EAMA0201AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("EAMA03") %>'/>
	<tiles:put name='action' value='EAMA0301'/>
	<tiles:put name='mform' value='/EAM/EAMA0301MForm.jsp'/>
	<tiles:put name='mbar' value='/EAM/EAMA0301MBar.jsp'/>
	<tiles:put name='dform' value='/EAM/EAMB0102LForm.jsp'/>
	<tiles:put name='dbar' value='/EAM/EAMB0102LBar.jsp'/>
</tiles:insert>
