<!-- DIMA0201A.jsp
�{���ت��GDIMA02
�{���N���GDIMA02
�{������G0950223
�{���@�̡GAndrew Sung
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("DPMA01")%>'/>
	<tiles:put name='action' value='DPMA01F'/>
	<tiles:put name='mform' value='/DPM/DPMA0102AForm.jsp'/>
	<tiles:put name='mbar' value='/DPM/DPMA0101MBar.jsp'/>
	<tiles:put name='dform' value='/DPM/DPMA0101MLForm.jsp'/>
	<tiles:put name='dbar' value='/DPM/DPMA0102ALBar.jsp'/>
</tiles:insert>
