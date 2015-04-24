<%@ page language="java" contentType="text/html;charset=MS950" %>

<%@ taglib uri="../WEB-INF/taglibs/struts-tiles.tld" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name="scripts" value="/common/blankScript.jsp"/>
	<tiles:put name="title" value=''/>
	<tiles:put name="action" value=''/>
	<tiles:put name="form" value='/common/empty.jsp'/>
	<tiles:put name="bar" value='/common/empty.jsp'/>
</tiles:insert>