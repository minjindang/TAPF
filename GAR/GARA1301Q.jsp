<!--	GARA1301Q.jsp
�{���ت��GGARA1301
�{���N���GGARA1301
�{������G0950316
�{���@�̡GERIC CHEN
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/GAR/GARA1301QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GARA13")%>'/>
	<tiles:put name='action' value='GARA13F'/>
	<tiles:put name='form' value='/GAR/GARA1301QForm.jsp'/>
	<tiles:put name='bar' value='/GAR/GARA1301QBar.jsp'/>
</tiles:insert>
