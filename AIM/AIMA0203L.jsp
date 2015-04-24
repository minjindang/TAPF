<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIMA02")+"-[¶Å²¼©ú²Ó]"%>'/>
	<tiles:put name='action' value='AIMA02F'/>
	<tiles:put name='form' value='/AIM/AIMA0203LForm.jsp'/>
	<tiles:put name='bar' value='/AIM/AIMA0203LBar.jsp'/>
</tiles:insert>
