<!-- EAMA0101M.jsp
�{���ت��GEAMA01
�{���N���GEAMA01
�{������G0950308
�{���@�̡GLinus.Tseng
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EAM/EAMB0104MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle((String)(session.getAttribute("SYSID"))) %>'/>
	<tiles:put name='action' value='EAMB0105F'/>
	<tiles:put name='bar' value='/EAM/EAMB0104MBar.jsp'/>
	<tiles:put name='form' value='/EAM/EAMB0104MForm.jsp'/>
	
</tiles:insert>