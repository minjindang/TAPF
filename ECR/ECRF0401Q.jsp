<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/ECR/ECRF0401QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("ECRF04")%>'/>
	<tiles:put name='action' value='ECRF0401'/>
	<tiles:put name='form' value='/ECR/ECRF0401QForm.jsp'/>
	<tiles:put name='bar' value='/ECR/ECRF0401QBar.jsp'/>
</tiles:insert>