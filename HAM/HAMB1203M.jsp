<!--
程式目的：HAMB12文字
程式代號：HAMB12
程式日期：1000929
程式作者：Powen Hsueh
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMB1203MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("HAMB12")%>'/>
	<tiles:put name='action' value='HAMB12F'/>
	<tiles:put name='form' value='/HAM/HAMB1203MForm.jsp'/>
	<tiles:put name='bar' value='/HAM/HAMB1203MBar.jsp'/>
</tiles:insert>
