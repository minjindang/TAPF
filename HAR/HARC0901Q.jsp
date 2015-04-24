<!-- HARC1001P.jsp
程式目的：HARC10文字
程式代號：HARC10
程式日期：0950221
程式作者：Andrew Sung
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/HAR/HARC0901QScript.jsp'/>
	<tiles:put name='title' value='<%="專案補助-"+gov.dnt.tame.util.CommonFun.getTitle("HARC09")%>'/>
	<tiles:put name='action' value='HARC0901F'/>
	<tiles:put name='form' value='/HAR/HARC0901QForm.jsp'/>
	<tiles:put name='bar' value='/HAR/HARC0901QBar.jsp'/>
</tiles:insert>
