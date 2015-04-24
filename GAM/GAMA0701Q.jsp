<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/GAM/GAMA0701QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GAMA07")+"-[¬d¸ß§@·~]"%>'/>
	<tiles:put name='action' value='GAMA07F'/>
	<tiles:put name="mform" value="/GAM/GAMA0701QForm.jsp"/>
	<tiles:put name="mbar" value="/GAM/GAMA0701QBar.jsp"/>
	<tiles:put name='dform' value='/GAM/GAMA0701LForm.jsp'/>
	<tiles:put name='dbar' value='/GAM/GAMA0701LBar.jsp'/>
</tiles:insert>