<!--
程式目的：EAMA02文字
程式代號：EAMA02
程式日期：0950301
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/EAM/EAMB0303AScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("EAMB03")%>'/>
	<tiles:put name='action' value='EAMB0303F'/>
	<tiles:put name='form' value='/EAM/EAMB0303AForm.jsp'/>
	<tiles:put name='bar' value='/EAM/EAMB0303ABar.jsp'/>
</tiles:insert>
