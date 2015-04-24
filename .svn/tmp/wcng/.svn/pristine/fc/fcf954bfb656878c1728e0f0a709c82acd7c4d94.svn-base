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
	<bean:define id="debtMain" name="Aima0302MForm" property='debtMain' type="tw.gov.nta.sql.debt.DebtMain"/>
		<tr>
			<td width="15%" class='table_item'>公債名稱：</td>
			<td width="35%" class='table_td'><bean:write name='Aima0302MForm' property='debtName'/></td>
			<td width="15%" class='table_item'>公債代號：</td>
			<td width="35%" class='table_td'><bean:write name='Aima0302MForm' property='issueSerial'/></td>
        </tr>
        <tr>
			<td width="15%" class='table_item'>發行日期：</td>
			<td width="35%" class='table_td'><bean:write name='Aima0302MForm' property='DateFormat(issueDate)' /></td>
			<td width="15%" class='table_item'>發行金額：</td>
			<td width="35%" class='table_td'><bean:write name='Aima0302MForm' property='BigDecimal(issueAmount)' format="#,###"/>元</td>
        </tr>
        <tr>
			<td width="15%" class='table_item'>*預算別：</td>
			<td width="35%" class='table_td'><%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode",String.valueOf(debtMain.getBudgetCode()),"","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%></td>
			<td width="15%" class='table_item'>*債務別：</td>
			<td width="35%" class='table_td'><%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(),"debtCode",String.valueOf(debtMain.getDebtCode()),false)%></td>
        </tr>
        <tr>
			<td class='table_item'>*發行額：</td>
			<td class='table_td'><html:text name='Aima0302MForm' property='BigDecimal(issueAmountx)' size='20' maxlength='20'/>元</td>
        </tr>
</table>
<html:hidden name='Aima0302MForm' property='issueMainId' />
<html:hidden name='Aima0302MForm' property='debtId' />