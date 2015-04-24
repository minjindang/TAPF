<!--
程式目的：年度還本明細表
程式代號：AIRB08
程式日期：0950227
程式作者：JackDu
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color='red'>*</font>還本到期年度:</td>
		<td class='table_td'>
			<html:text name='Airb0801Form' property='repaydate' size='3' maxlength='3'/>
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
		<td class='table_item'>公債種類</td>
		<td class='table_td'>
			<select name='kind'>
				<option value="">請選擇</option>
				<option value="Y">可分割公債</option>
				<option value="N">交換公債</option>
			</select>
		</td>
	</tr>
</table>