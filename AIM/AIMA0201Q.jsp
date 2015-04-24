<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIMA02")+"-[¬d¸ß]"%>'/>
	<tiles:put name='action' value='AIMA02F'/>
	<tiles:put name='mform' value='/AIM/AIMA0201QForm.jsp'/>
	<tiles:put name='mbar' value='/AIM/AIMA0201QBar.jsp'/>
	<tiles:put name='dform' value='/AIM/AIMA0201LForm.jsp'/>
	<tiles:put name='dbar' value='/AIM/AIMA0201LBar.jsp'/>
</tiles:insert>
