<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/BIR/BIRA0901QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("BIRA09")%>'/>
	<tiles:put name='action' value='BIRA09F'/>
	<tiles:put name='form' value='/BIR/BIRA0901QForm.jsp'/>
	<tiles:put name='bar' value='/BIR/BIRA0901QBar.jsp'/>
</tiles:insert>