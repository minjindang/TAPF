<!--
�{���ت��G�����F�����ŦU�~�פ��ť������B���Ӫ�
�{���N���GAIRB05
�{������G0950227
�{���@�̡Gicefire
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/AIR/AIRB0501QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIRB05")%>'/>
	<tiles:put name='action' value='AIRB05F'/>
	<tiles:put name='form' value='/AIR/AIRB0501QForm.jsp'/>
	<tiles:put name='bar' value='/AIR/AIRB0501QBar.jsp'/>
</tiles:insert>