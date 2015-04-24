<!--
程式目的：中長借應付借款報表列印
程式代號：ECRE05
程式日期：0950604
程式作者：Avery
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/ECR/ECRE0501QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("ECRE05") %>'/>
	<tiles:put name='action' value='ECRE0501'/>
	<tiles:put name='form' value='/ECR/ECRE0501QForm.jsp'/>
	<tiles:put name='bar' value='/ECR/ECRE0501QBar.jsp'/>
</tiles:insert>