<!--
�{���ت��GEAMA01��r
�{���N���GEAMA01
�{������G0950310
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EAM/EAMA0201AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle((String)(session.getAttribute("SYSID")))%>'/>
	<tiles:put name='action' value='EAMA0201F'/>
	<tiles:put name='form' value='/EAM/EAMA0201AForm.jsp'/>
	<tiles:put name='bar' value='/EAM/EAMA0201ABar.jsp'/>
</tiles:insert>
