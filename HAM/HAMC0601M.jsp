<!--
程式目的：HAMB06文字
程式代號：HAMB06
程式日期：0950220
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMB0601MScript.jsp'/>
	<tiles:put name='title' value='<%="專案補助-"+gov.dnt.tame.util.CommonFun.getTitle("HAMC06")%>'/>
	<tiles:put name='action' value='HAMC0601'/>
	<tiles:put name='form' value='/HAM/HAMC0601MForm.jsp'/>
	<tiles:put name='bar' value='/HAM/HAMB0601MBar.jsp'/>
</tiles:insert>
