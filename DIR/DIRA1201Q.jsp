<!--
�{���ت��G
�{���N���GDIRA1201
�{������G0950227
�{���@�̡Gicefire
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/DIR/DIRA1201QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("DIRA12")%>'/>
	<tiles:put name='action' value='DIRA12F'/>
	<tiles:put name='form' value='/DIR/DIRA1201QForm.jsp'/>
	<tiles:put name='bar' value='/DIR/DIRA1201QBar.jsp'/>
</tiles:insert>