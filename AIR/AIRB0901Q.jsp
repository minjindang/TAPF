<!--
�{���ت��G�~�ץI�����Ӫ�
�{���N���GAIRB09
�{������G0950316
�{���@�̡Gicefire
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/AIR/AIRB0901QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIRB09")%>'/>
	<tiles:put name='action' value='AIRB09F'/>
	<tiles:put name='form' value='/AIR/AIRB0901QForm.jsp'/>
	<tiles:put name='bar' value='/AIR/AIRB0901QBar.jsp'/>
</tiles:insert>
