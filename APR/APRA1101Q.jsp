<!--	APRA1101Q.jsp
�{���ت��GAPRA1101�����F���n�������٥��I�������C�L
�{���N���GAPRA11
�{������G0950316
�{���@�̡GERIC CHEN
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/APR/APRA1101QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("APRA11")%>'/>
	<tiles:put name='action' value='APRA11F'/>
	<tiles:put name='form' value='/APR/APRA1101QForm.jsp'/>
	<tiles:put name='bar' value='/APR/APRA1101QBar.jsp'/>
</tiles:insert>
