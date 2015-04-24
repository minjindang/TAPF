<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/GAM/GAMA0801AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GAMA08")+"-[新增作業]"%>'/>
	<tiles:put name='action' value='GAMA08F'/>
	<tiles:put name="form" value="/GAM/GAMA0801AForm.jsp"/>
	<tiles:put name="bar" value="/GAM/GAMA0801ABar.jsp"/>
</tiles:insert>