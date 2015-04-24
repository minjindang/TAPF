
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EDR/EDRE0801QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("EDRE08")%>'/>
	<tiles:put name='action' value='EDRE0801'/>
	<tiles:put name='form' value='/EDR/EDRE0801QForm.jsp'/>
	<tiles:put name='bar' value='/EDR/EDRE0401QBar.jsp'/>
</tiles:insert>
