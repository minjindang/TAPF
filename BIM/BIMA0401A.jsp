<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/BIM/BIMA0401AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("BIMA04")%>'/>
	<tiles:put name='action' value='BIMA04F'/>
	<tiles:put name='form' value='/BIM/BIMA0401AForm.jsp'/>
	<tiles:put name='bar' value='/BIM/BIMA0401ABar.jsp'/>
</tiles:insert>