<!--
�{���ت��G�ּ����ť���������Ӫ�(�̹w��O)
�{���N���GAPRA02
�{������G0950308
�{���@�̡GERIC CHEN
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/APR/APRA0201QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("APRA02")%>'/>
	<tiles:put name='action' value='APRA02F'/>
	<tiles:put name='form' value='/APR/APRA0201QForm.jsp'/>
	<tiles:put name='bar' value='/APR/APRA0201QBar.jsp'/>
</tiles:insert>
