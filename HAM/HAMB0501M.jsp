<!--
µ{¦¡¥Øªº¡GHAMB05¤å¦r
µ{¦¡¥N¸¹¡GHAMB05
µ{¦¡¤é´Á¡G0950220
µ{¦¡§@ªÌ¡GAndrew Sung
µ{¦¡¦WºÙHAMA0501M.jsp
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMB0501MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("HAMB05")%>'/>
	<tiles:put name='action' value='HAMB0502'/>
	<tiles:put name='form' value='/HAM/HAMB0501MForm.jsp'/>
	<tiles:put name='bar' value='/HAM/HAMB0501MBar.jsp'/>
</tiles:insert>
