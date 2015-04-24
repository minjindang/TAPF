
<!-- GARA1101Q.jsp -->
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/GAR/GARA1101QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GARA11")%>'/>
	<tiles:put name='action' value='GARA11F'/>
	<tiles:put name='form' value='/GAR/GARA1101QForm.jsp'/>
	<tiles:put name='bar' value='/GAR/GARA1101QBar.jsp'/>
</tiles:insert>