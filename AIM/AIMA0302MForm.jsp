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
	<bean:define id="debtMain" name="Aima0302MForm" property='debtMain' type="tw.gov.nta.sql.debt.DebtMain"/>
		<tr>
			<td width="15%" class='table_item'>���ŦW�١G</td>
			<td width="35%" class='table_td'><bean:write name='Aima0302MForm' property='debtName'/></td>
			<td width="15%" class='table_item'>���ťN���G</td>
			<td width="35%" class='table_td'><bean:write name='Aima0302MForm' property='issueSerial'/></td>
        </tr>
        <tr>
			<td width="15%" class='table_item'>�o�����G</td>
			<td width="35%" class='table_td'><bean:write name='Aima0302MForm' property='DateFormat(issueDate)' /></td>
			<td width="15%" class='table_item'>�o����B�G</td>
			<td width="35%" class='table_td'><bean:write name='Aima0302MForm' property='BigDecimal(issueAmount)' format="#,###"/>��</td>
        </tr>
        <tr>
			<td width="15%" class='table_item'>*�w��O�G</td>
			<td width="35%" class='table_td'><%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode",String.valueOf(debtMain.getBudgetCode()),"","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%></td>
			<td width="15%" class='table_item'>*�ŰȧO�G</td>
			<td width="35%" class='table_td'><%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(),"debtCode",String.valueOf(debtMain.getDebtCode()),false)%></td>
        </tr>
        <tr>
			<td class='table_item'>*�o���B�G</td>
			<td class='table_td'><html:text name='Aima0302MForm' property='BigDecimal(issueAmountx)' size='20' maxlength='20'/>��</td>
        </tr>
</table>
<html:hidden name='Aima0302MForm' property='issueMainId' />
<html:hidden name='Aima0302MForm' property='debtId' />