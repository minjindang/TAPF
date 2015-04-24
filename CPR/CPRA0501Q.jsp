<!--	CPRA0401Q.jsp
程式目的：CPRA0401
程式代號：CPRA0401
程式日期：0950316
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/CPR/CPRA0501QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("CPRA05")%>'/>
	<tiles:put name='action' value='CPRA05F'/>
	<tiles:put name='form' value='/CPR/CPRA0501QForm.jsp'/>
	<tiles:put name='bar' value='/CPR/CPRA0401QBar.jsp'/>
</tiles:insert>
