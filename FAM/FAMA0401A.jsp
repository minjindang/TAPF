<!--
�{���ت��GFAMA04��r
�{���N���GFAMA04
�{������G0950223
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/FAM/FAMA0401MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("FAMA04")%>'/>
	<tiles:put name='action' value='FAMA04F'/>
	<tiles:put name='form' value='/FAM/FAMA0401AForm.jsp'/>
	<tiles:put name='bar' value='/FAM/FAMA0401ABar.jsp'/>
</tiles:insert>
