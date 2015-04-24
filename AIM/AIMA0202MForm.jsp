<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<html:hidden name='Aima0202MForm' property='issueMainId' />
<html:hidden name='Aima0202MForm' property='debtId' />
<table class='table_1' width='100%'>
	<bean:define id="debtMain" name="Aima0202MForm" property='debtMain' type="tw.gov.nta.sql.debt.DebtMain"/>
	<tr>
		<td width="15%" class='table_item'>���ťN���G</td>
		<td width="30%" class='table_td'><bean:write name='Aima0202MForm' property='issueSerial'/></td>
		<td width="15%" class='table_item'>�o�����G</td>
		<td width="30%" class='table_td'><bean:write name='Aima0202MForm' property='DateFormat(issueDate)'/></td>
    </tr>
    <tr>
		<td width="15%" class='table_item'>�o����B�G</td>
		<td width="30%" class='table_td'><bean:write name='Aima0202MForm' property='BigDecimal(issueAmount)' format="#,###"/>��</td>
		<td width="15%" class='table_item'>���ŦW�١G</td>
		<td width="30%" class='table_td'><bean:write name='Aima0202MForm' property='debtName'/></td>
    </tr>
    <tr>
		<td width="15%" class='table_item'><font color="red">*</font>�w��O�G</td>
		<td width="30%" class='table_td'><%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode",String.valueOf(debtMain.getBudgetCode()),"","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%></td>
		<td width="15%" class='table_item'><font color="red">*</font>�ŰȧO�G</td>
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
		<td class='table_item'><font color="red">*</font>�o���B�G</td>
		<td class='table_td'><html:text name='Aima0202MForm' property='BigDecimal(issueAmountx)' size='20' maxlength='20' onblur='total(this.form)'/>��</td>
     		<td class='table_item'><font color="red">*</font>�ꦬ�B�G</td>
		<td class='table_td'><html:text name='Aima0202MForm' property='BigDecimal(realAmount)' size='20' maxlength='20' onblur='checkAmount(this.form)'/>��</td>
    </tr>
    <tr>
    	<td class='table_item'><font color="red">*</font>��(��)�����B�G</td>
    	<td class='table_td'><html:text name='Aima0202MForm' property='BigDecimal(diversityAmount)' size='20' maxlength='20' onblur='total(this.form)'/>��</td>
    	<td class='table_item'>�o�榨���B</td>
    	<td class='table_td'><html:text name='Aima0202MForm' property='BigDecimal(issueCostAmount)' size='18' maxlength='20'/>��</td>
    </tr>
</table>