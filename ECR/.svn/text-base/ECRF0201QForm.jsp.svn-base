<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>預算別</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode",null,"","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>債務別</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(),"debtCode",false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff000">*</font>查詢日期</td>
		<td class='table_td'>
			<html:text name='Ecrf0201Form' property='date(qryDate)' size='7' maxlength='7'/>
			<a href="javascript: myCalendar.setCallBackObj('date(qryDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/></a>
		</td>
	</tr>
	<tr>
		<td class='table_item'>報表類別</td>
		<td class='table_td'>
			<html:select name='Ecrf0201Form' property='qryType'>
				<option value="1">依預算別、債務別</option>
				<option value="2">依按銀行別</option>
			</html:select>
		</td>
	</tr>
</table>