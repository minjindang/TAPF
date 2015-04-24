<%@ page language="java" contentType="text/html;charset=Big5" %>

<%@ taglib uri="../WEB-INF/taglibs/struts-tiles.tld" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name="scripts" value="/PM/PM1005_SCN1Script.jsp"/>
	<tiles:put name="title" value='<%=gov.dnt.tame.util.CommonFun.getTitle("PM1005")+"-[²M³æ]"%>'/>
	<tiles:put name="action" value="PM1005F"/>
	<tiles:put name="form" value="/PM/PM1005_SCN2Form.jsp"/>
	<tiles:put name="bar" value="/common/blankBar.jsp"/>
</tiles:insert>



