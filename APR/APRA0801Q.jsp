<!--	APRA0801Q.jsp
�{���ت��GAPRA08�����F���n�������٥��I���ֵ����B��
�{���N���GAPRA08
�{������G0950316
�{���@�̡GERIC CHEN
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/APR/APRA0801QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("APRA08")%>'/>
	<tiles:put name='action' value='APRA08F'/>
	<tiles:put name='form' value='/APR/APRA0801QForm.jsp'/>
	<tiles:put name='bar' value='/APR/APRA0801QBar.jsp'/>
</tiles:insert>
