<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("DIRA07")%>'/>
	<tiles:put name='action' value='DIRA07F'/>
	<tiles:put name='form' value='/DIR/DIRA0701QForm.jsp'/>
	<tiles:put name='bar' value='/DIR/DIRA0701QBar.jsp'/>
</tiles:insert>