<!--
�{���ت��G�����F�����ŦU�~�פ����٥����B���Ӫ�
�{���N���GAIRB03
�{������G0950227
�{���@�̡Gicefire
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/AIR/AIRB0301QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIRB03")%>'/>
	<tiles:put name='action' value='AIRB03F'/>
	<tiles:put name='form' value='/AIR/AIRB0301QForm.jsp'/>
	<tiles:put name='bar' value='/AIR/AIRB0301QBar.jsp'/>
</tiles:insert>
