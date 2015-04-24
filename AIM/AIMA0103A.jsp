<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/AIM/AIMA0103AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIMA01")+"-[新增債票作業]"%>'/>
	<tiles:put name='action' value='AIMA0101F'/>
	<tiles:put name='form' value='/AIM/AIMA0103AForm.jsp'/>
	<tiles:put name='bar' value='/AIM/AIMA0103ABar.jsp'/>
</tiles:insert>
