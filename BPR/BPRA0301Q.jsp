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
<%
	request.setAttribute("code","BPRA03");
%>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/BPR/BPRA0301QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("BPRA03")%>'/>
	<tiles:put name='action' value='BPRA0301'/>
	<tiles:put name='form' value='/BPR/BPRA0301QForm.jsp'/>
	<tiles:put name='bar' value='/BPR/BPRA0301QBar.jsp'/>
</tiles:insert>
<%
	request.setAttribute("code","BPRA03");
%>