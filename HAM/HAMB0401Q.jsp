<!--
�{���ت��GHAMB04��r
�{���N���GHAMB04
�{������G0950223
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMB0401QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("HAMB04")%>'/>
	<tiles:put name='action' value='HAMB04F'/>
	<tiles:put name='mform' value='/HAM/HAMB0401QForm.jsp'/>
	<tiles:put name='mbar' value='/HAM/HAMB0401QBar.jsp'/>
	<tiles:put name='dform' value='/HAM/HAMB0401LForm.jsp'/>
	<tiles:put name='dbar' value='/HAM/HAMB0401LBar.jsp'/>
</tiles:insert>
