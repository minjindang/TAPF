<!-- FAMA0601M.jsp
�{���ت��GFAMA06
�{���N���GFAMA06
�{������G0950222
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/FAM/FAMA0601MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("FAMA06")%>'/>
	<tiles:put name='action' value='FAMA06F'/>
	<tiles:put name='form' value='/FAM/FAMA0601MForm.jsp'/>
	<tiles:put name='bar' value='/FAM/FAMA0601MBar.jsp'/>
</tiles:insert>