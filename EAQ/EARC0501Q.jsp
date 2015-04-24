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
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/EAQ/EARC0501QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("EARC05")%>'/>
	<tiles:put name='action' value='EARC05F'/>
	<tiles:put name='mform' value='/EAQ/EARC0501QForm.jsp'/>
	<tiles:put name='mbar' value='/EAQ/EARC0501QBar.jsp'/>
	<tiles:put name="dform" value="/EAQ/EARC0501LForm.jsp"/>
	<tiles:put name="dbar" value="/EAQ/EARC0501LBar.jsp"/>
</tiles:insert>
