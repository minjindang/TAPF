<!-- 
�{���ت��GAPRA15��r
�{���N���GAPRA15
�{������G0950221
�{���@�̡GAndrew Sung
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/APR/APRA1501QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("APRA15")%>'/>
	<tiles:put name='action' value='APRA1501'/>
	<tiles:put name='form' value='/APR/APRA1501QForm.jsp'/>
	<tiles:put name='bar' value='/APR/APRA1501QBar.jsp'/>
</tiles:insert>
