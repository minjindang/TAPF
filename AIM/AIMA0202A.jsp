<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/AIM/AIMA0202AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIMA02")+"-[發行金額新增作業]"%>'/>
	<tiles:put name='action' value='AIMA02F'/>
	<tiles:put name='form' value='/AIM/AIMA0202MForm.jsp'/>
	<tiles:put name='bar' value='/AIM/AIMA0202ABar.jsp'/>
</tiles:insert>
