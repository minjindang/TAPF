<!-- HAMB0201M.jsp
�{���ت��GHAMB02
�{���N���GHAMB02
�{������G0950222
�{���@�̡GEric.Chen
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMC0201MScript.jsp'/>
	<tiles:put name='title' value='<%="�M�׸ɧU-"+gov.dnt.tame.util.CommonFun.getTitle("HAMC02")%>'/>
	<tiles:put name='action' value='HAMC0201M'/>
	<tiles:put name='form' value='/HAM/HAMB0201MForm.jsp'/>
	<tiles:put name='bar' value='/HAM/HAMB0201MBar.jsp'/>
</tiles:insert>
