<!--	APRA1001Q.jsp
�{���ت��GAPRA10�����F���n�����Ůֵ��֭p��C�L
�{���N���GAPRA10
�{������G0950331
�{���@�̡GERIC CHEN
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/APR/APRA1001QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("APRA10")%>'/>
	<tiles:put name='action' value='APRA10F'/>
	<tiles:put name='form' value='/APR/APRA1001QForm.jsp'/>
	<tiles:put name='bar' value='/APR/APRA1001QBar.jsp'/>
</tiles:insert>
