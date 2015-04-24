<!--	APRA1101Q.jsp
程式目的：APRA1101中央政府登錄公債還本付息結算表列印
程式代號：APRA11
程式日期：0950316
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/APR/APRA1101QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("APRA11")%>'/>
	<tiles:put name='action' value='APRA11F'/>
	<tiles:put name='form' value='/APR/APRA1101QForm.jsp'/>
	<tiles:put name='bar' value='/APR/APRA1101QBar.jsp'/>
</tiles:insert>
