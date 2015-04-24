<!--	APRA0501Q.jsp
程式目的：APRA05中央政府交換公債還本付息資料表
程式代號：APRA05
程式日期：0950316
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/APR/APRA0501QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("APRA05")%>'/>
	<tiles:put name='action' value='APRA05F'/>
	<tiles:put name='form' value='/APR/APRA0501QForm.jsp'/>
	<tiles:put name='bar' value='/APR/APRA0501QBar.jsp'/>
</tiles:insert>
