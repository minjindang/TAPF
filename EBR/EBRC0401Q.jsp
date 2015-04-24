<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EBR/EBRC0401QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("EBRC04")%>'/>
	<tiles:put name='action' value='EBRC0402'/>
	<tiles:put name='form' value='/EBR/EBRC0401QForm.jsp'/>
	<tiles:put name='bar' value='/EBR/EBRC0401QBar.jsp'/>
</tiles:insert>