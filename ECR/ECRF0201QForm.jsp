<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>�w��O</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode",null,"","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�ŰȧO</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(),"debtCode",false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff000">*</font>�d�ߤ��</td>
		<td class='table_td'>
			<html:text name='Ecrf0201Form' property='date(qryDate)' size='7' maxlength='7'/>
			<a href="javascript: myCalendar.setCallBackObj('date(qryDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="��ܤ��"/></a>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�������O</td>
		<td class='table_td'>
			<html:select name='Ecrf0201Form' property='qryType'>
				<option value="1">�̹w��O�B�ŰȧO</option>
				<option value="2">�̫��Ȧ�O</option>
			</html:select>
		</td>
	</tr>
</table>