<!--
�{���ت��G�����F���洫���ť洫����`��
�{���N���GAIRC10
�{������G0950308
�{���@�̡GERIC CHEN
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/AIR/AIRC1101QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIRC11")%>'/>
	<tiles:put name='action' value='AIRC11F'/>
	<tiles:put name='form' value='/AIR/AIRC1101QForm.jsp'/>
	<tiles:put name='bar' value='/AIR/AIRC1101QBar.jsp'/>
</tiles:insert>
