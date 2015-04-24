<!-- GARA3901Q.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/GAR/GARA3901QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GARA39")%>'/>
	<tiles:put name='action' value='GARA3901'/>
	<tiles:put name='form' value='/GAR/GARA3901QForm.jsp'/>
	<tiles:put name='bar' value='/GAR/GARA3901QBar.jsp'/>
</tiles:insert>