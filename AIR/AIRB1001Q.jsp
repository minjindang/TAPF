<!--
�{���ت��G�����F�����ŵo��ε���{�p��
�{���N���GAIRB10
�{������G0950227
�{���@�̡Gicefire
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/AIR/AIRB1001QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIRB10")%>'/>
	<tiles:put name='action' value='AIRB10F'/>
	<tiles:put name='form' value='/AIR/AIRB1001QForm.jsp'/>
	<tiles:put name='bar' value='/AIR/AIRB1001QBar.jsp'/>
</tiles:insert>
