<!-- RAMA0101M.jsp
�{���ت��GRAMA01
�{���N���GRAMA01
�{������G1001005
�{���@�̡GPowen Hsueh
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAM/RAMA0101MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("RAMA01")%>'/>
	<tiles:put name='action' value='RAMA01F'/>
	<tiles:put name='form' value='/HAM/RAMA0101MForm.jsp'/>
	<tiles:put name='bar' value='/HAM/RAMA0101MBar.jsp'/>
</tiles:insert>
