<!--
�{���ت��G�����t����ƺ��@
�{���N���GHAMA04
�{������G1000920
�{���@�̡GPowen Hsueh
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMA0401QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("HAMA04")%>'/>
	<tiles:put name='action' value='HAMA04F'/>
	<tiles:put name="mform" value="/HAM/HAMA0401QForm.jsp"/>
	<tiles:put name="mbar" value="/HAM/HAMA0401QBar.jsp"/>
	<tiles:put name="dform" value="/HAM/HAMA0401LForm.jsp"/>
	<tiles:put name="dbar" value="/HAM/HAMA0401LBar.jsp"/>
</tiles:insert>
