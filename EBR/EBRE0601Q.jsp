
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EBR/EBRE0601QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle((String)(session.getAttribute("SYSID")))%>'/>
	<tiles:put name='action' value='EBRE0602'/>
	<tiles:put name='form' value='/EBR/EBRE0601QForm.jsp'/>
	<tiles:put name='bar' value='/EBR/EBRE0601QBar.jsp'/>
</tiles:insert>