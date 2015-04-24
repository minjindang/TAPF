<!--
程式目的：HAMB07文字
程式代號：HAMB07
程式日期：0950223
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/common/blankScript.jsp'/>
	<tiles:put name='title' value='HAMB07'/>
	<tiles:put name='action' value='HAMB07F'/>
	<tiles:put name='form' value='/HA/HAMB0703MForm.jsp'/>
	<tiles:put name='bar' value='/HA/HAMB0703MBar.jsp'/>
</tiles:insert>
