<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/BIR/BIRA0701QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("BIRA07")%>'/>
	<tiles:put name='action' value='BIRA07F'/>
	<tiles:put name='form' value='/BIR/BIRA0701QForm.jsp'/>
	<tiles:put name='bar' value='/BIR/BIRA0701QBar.jsp'/>
</tiles:insert>