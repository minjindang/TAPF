<!-- HARC0801P.jsp
�{���ت��GHARC08��r
�{���N���GHARC08
�{������G0950221
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAR/HARC0801PScript.jsp'/>
	<tiles:put name='title' value='<%="�M�׸ɧU-"+gov.dnt.tame.util.CommonFun.getTitle("HARC08")%>'/>
	<tiles:put name='action' value='HARC08F'/>
	<tiles:put name='form' value='/HAR/HARC0801PForm.jsp'/>
	<tiles:put name='bar' value='/HAR/HARC0801PBar.jsp'/>
</tiles:insert>
