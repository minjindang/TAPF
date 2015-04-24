<!--	CIRA0501QQ.jsp
程式目的：CIRA0501
程式代號：CIRA0501
程式日期：0950316
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/CIR/CIRA0501QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("CIRA05")%>'/>
	<tiles:put name='action' value='CIRA05F'/>
	<tiles:put name='form' value='/CIR/CIRA0501QForm.jsp'/>
	<tiles:put name='bar' value='/CIR/CIRA0501QBar.jsp'/>
</tiles:insert>
