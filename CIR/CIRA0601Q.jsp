<!--	CIRA0601QQ.jsp
程式目的：CIRA0601
程式代號：CIRA0601
程式日期：0950316
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/CIR/CIRA0601QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("CIRA06")%>'/>
	<tiles:put name='action' value='CIRA06F'/>
	<tiles:put name='form' value='/CIR/CIRA0601QForm.jsp'/>
	<tiles:put name='bar' value='/CIR/CIRA0601QBar.jsp'/>
</tiles:insert>
