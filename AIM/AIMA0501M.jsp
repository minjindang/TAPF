<!--
�{���ت��GAIMA01��r
�{���N���GAIMA01
�{������G0950306
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/AIM/AIMA0501MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIMA03")+"-[�ק�洫����]"%>'/>
	<tiles:put name='action' value='AIMA05F'/>
	<tiles:put name='form' value='/AIM/AIMA0501MForm.jsp'/>
	<tiles:put name='bar' value='/AIM/AIMA0501MBar.jsp'/>
</tiles:insert>
