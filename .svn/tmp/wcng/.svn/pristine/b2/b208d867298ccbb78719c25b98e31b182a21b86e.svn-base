<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<html:hidden name='Aima0104MForm' property='issueMainId' />
<html:hidden name='Aima0104MForm' property='debtRateDetId' />
<html:hidden name='Aima0104MForm' property='groupId' />
<html:hidden name='Aima0104MForm' property='deleteMark' />
<html:hidden name='Aima0104MForm' property='seqNo' />
<table class='table_1' width='100%'>
	<tr>
		<td width="15%" class='table_item'>公債名稱：</td>
		<td width="35%" class='table_td'><bean:write name='Aima0104MForm' property='debtName'/></td>
		<td width="15%" class='table_item'>公債代號：</td>
		<td width="35%" class='table_td'><bean:write name='Aima0104MForm' property='issueSerial'/></td>
    </tr>
    <tr>
		<td width="15%" class='table_item'>發行金額：</td>
		<td width="35%" class='table_td'><bean:write name='Aima0104MForm' property='BigDecimal(issueAmount)' format='#,###'/>元</td>
		<td width="15%" class='table_item'>發行日期：</td>
		<td width="35%" class='table_td'><bean:write name='Aima0104MForm' property='DateFormat(issueDate)'/></td>
    </tr>
    <tr>
		<td class='table_item'>利率：</td>
		<td colspan="3" class='table_td'><html:text name='Aima0104MForm' property='BigDecimal(debtRate)' />％</td>
	<tr>
	</tr>
		<td class='table_item'>實施日期：</td>
		<td colspan="3" class='table_td'>
			<html:text name='Aima0104MForm' property='Date(effectiveDate)' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(effectiveDate)",new Integer(0))%>
			~
			<html:text name='Aima0104MForm' property='Date(suspendDate)' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(suspendDate)",new Integer(1))%>
		</td>
    </tr>
</table>