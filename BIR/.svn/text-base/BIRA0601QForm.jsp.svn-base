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
		<td class='table_item'>發行年度</td>
		<td class='table_td'>
			<html:text name='Bira0601Form' property='accountSYear' size='4' maxlength='3'/>
			 ~ 
			<html:text name='Bira0601Form' property='accountEYear' size='4' maxlength='3'/>
		</td>
	</tr>
</table>