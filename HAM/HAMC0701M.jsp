<!--	�q�l�l�󱵦��������@
�{���ت��GHAMB07��r
�{���N���GHAMB07
�{������G0950223
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMB0701MScript.jsp'/>
	<tiles:put name='title' value='<%="�M�׸ɧU-"+gov.dnt.tame.util.CommonFun.getTitle("HAMC07")%>'/>
	<tiles:put name='action' value='HAMC07F'/>
	<tiles:put name='form' value='/HAM/HAMB0701MForm.jsp'/>
	<tiles:put name='bar' value='/HAM/HAMB0701MBar.jsp'/>
</tiles:insert>
