<!--	GARA3001Q.jsp
�{���ت��GGARA3001
�{���N���GGARA3001
�{������G0950316
�{���@�̡GERIC CHEN
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/GAR/GARA3001QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GARA30")%>'/>
	<tiles:put name='action' value='GARA30F'/>
	<tiles:put name='form' value='/GAR/GARA3001QForm.jsp'/>
	<tiles:put name='bar' value='/GAR/GARA3001QBar.jsp'/>
</tiles:insert>
