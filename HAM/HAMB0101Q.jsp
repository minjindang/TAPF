<!-- HAMB0101Q.jsp
�{���ت��GHAMB01��r
�{���N���GHAMB01
�{������G0950220
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMB0101QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("HAMB01")%>'/>
	<tiles:put name='action' value='HAMB01F'/>
	<tiles:put name='form' value='/HAM/HAMB0101QForm.jsp'/>
	<tiles:put name='bar' value='/HAM/HAMB0101QBar.jsp'/>
</tiles:insert>
