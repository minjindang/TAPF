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
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("HAMB04")%>'/>
	<tiles:put name='action' value='HAMB04F'/>
	<tiles:put name='mform' value='/HAM/HAMA0410MForm.jsp'/>
	<tiles:put name='mbar' value='/HAM/HAMA0410MBar.jsp'/>
	<tiles:put name="dform" value="/common/blankScript.jsp"/>
	<tiles:put name="dbar" value="/common/blankScript.jsp"/>
</tiles:insert>
