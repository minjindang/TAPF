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
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/DPM/DPMA0101AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("DPMA01")%>'/>
	<tiles:put name='action' value='DPMA01F'/>
	<tiles:put name='form' value='/DPM/DPMA0101AForm.jsp'/>
	<tiles:put name='bar' value='/DPM/DPMA0101ABar.jsp'/>
</tiles:insert>
