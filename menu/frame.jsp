<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<html:html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<head>
	<html:base/>
	<title>��w�p  �Űȸ�T�޲z�t��</title>
</head>
    <script language="Javascript">
		<logic:present name="AlertMessage">
			alert("<bean:write name="AlertMessage"/>");
		</logic:present>
	</script>
<%
	String path = (String) request.getAttribute("path");
%>
<frameset rows="103,*" framespacing="0" border="0" frameborder="0">
	<frame name="top" src="<html:rewrite page='/do/HEADER'/>" scrolling="no" title="top" noresize>
	<frame name="bottom" src="<html:rewrite page='<%=path%>'/>" scrolling="auto" title="bottom">
	<noframes>
		<body>
			<p>�������ϥήج[�A���O�z���s�����ä��䴩&#12290;</p>
		</body>
	</noframes>
</frameset>
</html:html>
