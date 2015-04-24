<!-- EAMB0103M.jsp -->
<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle((String)(session.getAttribute("SYSID"))) %>'/>
	<tiles:put name='action' value='EAMB0103F'/>
	<tiles:put name='bar' value='/EAM/EAMB0103MBar.jsp'/>
	<tiles:put name='form' value='/EAM/EAMB0103MForm.jsp'/>
	
</tiles:insert>