<!-- FAMA0201Q.jsp
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
	<tiles:put name='scripts' value='/FAM/FAMA0201QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("FAMA02")%>'/>
	<tiles:put name='action' value='FAMA02F'/>
	<tiles:put name='mform' value='/FAM/FAMA0201QForm.jsp'/>
	<tiles:put name='mbar' value='/FAM/FAMA0201QBar.jsp'/>
	<tiles:put name="dform" value="/FAM/FAMA0201LForm.jsp"/>
	<tiles:put name="dbar" value="/FAM/FAMA0201LBar.jsp"/>
</tiles:insert>
