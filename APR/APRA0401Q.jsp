<!--
程式目的：核撥公債本息基金明細表(依基金預算-交建)
程式代號：APRA04
程式日期：0950308
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/APR/APRA0401QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("APRA04")%>'/>
	<tiles:put name='action' value='APRA04F'/>
	<tiles:put name='form' value='/APR/APRA0401QForm.jsp'/>
	<tiles:put name='bar' value='/APR/APRA0401QBar.jsp'/>
</tiles:insert>
