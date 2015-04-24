<%@ page language="java" contentType="text/html;charset=Big5" %>

<%@ taglib uri="../WEB-INF/taglibs/struts-tiles.tld" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name="scripts" value="/PM/PM1003_SCN1Script.jsp"/>
	<tiles:put name="title" value='<%=gov.dnt.tame.util.CommonFun.getTitle("PM1003")+"-[¬d¸ß]"%>'/>
	<tiles:put name="action" value="PM1003F"/>
	<tiles:put name="form" value="/PM/PM1003_SCN1Form.jsp"/>
	<tiles:put name="bar" value="/common/blankBar.jsp"/>
</tiles:insert>