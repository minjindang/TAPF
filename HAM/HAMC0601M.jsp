<!--
�{���ت��GHAMB06��r
�{���N���GHAMB06
�{������G0950220
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMB0601MScript.jsp'/>
	<tiles:put name='title' value='<%="�M�׸ɧU-"+gov.dnt.tame.util.CommonFun.getTitle("HAMC06")%>'/>
	<tiles:put name='action' value='HAMC0601'/>
	<tiles:put name='form' value='/HAM/HAMC0601MForm.jsp'/>
	<tiles:put name='bar' value='/HAM/HAMB0601MBar.jsp'/>
</tiles:insert>
