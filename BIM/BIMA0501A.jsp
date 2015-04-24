<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/BIM/BIMA0501AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("BIMA05")%>'/>
	<tiles:put name='action' value='BIMA05F'/>
	<tiles:put name='form' value='/BIM/BIMA0501AForm.jsp'/>
	<tiles:put name='bar' value='/BIM/BIMA0501ABar.jsp'/>
</tiles:insert>