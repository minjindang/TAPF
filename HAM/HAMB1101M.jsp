<!-- HAMB1101M.jsp
�{���ت��GHAMB11
�{���N���GHAMB11
�{������G1000922
�{���@�̡GPowen Hsueh
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMB1101MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("HAMB11")%>'/>
	<tiles:put name='action' value='HAMB1101M'/>
	<tiles:put name='form' value='/HAM/HAMB1101MForm.jsp'/>
	<tiles:put name='bar' value='/HAM/HAMB1101MBar.jsp'/>
</tiles:insert>
