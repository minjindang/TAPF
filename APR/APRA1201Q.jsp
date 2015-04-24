<!--	APRA1201Q.jsp
程式目的：APRA1201中央政府登錄公債還本付息結算總表列印
程式代號：APRA12
程式日期：0950316
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/APR/APRA1201QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("APRA12")%>'/>
	<tiles:put name='action' value='APRA12F'/>
	<tiles:put name='form' value='/APR/APRA1201QForm.jsp'/>
	<tiles:put name='bar' value='/APR/APRA1201QBar.jsp'/>
</tiles:insert>
