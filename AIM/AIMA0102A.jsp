<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/AIM/AIMA0102AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIMA01")+"-[�s�W�o����B���@]"%>'/>
	<tiles:put name='action' value='AIMA0101F'/>
	<tiles:put name='form' value='/AIM/AIMA0102MForm.jsp'/>
	<tiles:put name='bar' value='/AIM/AIMA0102ABar.jsp'/>
</tiles:insert>
