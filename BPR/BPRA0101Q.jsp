<!-- 
�{���ت��GAPRA15��r
�{���N���GAPRA15
�{������G0950221
�{���@�̡GAndrew Sung
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/BPR/BPRA0101QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("BPRA01")%>'/>
	<tiles:put name='action' value='BPRA0101'/>
	<tiles:put name='form' value='/BPR/BPRA0101QForm.jsp'/>
	<tiles:put name='bar' value='/BPR/BPRA0101QBar.jsp'/>
</tiles:insert>
