<!--
�{���ت��GFAMA05��r
�{���N���GFAMA05
�{������G0950223
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/FAM/FAMA0501MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("FAMA05")%>'/>
	<tiles:put name='action' value='FAMA05F'/>
	<tiles:put name='form' value='/FAM/FAMA0501MForm.jsp'/>
	<tiles:put name='bar' value='/FAM/FAMA0501MBar.jsp'/>
</tiles:insert>
