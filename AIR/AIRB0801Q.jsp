<!--
�{���ت��G�~���٥����Ӫ�(�٥�)
�{���N���GAIRB08
�{������G0950317
�{���@�̡Gicefire
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/AIR/AIRB0801QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIRB08")%>'/>
	<tiles:put name='action' value='AIRB08F'/>
	<tiles:put name='form' value='/AIR/AIRB0801QForm.jsp'/>
	<tiles:put name='bar' value='/AIR/AIRB0801QBar.jsp'/>
</tiles:insert>
