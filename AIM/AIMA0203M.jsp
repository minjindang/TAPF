<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/AIM/AIMA0203MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIMA02")+"-[¶Å²¼ºûÅ@§@·~]"%>'/>
	<tiles:put name='action' value='AIMA02F'/>
	<tiles:put name='form' value='/AIM/AIMA0203MForm.jsp'/>
	<tiles:put name='bar' value='/AIM/AIMA0203MBar.jsp'/>
</tiles:insert>
