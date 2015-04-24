<!--
程式目的：EAMA03文字
程式代號：EAMA03
程式日期：0950301
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("EAMA03") %>'/>
	<tiles:put name='action' value='EAMA0301'/>
	<tiles:put name='mform' value='/EAM/EAMA0301QForm.jsp'/>
	<tiles:put name='mbar' value='/EAM/EAMA0301QBar.jsp'/>
	<tiles:put name='dform' value='/EAM/EAMA0301LForm.jsp'/>
	<tiles:put name='dbar' value='/EAM/EAMA0301LBar.jsp'/>
</tiles:insert>
