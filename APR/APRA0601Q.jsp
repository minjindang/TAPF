<!--	APRA0601Q.jsp
�{���ت��GAPRA06�����F���ŰȰ���M����b��I���v��
�{���N���GAPRA06
�{������G0950316
�{���@�̡GERIC CHEN
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/APR/APRA0601QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("APRA06")%>'/>
	<tiles:put name='action' value='APRA06F'/>
	<tiles:put name='form' value='/APR/APRA0601QForm.jsp'/>
	<tiles:put name='bar' value='/APR/APRA0601QBar.jsp'/>
</tiles:insert>
