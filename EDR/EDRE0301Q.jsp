<!--
�{���ت��G�u�����I�u���ɴڳ���C�L
�{���N���GEDRE03
�{������G0950523
�{���@�̡GAvery
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EDR/EDRE0301QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("EDRE03") %>'/>
	<tiles:put name='action' value='EDRE03F'/>
	<tiles:put name='form' value='/EDR/EDRE0301QForm.jsp'/>
	<tiles:put name='bar' value='/EDR/EDRE0301QBar.jsp'/>
</tiles:insert>