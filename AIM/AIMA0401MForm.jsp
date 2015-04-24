<!--
�{���ت��GAima02��r
�{���N���GAima02
�{������G0950306
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
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
			<td class='table_item'>���ťN���G</td>
			<td class='table_td'><bean:write name='Aima0401MForm' property='issueSerial'/></td>
			<td class='table_item'>�o�����G</td>
			<td class='table_td'><v name='Aima0401MForm' property='Date(issueDate)' /></td>
        </tr>
        <tr>
			<td class='table_item'>�o����B�G</td>
			<td class='table_td'><bean:write name='Aima0401MForm' property='BigDecimal(issueAmount)' />��</td>
			<td class='table_item'>���ŦW�١G</td>
			<td class='table_td'><bean:write name='Aima0401MForm' property='debtName'/></td>
        </tr>
        <tr>
			<td class='table_item'>�w��O�G</td>
			<td class='table_td'>
				<%
				if(debtMain != null && debtMain.getBudgetCode() != null)
					out.print(tw.gov.nta.system.common.BudgetCodeManager.findBudgetName(debtMain.getBudgetCode().intValue()));
				%>
			<bean:write name='Aima0401MForm' property='budgetCode'/>
			</td>
			<td class='table_item'>�ŰȧO�G</td>
			<td class='table_td'>
				<%
				if(debtMain != null && debtMain.getDebtCode() != null)
					out.print(tw.gov.nta.system.common.DebitCodeManage.findDebitName(debtMain.getDebtCode().intValue()));
				%>
			</td>
        </tr>
        <tr>
			<td class='table_item'>�o����B�G</td>
			<td class='table_td'><bean:write name='Aima0401MForm' property='BigDecimal(issueAmount)'/>��</td>
			<td class='table_item'>*�ꦬ�B�G</td>
			<td class='table_td'><html:text name='Aima0401MForm' property='BigDecimal(realAmount)' size='20' maxlength='20'/>��</td>
        </tr>
        <tr>
			<td class='table_item'>�t�����B�G</td>
			<td class='table_td'><bean:write name='Aima0401MForm' property='BigDecimal(diversityAmount)'/>��</td>
        </tr>
</table>
<html:hidden name='Aima0401MForm' property='issueMainId' />
<html:hidden name='Aima0401MForm' property='debtId' />