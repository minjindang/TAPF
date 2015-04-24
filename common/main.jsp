<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<html:html>
<head>
	<html:base/>
	<title>Main Jsp</title>
</head>

<tiles:useAttribute id="main_linkbar" name="main_linkbar"
	classname="java.lang.String"/>
<tiles:useAttribute id="main_statusbar" name="main_statusbar"
	classname="java.lang.String"/>
<tiles:useAttribute id="main_body" name="main_body"
	classname="java.lang.String"/>

<frameset name="main" rows="35,35,*" frameborder=0 border="0" framespacing="0">
	<frame name="main_linkbar" marginwidth="0" marginheight="0"
		src="<html:rewrite page='<%=main_linkbar%>'/>" noresize scrolling="no">
	<frame name="main_statusbar" marginwidth="0" marginheight="0"
		src="<html:rewrite page='<%=main_statusbar%>'/>" noresize scrolling="no">
	<frame name="main_body" marginwidth="0" marginheight="0"
		src="<html:rewrite page='<%=main_body%>'/>" noresize scrolling="auto">
 	<noframes>
    	<body>
        	This text will appear only if the browser does not support frames.
    	</body>
	</noframes>
</frameset>
</html:html>