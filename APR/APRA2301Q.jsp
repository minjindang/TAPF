<!-- 
程式目的：APRA15文字
程式代號：APRA15
程式日期：0950221
程式作者：Andrew Sung
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/APR/APRA2301QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("APRA23")%>'/>
	<tiles:put name='action' value='APRA2301'/>
	<tiles:put name='form' value='/APR/APRA2301QForm.jsp'/>
	<tiles:put name='bar' value='/APR/APRA2301QBar.jsp'/>
</tiles:insert>
