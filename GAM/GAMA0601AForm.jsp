<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color='red'>*</font>期別</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(gov.dnt.tame.util.ListToolManager.getList("select id, debtName from IssueMain where debtType='E' "),"issueId","",10, false)%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>還本日期</td>
		<td class='table_td'>
			<html:text name='Gama0601Form' property='date(repayDate)' size='20' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("date(repayDate)",new Integer(0))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>還本金額</td>
		<td class='table_td'>
			<html:text name='Gama0601Form' property='bigDecimal(capitalAmount)' size='20' maxlength='20'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>還本期數</td>
		<td class='table_td'>
			<html:text name='Gama0601Form' property='capitalSerial' size='20' maxlength='20'/>
		</td>
	</tr>
</table>