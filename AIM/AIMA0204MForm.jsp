<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<html:hidden name='Aima0204MForm' property='issueMainId' />
<html:hidden name='Aima0204MForm' property='debtRateDetId' />
<html:hidden name='Aima0204MForm' property='groupId' />
<html:hidden name='Aima0204MForm' property='deleteMark' />
<html:hidden name='Aima0204MForm' property='seqNo' />
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'>���ťN���G</td>
		<td class='table_td'><bean:write name='Aima0204MForm' property='issueSerial'/></td>
	</tr>
    <tr>
		<td class='table_item'>�o�����G</td>
		<td class='table_td'><bean:write name='Aima0204MForm' property='DateFormat(issueDate)'/></td>
   	</tr>
    <tr>
		<td class='table_item'>�o����B�G</td>
		<td class='table_td'><bean:write name='Aima0204MForm' property='BigDecimal(issueAmount)' format="#,###"/>��</td>
    </tr>
    <tr>
		<td class='table_item'>���ŦW�١G</td>
		<td class='table_td'><bean:write name='Aima0204MForm' property='debtName'/></td>
    </tr>
    <tr>
		<td class='table_item'>��I����G</td>
		<td colspan="3" class='table_td'>
			<html:text name='Aima0204MForm' property='Date(effectiveDate)' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(effectiveDate)",new Integer(0))%>
			~
			<html:text name='Aima0204MForm' property='Date(suspendDate)' onblur=''/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(suspendDate)",new Integer(1))%>
		</td>
	</tr>
	<tr>
		<td class='table_item'>�Q�v�G</td>
		<td class='table_td'><html:text name='Aima0204MForm' property='BigDecimal(debtRate)' />�H</td>
    </tr>
</table>