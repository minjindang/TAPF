<!--	CPRA0601Q.jsp
程式目的：CPRB0301
程式代號：CPRB0301
程式日期：0950316
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/CPR/CPRB0301QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("CPRB03")%>'/>
	<tiles:put name='action' value='CPRB03F'/>
	<tiles:put name='form' value='/CPR/CPRB0301QForm.jsp'/>
	<tiles:put name='bar' value='/CPR/CPRB0301QBar.jsp'/>
</tiles:insert>
