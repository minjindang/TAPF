<!--	CIRA0401Q.jsp
�{���ت��GCIRA0401�������ɴڶŰȷ��p�`��
�{���N���GCIRA0401
�{������G0950316
�{���@�̡GERIC CHEN
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/CIR/CIRA0401QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("CIRA04")%>'/>
	<tiles:put name='action' value='CIRA04F'/>
	<tiles:put name='form' value='/CIR/CIRA0401QForm.jsp'/>
	<tiles:put name='bar' value='/CIR/CIRA0401QBar.jsp'/>
</tiles:insert>
