<!--	CPRA0301Q.jsp
�{���ت��GCPRA0301
�{���N���GCPRA0301
�{������G0950316
�{���@�̡GERIC CHEN
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/CPR/CPRA0301QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("CPRA03")%>'/>
	<tiles:put name='action' value='CPRA03F'/>
	<tiles:put name='form' value='/CPR/CPRA0301QForm.jsp'/>
	<tiles:put name='bar' value='/CPR/CPRA0301QBar.jsp'/>
</tiles:insert>
