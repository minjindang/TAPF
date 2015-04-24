<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<html:hidden name='Aima0202MForm' property='issueMainId' />
<html:hidden name='Aima0202MForm' property='debtId' />
<table class='table_1' width='100%'>
	<bean:define id="debtMain" name="Aima0202MForm" property='debtMain' type="tw.gov.nta.sql.debt.DebtMain"/>
	<tr>
		<td width="15%" class='table_item'>公債代號：</td>
		<td width="30%" class='table_td'><bean:write name='Aima0202MForm' property='issueSerial'/></td>
		<td width="15%" class='table_item'>發行日期：</td>
		<td width="30%" class='table_td'><bean:write name='Aima0202MForm' property='DateFormat(issueDate)'/></td>
    </tr>
    <tr>
		<td width="15%" class='table_item'>發行金額：</td>
		<td width="30%" class='table_td'><bean:write name='Aima0202MForm' property='BigDecimal(issueAmount)' format="#,###"/>元</td>
		<td width="15%" class='table_item'>公債名稱：</td>
		<td width="30%" class='table_td'><bean:write name='Aima0202MForm' property='debtName'/></td>
    </tr>
    <tr>
		<td width="15%" class='table_item'><font color="red">*</font>預算別：</td>
		<td width="30%" class='table_td'><%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode",String.valueOf(debtMain.getBudgetCode()),"","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%></td>
		<td width="15%" class='table_item'><font color="red">*</font>債務別：</td>
		<td width="30%" class='table_td'>
			<logic:empty name='Aima0202MForm' property='budgetCode'>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(new Integer(1)),"debtCode",String.valueOf(debtMain.getDebtCode()),false)%>
			</logic:empty>
			<logic:notEmpty name='Aima0202MForm' property='budgetCode'>
				<bean:define id='budgetCode' name="Aima0202MForm" property='budgetCode' type='java.lang.Integer'/>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(budgetCode),"debtCode",String.valueOf(debtMain.getDebtCode()),false)%>
			</logic:notEmpty>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>發行額：</td>
		<td class='table_td'><html:text name='Aima0202MForm' property='BigDecimal(issueAmountx)' size='20' maxlength='20' onblur='total(this.form)'/>元</td>
     		<td class='table_item'><font color="red">*</font>實收額：</td>
		<td class='table_td'><html:text name='Aima0202MForm' property='BigDecimal(realAmount)' size='20' maxlength='20' onblur='checkAmount(this.form)'/>元</td>
    </tr>
    <tr>
    	<td class='table_item'><font color="red">*</font>溢(折)價金額：</td>
    	<td class='table_td'><html:text name='Aima0202MForm' property='BigDecimal(diversityAmount)' size='20' maxlength='20' onblur='total(this.form)'/>元</td>
    	<td class='table_item'>發行成本額</td>
    	<td class='table_td'><html:text name='Aima0202MForm' property='BigDecimal(issueCostAmount)' size='18' maxlength='20'/>元</td>
    </tr>
</table>