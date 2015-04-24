<!--
程式目的：中央政府公債各年度公債本息數額明細表
程式代號：AIRB05
程式日期：0950227
程式作者：icefire
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<tiles:insert definition=".condition.formBaseBody" flush="true">
	<tiles:put name='scripts' value='/AIR/AIRB0501QScript.jsp'/>
	<tiles:put name='title' value='<%=gov.dnt.tame.util.CommonFun.getTitle("AIRB05")%>'/>
	<tiles:put name='action' value='AIRB05F'/>
	<tiles:put name='form' value='/AIR/AIRB0501QForm.jsp'/>
	<tiles:put name='bar' value='/AIR/AIRB0501QBar.jsp'/>
</tiles:insert>