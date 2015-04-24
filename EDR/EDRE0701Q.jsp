
<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/ECR/ECRE0701QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("EDRE07")%>'/>
	<tiles:put name='action' value='EDRE0701'/>
	<tiles:put name='form' value='/EDR/EDRE0701QForm.jsp'/>
	<tiles:put name='bar' value='/EDR/EDRE0401QBar.jsp'/>
</tiles:insert>
