<!--	GARA1401Q.jsp
程式目的：GARA1401
程式代號：GARA1401
程式日期：0950316
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/GAR/GARA1401QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("GARA14")%>'/>
	<tiles:put name='action' value='GARA14F'/>
	<tiles:put name='form' value='/GAR/GARA1401QForm.jsp'/>
	<tiles:put name='bar' value='/GAR/GARA1401QBar.jsp'/>
</tiles:insert>
