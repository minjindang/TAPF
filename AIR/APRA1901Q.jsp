<!--
�{���ت��G�����n���Ũ��٥��I��������I�l�B����`��
�{���N���GAIRC06
�{������G0950227
�{���@�̡GJackDu
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIRC06")%>'/>
	<tiles:put name='action' value='AIRC06F'/>
	<tiles:put name='form' value='/AIR/AIRC0601QForm.jsp'/>
	<tiles:put name='bar' value='/AIR/AIRC0601QBar.jsp'/>
</tiles:insert>
