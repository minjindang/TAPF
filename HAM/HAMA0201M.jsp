<!--
�{���ت��GHAMA02��r
�{���N���GHAMA02
�{������G0950221
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("HAMA02")%>'/>
	<tiles:put name='action' value='HAMA02F'/>
	<tiles:put name='form' value='/HAM/HAMA0201MForm.jsp'/>
	<tiles:put name='bar' value='/HAM/HAMA0201MBar.jsp'/>
</tiles:insert>
