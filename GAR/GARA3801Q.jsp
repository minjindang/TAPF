
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/GAR/GARA3801QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle((String)(session.getAttribute("SYSID")))%>'/>
	<tiles:put name='action' value='GARA3802'/>
	<tiles:put name='form' value='/GAR/GARA3801QForm.jsp'/>
	<tiles:put name='bar' value='/GAR/GARA3801QBar.jsp'/>
</tiles:insert>