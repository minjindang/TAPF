<!-- HARB1001P.jsp
�{���ت��GHARB10��r
�{���N���GHARB10
�{������G0950221
�{���@�̡GAndrew Sung
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAR/HARB0901QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("HARB09")%>'/>
	<tiles:put name='action' value='HARB0901F'/>
	<tiles:put name='form' value='/HAR/HARB0901QForm.jsp'/>
	<tiles:put name='bar' value='/HAR/HARB0901QBar.jsp'/>
</tiles:insert>
