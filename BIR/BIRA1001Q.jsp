<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/BIR/BIRA1001QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("BIRA10")%>'/>
	<tiles:put name='action' value='BIRA10F'/>
	<tiles:put name='form' value='/BIR/BIRA1001QForm.jsp'/>
	<tiles:put name='bar' value='/BIR/BIRA1001QBar.jsp'/>
</tiles:insert>