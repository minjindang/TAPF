<!--
�{���ت��G�����F�������٥��I������
�{���N���GAIRB01
�{������G0950227
�{���@�̡Gicefire
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/AIR/AIRB0101QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIRB01")%>'/>
	<tiles:put name='action' value='AIRB01F'/>
	<tiles:put name='form' value='/AIR/AIRB0101QForm.jsp'/>
	<tiles:put name='bar' value='/AIR/AIRB0101QBar.jsp'/>
</tiles:insert>