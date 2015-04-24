<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/BIR/BIRA0801QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("BIRA08")%>'/>
	<tiles:put name='action' value='BIRA08F'/>
	<tiles:put name='form' value='/BIR/BIRA0801QForm.jsp'/>
	<tiles:put name='bar' value='/BIR/BIRA0801QBar.jsp'/>
</tiles:insert>