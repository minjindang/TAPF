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
	<tiles:put name='scripts' value='/EAR/EARD0401QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle((String)(session.getAttribute("SYSID"))) %>'/>
	<tiles:put name='action' value='EARD0401'/>
	<tiles:put name='form' value='/EAR/EARD0401QForm.jsp'/>
	<tiles:put name='bar' value='/EAR/EARD0101QBar.jsp'/>
</tiles:insert>