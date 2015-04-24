<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIMA01")+"-[§Q²v©ú²Ó]"%>'/>
	<tiles:put name='action' value='AIMA0101F'/>
	<tiles:put name='form' value='/AIM/AIMA0104LForm.jsp'/>
	<tiles:put name='bar' value='/AIM/AIMA0104LBar.jsp'/>
</tiles:insert>
