<!-- FAMA0601Q.jsp
�{���ت��GFAMA02
�{���N���GFAMA02
�{������G0950222
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/FAM/FAMA0601QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("FAMA06")%>'/>
	<tiles:put name='action' value='FAMA06F'/>
	<tiles:put name='mform' value='/FAM/FAMA0601QForm.jsp'/>
	<tiles:put name='mbar' value='/FAM/FAMA0601QBar.jsp'/>
	<tiles:put name="dform" value="/FAM/FAMA0601LForm.jsp"/>
	<tiles:put name="dbar" value="/FAM/FAMA0601LBar.jsp"/>
</tiles:insert>
