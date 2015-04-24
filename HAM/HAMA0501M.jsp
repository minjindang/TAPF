<!--
程式目的：HAMA05文字
程式代號：HAMA05
程式日期：1000914
程式作者：Powen Hsueh
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAM/HAMA0501MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("HAMA05")%>'/>
	<tiles:put name='action' value='HAMA05F'/>
	<tiles:put name='form' value='/HAM/HAMA0501MForm.jsp'/>
	<tiles:put name='bar' value='/HAM/HAMA0501MBar.jsp'/>
</tiles:insert>
