<!--
程式目的：中央政府交換公債交換月報總表
程式代號：AIRC09
程式日期：0950308
程式作者：ERIC CHEN
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/AIR/AIRB1101QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIRB11")%>'/>
	<tiles:put name='action' value='AIRB11F'/>
	<tiles:put name='form' value='/AIR/AIRB1101QForm.jsp'/>
	<tiles:put name='bar' value='/AIR/AIRB1101QBar.jsp'/>
</tiles:insert>
