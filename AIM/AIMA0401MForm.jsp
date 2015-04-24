<!--
程式目的：Aima02文字
程式代號：Aima02
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
<table class='table_1' width='100%'>
	<bean:define id="debtMain" name="Aima0401MForm" property='debtMain' type="tw.gov.nta.sql.debt.DebtMain"/>
		<tr>
			<td class='table_item'>公債代號：</td>
			<td class='table_td'><bean:write name='Aima0401MForm' property='issueSerial'/></td>
			<td class='table_item'>發行日期：</td>
			<td class='table_td'><v name='Aima0401MForm' property='Date(issueDate)' /></td>
        </tr>
        <tr>
			<td class='table_item'>發行金額：</td>
			<td class='table_td'><bean:write name='Aima0401MForm' property='BigDecimal(issueAmount)' />元</td>
			<td class='table_item'>公債名稱：</td>
			<td class='table_td'><bean:write name='Aima0401MForm' property='debtName'/></td>
        </tr>
        <tr>
			<td class='table_item'>預算別：</td>
			<td class='table_td'>
				<%
				if(debtMain != null && debtMain.getBudgetCode() != null)
					out.print(tw.gov.nta.system.common.BudgetCodeManager.findBudgetName(debtMain.getBudgetCode().intValue()));
				%>
			<bean:write name='Aima0401MForm' property='budgetCode'/>
			</td>
			<td class='table_item'>債務別：</td>
			<td class='table_td'>
				<%
				if(debtMain != null && debtMain.getDebtCode() != null)
					out.print(tw.gov.nta.system.common.DebitCodeManage.findDebitName(debtMain.getDebtCode().intValue()));
				%>
			</td>
        </tr>
        <tr>
			<td class='table_item'>發行金額：</td>
			<td class='table_td'><bean:write name='Aima0401MForm' property='BigDecimal(issueAmount)'/>元</td>
			<td class='table_item'>*實收額：</td>
			<td class='table_td'><html:text name='Aima0401MForm' property='BigDecimal(realAmount)' size='20' maxlength='20'/>元</td>
        </tr>
        <tr>
			<td class='table_item'>差價金額：</td>
			<td class='table_td'><bean:write name='Aima0401MForm' property='BigDecimal(diversityAmount)'/>元</td>
        </tr>
</table>
<html:hidden name='Aima0401MForm' property='issueMainId' />
<html:hidden name='Aima0401MForm' property='debtId' />