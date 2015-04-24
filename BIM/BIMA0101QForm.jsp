<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>發行年度:</td>
		<td class='table_td'>
			<html:text name='Bima0101Form' property='qryaccountYear' size='10'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>預算別</td>
		<td class='table_td'>
			<!-- 連動方法說明: getDebtCode(this.form.budgetCode.value,'debtCode') 
				參數1預算別的值,參數2為債務別選單的名稱
			-->
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"qrybudgetCode","1","","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>債務別</td>
		<td class='table_td'>
		<!-- 讓service去撈沒用的資料 -->
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(1),"qrydebtCode","24",false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>國庫券名稱:</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.debt.common.IssueManager.getDebtNameLabelList("B"),"qrydebtName",10, false)%>
		</td>
	</tr>
</table>
