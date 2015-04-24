<!--
程式目的：HAMA06文字
程式代號：HAMA06
程式日期：1000915
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.uploadBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMA0601MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("HAMA06")%>'/>
	<tiles:put name='action' value='HAMA06F'/>
	<tiles:put name='mform' value='/HAM/HAMA0601MForm.jsp'/>
	<tiles:put name='mbar' value='/HAM/HAMA0601MBar.jsp'/>
	<tiles:put name="dform" value="/HAM/HAMA0601LForm.jsp"/>
	<tiles:put name="dbar" value="/HAM/HAMA0601LBar.jsp"/>
</tiles:insert>
