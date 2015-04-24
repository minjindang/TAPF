<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EBR/EBRC0301QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("EBRC03")%>'/>
	<tiles:put name='action' value='EBRC0302'/>
	<tiles:put name='form' value='/EBR/EBRC0301QForm.jsp'/>
	<tiles:put name='bar' value='/EBR/EBRC0301QBar.jsp'/>
</tiles:insert>