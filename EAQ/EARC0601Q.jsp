<!--
�{���ت��GHAMA03��r
�{���N���GHAMA03
�{������G0950220
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EAQ/EARC0601QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("EARC06")%>'/>
	<tiles:put name='action' value='EARC0601'/>
	<tiles:put name='form' value='/EAQ/EARC0601QForm.jsp'/>
	<tiles:put name='bar' value='/EAQ/EARC0601QBar.jsp'/>
</tiles:insert>
