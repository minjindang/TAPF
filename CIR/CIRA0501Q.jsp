<!--	CIRA0501QQ.jsp
�{���ت��GCIRA0501
�{���N���GCIRA0501
�{������G0950316
�{���@�̡GERIC CHEN
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/CIR/CIRA0501QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("CIRA05")%>'/>
	<tiles:put name='action' value='CIRA05F'/>
	<tiles:put name='form' value='/CIR/CIRA0501QForm.jsp'/>
	<tiles:put name='bar' value='/CIR/CIRA0501QBar.jsp'/>
</tiles:insert>
