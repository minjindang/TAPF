<!--	GARA1401Q.jsp
�{���ت��GGARA1401
�{���N���GGARA1401
�{������G0950316
�{���@�̡GERIC CHEN
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/GAR/GARA1401QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GARA14")%>'/>
	<tiles:put name='action' value='GARA14F'/>
	<tiles:put name='form' value='/GAR/GARA1401QForm.jsp'/>
	<tiles:put name='bar' value='/GAR/GARA1401QBar.jsp'/>
</tiles:insert>
