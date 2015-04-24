<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<html:hidden name='Aima0204MForm' property='issueMainId' />
<html:hidden name='Aima0204MForm' property='debtRateDetId' />
<html:hidden name='Aima0204MForm' property='groupId' />
<html:hidden name='Aima0204MForm' property='deleteMark' />
<html:hidden name='Aima0204MForm' property='seqNo' />
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>公債代號：</td>
		<td class='table_td'><bean:write name='Aima0204MForm' property='issueSerial'/></td>
	</tr>
    <tr>
		<td class='table_item'>發行日期：</td>
		<td class='table_td'><bean:write name='Aima0204MForm' property='DateFormat(issueDate)'/></td>
   	</tr>
    <tr>
		<td class='table_item'>發行金額：</td>
		<td class='table_td'><bean:write name='Aima0204MForm' property='BigDecimal(issueAmount)' format="#,###"/>元</td>
    </tr>
    <tr>
		<td class='table_item'>公債名稱：</td>
		<td class='table_td'><bean:write name='Aima0204MForm' property='debtName'/></td>
    </tr>
    <tr>
		<td class='table_item'>實施日期：</td>
		<td colspan="3" class='table_td'>
			<html:text name='Aima0204MForm' property='Date(effectiveDate)' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(effectiveDate)",new Integer(0))%>
			~
			<html:text name='Aima0204MForm' property='Date(suspendDate)' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(suspendDate)",new Integer(1))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>利率：</td>
		<td class='table_td'><html:text name='Aima0204MForm' property='BigDecimal(debtRate)' />％</td>
    </tr>
</table>