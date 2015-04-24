<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>期別</td>
		<td class='table_td' colspan="3">
			<html:text name='Gama0801Form' property='issueSerial'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>債務別代碼</td>
		<td class='table_td' colspan="3"> 
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(),"debtCode",false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>期別名稱</td>
		<td class='table_td' colspan="3">
			<html:text name='Gama0801Form' property='debtName' />
		</td>
	</tr>
	<tr>
		<td class='table_item'>年期</td>
		<td class='table_td' colspan="3">
			<html:text name='Gama0801Form' property='years'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行日期</td>
		<td class='table_td' colspan="3">
			<html:text name='Gama0801Form' property='Date(issueDate)' size='7' maxlength='7' onblur="" />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(issueDate)",new Integer(0))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>預計還款日</td>
		<td class='table_td'>
			<html:text name='Gama0801Form' property='Date(repayDate)' size='7' maxlength='7' onblur="" />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(repayDate)",new Integer(1))%>
		</td>
		<td class='table_item'>預計還款金額</td>
		<td class='table_td'>
			<html:text name='Gama0801Form' property='BigDecimal(capitalAmount)' />
		</td>
	</tr>
	<tr>
		<td class='table_item'>還款日</td>
		<td class='table_td'>
			<html:text name='Gama0801Form' property='Date(payDate)' size='7' maxlength='7' onblur="" />
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(payDate)",new Integer(2))%>
		</td>
		<td class='table_item'>還本金額</td>
		<td class='table_td'>
			<html:text name='Gama0801Form' property='BigDecimal(payAmount)' />
		</td>
	</tr>
</table>