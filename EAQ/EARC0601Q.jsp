<!--
程式目的：HAMA03文字
程式代號：HAMA03
程式日期：0950220
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EAQ/EARC0601QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("EARC06")%>'/>
	<tiles:put name='action' value='EARC0601'/>
	<tiles:put name='form' value='/EAQ/EARC0601QForm.jsp'/>
	<tiles:put name='bar' value='/EAQ/EARC0601QBar.jsp'/>
</tiles:insert>
