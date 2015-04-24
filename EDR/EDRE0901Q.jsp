<!--
程式目的：短期應付短期借款報表列印
程式代號：EDRE09
程式日期：0950523
程式作者：Avery
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EDR/EDRE0901QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("EDRE09") %>'/>
	<tiles:put name='action' value='EDRE09F'/>
	<tiles:put name='form' value='/EDR/EDRE0901QForm.jsp'/>
	<tiles:put name='bar' value='/EDR/EDRE0901QBar.jsp'/>
</tiles:insert>