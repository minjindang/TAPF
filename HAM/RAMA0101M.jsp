<!-- RAMA0101M.jsp
程式目的：RAMA01
程式代號：RAMA01
程式日期：1001005
程式作者：Powen Hsueh
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAM/RAMA0101MScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("RAMA01")%>'/>
	<tiles:put name='action' value='RAMA01F'/>
	<tiles:put name='form' value='/HAM/RAMA0101MForm.jsp'/>
	<tiles:put name='bar' value='/HAM/RAMA0101MBar.jsp'/>
</tiles:insert>
