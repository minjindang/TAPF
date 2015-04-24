<!--
程式目的：歷年國庫券發行資料彙總表
程式代號：BIRA05
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
		<td class='table_item'>報表類型</td>
		<td class='table_td'>
			<!-- 連動方法說明: getDebtCode(this.form.budgetCode.value,'debtCode') 
				參數1預算別的值,參數2為債務別選單的名稱
			-->
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode","","","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>債務別</td>
		<td class='table_td'>
		<!-- 讓service去撈沒用的資料 -->
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(1),"debtCode","",false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行日期</td>
		<td class='table_td'>
			<html:text name='Bira0501Form' property='date(issueSdate)' size='7' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(issueSdate)", new Integer(0))%>
			 ~ 
			<html:text name='Bira0501Form' property='date(issueEdate)' size='7' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(issueEdate)", new Integer(1))%>
		</td>
	</tr>
</table>