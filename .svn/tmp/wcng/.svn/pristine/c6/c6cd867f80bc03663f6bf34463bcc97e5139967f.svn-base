<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
    <tr>
		<td class='table_item'>期別(起)</td>
		<td class='table_td'>
			<html:text name='Dira0701Form' property='startSerial' size='10' maxlength='10'/><font size='2'>  例:"095-01"</font>
			
		</td>
		<td class='table_item'>期別(迄)</td>
		<td class='table_td' >
			<html:text name='Dira0701Form' property='endSerial' size='10' maxlength='10'/><font size='2'>  例:"095-09"</font>
			
		</td>
	<tr>
	<tr>
		<td class='table_item'>預算別</td>

		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode","","","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
		</td>
		<td class='table_item'>債務別</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(new Integer(1)),"debtCode",false)%>
		</td>
	<tr>
</table>