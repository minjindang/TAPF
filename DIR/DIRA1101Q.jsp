<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/DIR/DIRA1101QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("DIRA11")%>'/>
	<tiles:put name='action' value='DIRA11F'/>
	<tiles:put name='form' value='/DIR/DIRA1101QForm.jsp'/>
	<tiles:put name='bar' value='/DIR/DIRA0701QBar.jsp'/>
</tiles:insert>