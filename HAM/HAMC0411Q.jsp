<!--
�{���ت��G�k���ɸ�ƺ��@-��ƶפJ�ץ�
�{���N���GHAMA0409
�{������G0991018
�{���@�̡GChris Wu
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.uploadBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMA0409MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("HAMC04")%>'/>
	<tiles:put name='action' value='HAMC04F'/>
	<tiles:put name='mform' value='/HAM/HAMA0409MForm.jsp'/>
	<tiles:put name='mbar' value='/HAM/HAMC0409MBar.jsp'/>
	<tiles:put name="dform" value="/common/blankScript.jsp"/>
	<tiles:put name="dbar" value="/common/blankScript.jsp"/>
</tiles:insert>
