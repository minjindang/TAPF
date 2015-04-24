<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/GAR/GARA0401QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GARA04")%>'/>
	<tiles:put name='action' value='GARA04F'/>
	<tiles:put name='form' value='/GAR/GARA0401QForm.jsp'/>
	<tiles:put name='bar' value='/GAR/GARA0401QBar.jsp'/>
</tiles:insert>