<!-- 
程式目的：APRA15文字
程式代號：APRA15
程式日期：0950221
程式作者：Andrew Sung
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/APR/APRA1901QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("APRA19")%>'/>
	<tiles:put name='action' value='APRA1901'/>
	<tiles:put name='form' value='/APR/APRA1901QForm.jsp'/>
	<tiles:put name='bar' value='/APR/APRA1901QBar.jsp'/>
</tiles:insert>
