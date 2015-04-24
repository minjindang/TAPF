

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EDR/EDRD0101QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle((String)(session.getAttribute("SYSID"))) %>'/>
	<tiles:put name='action' value='EDRD0202'/>
	<tiles:put name='form' value='/EDR/EDRD0201QForm.jsp'/>
	<tiles:put name='bar' value='/EDR/EDRD0101QBar.jsp'/>
</tiles:insert>