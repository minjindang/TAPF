<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/AIM/AIMA0105AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIMA01")+"-[新增提前償付]"%>'/>
	<tiles:put name='action' value='AIMA0101F'/>
	<tiles:put name='form' value='/AIM/AIMA0105AForm.jsp'/>
	<tiles:put name='bar' value='/AIM/AIMA0105ABar.jsp'/>
</tiles:insert>
