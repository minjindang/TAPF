<!--
程式目的：HAMB05文字
程式代號：HAMB05
程式日期：0950220
程式作者：Andrew Sung
程式名稱HAMA0501M.jsp
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMB0501MScript.jsp'/>
	<tiles:put name='title' value='<%="專案補助-"+gov.dnt.tame.util.CommonFun.getTitle("HAMC05")%>'/>
	<tiles:put name='action' value='HAMC0502'/>
	<tiles:put name='form' value='/HAM/HAMB0501MForm.jsp'/>
	<tiles:put name='bar' value='/HAM/HAMB0501MBar.jsp'/>
</tiles:insert>
