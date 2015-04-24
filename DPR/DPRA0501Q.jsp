<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/DPR/DPRA0501QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("DPRA05")%>'/>
	<tiles:put name='action' value='DPRA05F'/>
	<tiles:put name='form' value='/DPR/DPRA0501QForm.jsp'/>
	<tiles:put name='bar' value='/DPR/DPRA0201QBar.jsp'/>
</tiles:insert>