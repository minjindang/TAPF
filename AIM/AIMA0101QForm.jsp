<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>���ťN��</td>
		<td class='table_td'>
			<html:text name='Aima0101MForm' property='qryIssueSerial' size='10' maxlength='8'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�w��O</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"qryBudgetCode","","","getDebtCode(this.form.qryBudgetCode.value,'qryDebtCode')",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�ŰȧO</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(new Integer(1)),"qryDebtCode",false)%>		
		</td>
	</tr>
	<tr>
		<td class='table_item'>�o����</td>
		<td class='table_td'>
			<html:text name='Aima0101MForm' property='Date(qryIssueDateStart)' size='10' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(qryIssueDateStart)",new Integer(1))%>
			~
			<html:text name='Aima0101MForm' property='Date(qryIssueDateEnd)' size='7' maxlength='7'/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(qryIssueDateEnd)",new Integer(2))%>
		</td>
	</tr>
</table>
