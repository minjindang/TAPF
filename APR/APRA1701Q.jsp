<!-- APRA1701Q.jsp
�{���ت��GAPRA17��r
�{���N���GAPRA17
�{������G0950221
�{���@�̡GAndrew Sung
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/APR/APRA1701QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("APRA17")%>'/>
	<tiles:put name='action' value='APRA1701'/>
	<tiles:put name='form' value='/APR/APRA1701QForm.jsp'/>
	<tiles:put name='bar' value='/APR/APRA1701QBar.jsp'/>
</tiles:insert>
