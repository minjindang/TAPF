<!-- 
程式目的：APRA15文字
程式代號：APRA15
程式日期：0950221
程式作者：Andrew Sung
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
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