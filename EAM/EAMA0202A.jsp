<!--
�{���ت��GEAMA02��r
�{���N���GEAMA02
�{������G0950301
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EAM/EAMA0202AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle((String)(session.getAttribute("SYSID")))%>'/>
	<tiles:put name='action' value='EAMA0202F'/>
	<tiles:put name='form' value='/EAM/EAMA0202AForm.jsp'/>
	<tiles:put name='bar' value='/EAM/EAMA0202ABar.jsp'/>
</tiles:insert>
