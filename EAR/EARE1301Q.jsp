<!--
�{���ت��GGBA���� �� ���I�Ŵک��Ӫ�(���ų���)
�{���N���GEARE13
�{������G0950227
�{���@�̡Gicefire
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EAR/EARE1301QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle((String)(session.getAttribute("SYSID"))) %>'/>
	<tiles:put name='action' value='EARE1301'/>
	<tiles:put name='form' value='/EAR/EARE1301QForm.jsp'/>
	<tiles:put name='bar' value='/EAR/EARE1301QBar.jsp'/>
</tiles:insert>