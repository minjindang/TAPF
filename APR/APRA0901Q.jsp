<!--	APRA0901Q.jsp
�{���ت��GAPRA09�����F���n�����Ůֵ��έp��C�L
�{���N���GAPRA09
�{������G0950331
�{���@�̡GERIC CHEN
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/APR/APRA0901QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("APRA09")%>'/>
	<tiles:put name='action' value='APRA09F'/>
	<tiles:put name='form' value='/APR/APRA0901QForm.jsp'/>
	<tiles:put name='bar' value='/APR/APRA0901QBar.jsp'/>
</tiles:insert>
