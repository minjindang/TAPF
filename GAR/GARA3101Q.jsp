<!--	GARA3101Q.jsp
程式目的：GARA3101
程式代號：GARA3101
程式日期：0950316
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/GAR/GARA3101QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GARA31")%>'/>
	<tiles:put name='action' value='GARA31F'/>
	<tiles:put name='form' value='/GAR/GARA3101QForm.jsp'/>
	<tiles:put name='bar' value='/GAR/GARA3101QBar.jsp'/>
</tiles:insert>
