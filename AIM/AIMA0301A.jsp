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
	<tiles:put name='scripts' value='/AIM/AIMA0301AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIMA03")%>'/>
	<tiles:put name='action' value='AIMA0301AF'/>
	<tiles:put name='form' value='/AIM/AIMA0301AForm.jsp'/>
	<tiles:put name='bar' value='/AIM/AIMA0301ABar.jsp'/>
</tiles:insert>
