<!-- HARC1001P.jsp
�{���ت��GHARC10��r
�{���N���GHARC10
�{������G0950221
�{���@�̡GAndrew Sung
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAR/HARC0901QScript.jsp'/>
	<tiles:put name='title' value='<%="�M�׸ɧU-"+gov.dnt.tame.util.CommonFun.getTitle("HARC09")%>'/>
	<tiles:put name='action' value='HARC0901F'/>
	<tiles:put name='form' value='/HAR/HARC0901QForm.jsp'/>
	<tiles:put name='bar' value='/HAR/HARC0901QBar.jsp'/>
</tiles:insert>
