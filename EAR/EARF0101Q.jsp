<!--
�{���ت��GGBA XML
�{���N���GEARF01
�{������G0970605
�{���@�̡GHOWARDDP
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EAR/EARF0101QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle((String)(session.getAttribute("SYSID"))) %>'/>
	<tiles:put name='action' value='EARF01F'/>
	<tiles:put name='form' value='/EAR/EARF0101QForm.jsp'/>
	<tiles:put name='bar' value='/EAR/EARF0101QBar.jsp'/>
</tiles:insert>