<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/ECR/ECRE0801QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle((String)(session.getAttribute("SYSID")))%>'/>
	<tiles:put name='action' value='ECRE0801'/>
	<tiles:put name='form' value='/ECR/ECRE0801QForm.jsp'/>
	<tiles:put name='bar' value='/ECR/ECRE0801QBar.jsp'/>
</tiles:insert>