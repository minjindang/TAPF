<!--	CIRA0701Q.jsp
�{���ت��GCIRA0701
�{���N���GCIRA0701
�{������G0950316
�{���@�̡GERIC CHEN
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/CIR/CIRA0701QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("CIRA07")%>'/>
	<tiles:put name='action' value='CIRA07F'/>
	<tiles:put name='form' value='/CIR/CIRA0701QForm.jsp'/>
	<tiles:put name='bar' value='/CIR/CIRA0701QBar.jsp'/>
</tiles:insert>
