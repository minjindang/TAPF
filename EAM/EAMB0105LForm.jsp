<!--
程式目的：AIMA01文字
程式代號：AIMA01
程式日期：0950306
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<display:table class="table_list" name="Eamb0103Form" property="voucherDets" sort="accountType">
	<display:column title="會計科目" property="accountCode"/>
	<display:column title="金額" property="accountAmount"/>
	<display:column title="借/貸" property="accountType"/>
</display:table>
