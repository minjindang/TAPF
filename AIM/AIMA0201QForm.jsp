<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>增額公債代號</td>
		<td class='table_td'>
			<html:text name='Aima0201MForm' property='qryIssueSerial' size='10' maxlength='10'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'>發行日期</td>
		<td class='table_td'>
			<html:text name='Aima0201MForm' property='date(qryIssueDateStart)' size='7' maxlength='7'/>
			<a href="javascript: myCalendar.setCallBackObj('date(qryIssueDateStart)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/></a> ~
			<html:text name='Aima0201MForm' property='date(qryIssueDateEnd)' size='7' maxlength='7'/>
			<a href="javascript: myCalendar.setCallBackObj('date(qryIssueDateEnd)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/></a>
		</td>
	</tr>
</table>
