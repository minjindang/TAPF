<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>債種</td>
		<td class='table_td' colspan="5">
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("DT"),"debtType",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>預算別</td>
		<td class='table_td' colspan="5">
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode","","","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>債務別</td>
		<td class='table_td' colspan="5">
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(0),"debtCode",false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行日期</td>
		<td class='table_td' colspan="5">
			<html:text name='Eard0901Form' property='date(startIssueDate)' size='20' maxlength='7' onblur="getDays(this.form)" />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(startIssueDate)", new Integer(0))%>
			至
			<html:text name='Eard0901Form' property='date(endIssueDate)' size='20' maxlength='7' onblur="getDays(this.form)" />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(endIssueDate)", new Integer(1))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>到期日期</td>
		<td class='table_td' colspan="5">
			<html:text name='Eard0901Form' property='date(startDueDate)' size='20' maxlength='7' onblur="getDays(this.form)" />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(startDueDate)", new Integer(2))%>
			至
			<html:text name='Eard0901Form' property='date(endDueDate)' size='20' maxlength='7' onblur="getDays(this.form)" />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(endDueDate)", new Integer(3))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行年度</td>
		<td class='table_td' colspan="5">
			<html:text name='Eard0901Form' property='accountYear' size='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行期次</td>
		<td class='table_td' colspan="5">
			<html:text name='Eard0901Form' property='issueSeries' size='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>債務名稱</td>
		<td class='table_td' colspan="5">
			<html:text name='Eard0901Form' property='debtName' size='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>報表形式</td>
		<td class='table_td' colspan="5">
			<select name="reportType">
				<option value="1">請選擇</option>
				<option value="1">預算、債務別</option>
				<option value="2">銀行別</option>
			</select>
		</td>
	</tr>
</table>