<!--	CPRA0401Q.jsp
�{���ت��GCPRA0401
�{���N���GCPRA0401
�{������G0950316
�{���@�̡GERIC CHEN
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/CPR/CPRA0501QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("CPRA05")%>'/>
	<tiles:put name='action' value='CPRA05F'/>
	<tiles:put name='form' value='/CPR/CPRA0501QForm.jsp'/>
	<tiles:put name='bar' value='/CPR/CPRA0401QBar.jsp'/>
</tiles:insert>
