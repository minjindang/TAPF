<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color='red'>*</font>還本年度:</td>
		<td class='table_td'>
			<html:text name='Airb0501Form' property='repay_SDate' size='3' maxlength='3'/>~
			<html:text name='Airb0501Form' property='repay_EDate' size='3' maxlength='3'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>預算別</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode","","","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>債務別</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(new Integer(0)),"debtCode",false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>公債類別</td>
		<td class='table_td'>
			<select name="bondSellStatus">
				<option value="">請選擇</option>
				<option value="Y">可分割公債</option>
				<option value="4">交換公債</option>
			</select>
		</td>	
	</tr>
</table>