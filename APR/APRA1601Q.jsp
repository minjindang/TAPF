<!-- APRA1601Q.jsp
�{���ت��GAPRA16��r
�{���N���GAPRA16
�{������G0950221
�{���@�̡GAndrew Sung
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/APR/APRA1601QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("APRA16")%>'/>
	<tiles:put name='action' value='APRA1601'/>
	<tiles:put name='form' value='/APR/APRA1601QForm.jsp'/>
	<tiles:put name='bar' value='/APR/APRA1601QBar.jsp'/>
</tiles:insert>
