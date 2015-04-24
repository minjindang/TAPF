<!--	APRA0801Q.jsp
程式目的：APRA08中央政府登錄公債還本付息核結數額表
程式代號：APRA08
程式日期：0950316
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/APR/APRA0801QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("APRA08")%>'/>
	<tiles:put name='action' value='APRA08F'/>
	<tiles:put name='form' value='/APR/APRA0801QForm.jsp'/>
	<tiles:put name='bar' value='/APR/APRA0801QBar.jsp'/>
</tiles:insert>
