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
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMB0701QScript.jsp'/>
	<tiles:put name='title' value='<%="�M�׸ɧU-"+gov.dnt.tame.util.CommonFun.getTitle("HAMC07")%>'/>
	<tiles:put name='action' value='HAMC07F'/>
	<tiles:put name='mform' value='/HAM/HAMC0701QForm.jsp'/>
	<tiles:put name='mbar' value='/HAM/HAMB0701QBar.jsp'/>
	<tiles:put name='dform' value='/HAM/HAMC0701LForm.jsp'/>
	<tiles:put name='dbar' value='/HAM/HAMB0701LBar.jsp'/>
</tiles:insert>
