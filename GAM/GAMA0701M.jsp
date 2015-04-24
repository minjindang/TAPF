<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/GAM/GAMA0701MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GAMA07")+"-[ºûÅ@§@·~]"%>'/>
	<tiles:put name='action' value='GAMA07F'/>
	<tiles:put name="form" value="/GAM/GAMA0701MForm.jsp"/>
	<tiles:put name="bar" value="/GAM/GAMA0701MBar.jsp"/>
</tiles:insert>