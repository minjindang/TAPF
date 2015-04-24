<!-- GARA4001Q.jsp -->
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/GAR/GARA4001QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GARA40")%>'/>
	<tiles:put name='action' value='GARA4001'/>
	<tiles:put name='form' value='/GAR/GARA4001QForm.jsp'/>
	<tiles:put name='bar' value='/GAR/GARA4001QBar.jsp'/>
</tiles:insert>