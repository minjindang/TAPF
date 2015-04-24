<!-- GARA3701Q.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/GAR/GARA3701QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GARA37")%>'/>
	<tiles:put name='action' value='GARA3701'/>
	<tiles:put name='form' value='/GAR/GARA3701QForm.jsp'/>
	<tiles:put name='bar' value='/GAR/GARA3701QBar.jsp'/>
</tiles:insert>