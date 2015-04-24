
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EDR/EDRE1001QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("EDRE10")%>'/>
	<tiles:put name='action' value='EDRE1001'/>
	<tiles:put name='form' value='/EDR/EDRE1001QForm.jsp'/>
	<tiles:put name='bar' value='/EDR/EDRE1001QBar.jsp'/>
</tiles:insert>
