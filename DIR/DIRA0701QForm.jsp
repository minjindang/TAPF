<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>�~��</td>
		<td class='table_td' colspan="3">
			<html:text name='Dira0701Form' property='accountYear' size='10' maxlength='3'/><font size='2'>  ��:"095"</font>
			
		</td>
	<tr>
    <!-- tr>
		<td class='table_item'>���O(�_)</td>
		<td class='table_td'>
			<html:text name='Dira0701Form' property='startSerial' size='10' maxlength='10'/><font size='2'>  ��:"01"��"��1"</font>
			
		</td>
		<td class='table_item'>���O(��)</td>
		<td class='table_td' >
			<html:text name='Dira0701Form' property='endSerial' size='10' maxlength='10'/><font size='2'>  ��:"01"��"��1"</font>
			
		</td>
	</tr-->
	<tr>
		<td class='table_item'>�ɴڤ�(�_)</td>
		<td class='table_td'>
			<html:text name='Dira0701Form' property='date(startDate)' size='15' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(startDate)", new Integer(0))%>
		</td>
		<td class='table_item'>�ɴڤ�(��)</td>
		<td class='table_td'>
			<html:text name='Dira0701Form' property='date(endDate)' size='15' maxlength='7' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(endDate)", new Integer(1))%>
		</td>
	<tr>
	<tr>
		<td class='table_item'>�w��O</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode","","","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
		</td>
		<td class='table_item'>�ŰȧO</td>
		<td class='table_td' colspan="3">
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(new Integer(0)),"debtCode",false)%>
		</td>
	<tr>
</table>