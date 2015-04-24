<!--
程式目的：HAMB04文字
程式代號：HAMB04
程式日期：0950223
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMC0403MScript.jsp'/>
	<tiles:put name='title' value='<%="專案補助-"+gov.dnt.tame.util.CommonFun.getTitle("HAMC04")%>'/>
	<tiles:put name='action' value='HAMC04F'/>
	<tiles:put name='form' value='/HAM/HAMC0403MForm.jsp'/>
	<tiles:put name='bar' value='/HAM/HAMB0403MBar.jsp'/>
</tiles:insert>
