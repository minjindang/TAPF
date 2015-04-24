<!--
程式目的：FAMA05文字
程式代號：FAMA05
程式日期：0950223
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.masterDetailBody" flush="true">
	<tiles:put name='scripts' value='/FAM/FAMA0501QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("FAMA05")%>'/>
	<tiles:put name='action' value='FAMA05F'/>
	<tiles:put name='mform' value='/FAM/FAMA0501QForm.jsp'/>
	<tiles:put name='mbar' value='/FAM/FAMA0501QBar.jsp'/>
	<tiles:put name='dform' value='/FAM/FAMA0501LForm.jsp'/>
	<tiles:put name='dbar' value='/FAM/FAMA0501LBar.jsp'/>
</tiles:insert>
