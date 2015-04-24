<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/AIM/AIMA0203AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIMA02")+"-[新增債票作業]"%>'/>
	<tiles:put name='action' value='AIMA02F'/>
	<tiles:put name='form' value='/AIM/AIMA0203MForm.jsp'/>
	<tiles:put name='bar' value='/AIM/AIMA0203ABar.jsp'/>
</tiles:insert>
