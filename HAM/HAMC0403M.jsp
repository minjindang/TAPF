<!--
�{���ت��GHAMB04��r
�{���N���GHAMB04
�{������G0950223
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMC0403MScript.jsp'/>
	<tiles:put name='title' value='<%="�M�׸ɧU-"+gov.dnt.tame.util.CommonFun.getTitle("HAMC04")%>'/>
	<tiles:put name='action' value='HAMC04F'/>
	<tiles:put name='form' value='/HAM/HAMC0403MForm.jsp'/>
	<tiles:put name='bar' value='/HAM/HAMB0403MBar.jsp'/>
</tiles:insert>
