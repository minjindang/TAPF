<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<html:hidden name='Aima0101MForm' property='chargeRate' />
<html:hidden name='Aima0101MForm' property='issueMainId' />
<html:hidden name='Aima0101MForm' property='sourceIssueId' />
<html:hidden name='Aima0101MForm' property='issueSerial' />
<html:hidden name='Aima0101MForm' property='budgetCode' value='0'/>
<html:hidden name='Aima0101MForm' property='debtCode' value='0'/>
<input type='hidden' name='mod' value='true'>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item'><font color="red">*</font>會計年度</td>
		<td class='table_td'><html:text name='Aima0101MForm' property='accountYear' size='3' maxlength='3' onblur="doAction('AIMA0100M');"/></td>
		<td class='table_item'><font color="red">*</font>發行日期：</td>
		<td class='table_td' colspan="3">
			<html:text name='Aima0101MForm' property='Date(issueDate)' size='7' maxlength='7' onblur="doAction('AIMA0100M');" />
			<a href="javascript: myCalendar.setCallBackObj('Date(issueDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/></a>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>公債期次</td>
        <td class='table_td' ><html:text name='Aima0101MForm' property='serialNo' size='15' onblur="doAction('AIMA0100M');"/></td>
		<td class='table_item'><font color="red">*</font>期限</td>
		<td class='table_td' colspan="3"><html:text name='Aima0101MForm' property='issueInterval' size='7' maxlength='3' onblur="count(form);doAction('AIMA0100M');"/>年</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>公債代號</td>
        <td class='table_td' id="issueSerialLabel"><bean:write name='Aima0101MForm' property='issueSerial' /></td>
		<td class='table_item'><font color="red">*</font>期滿開付日</td>
		<td class='table_td' colspan="3">
			<html:text name='Aima0101MForm' property='Date(finishDate)' size='7' maxlength='7' />
			<a href="javascript: myCalendar.setCallBackObj('Date(finishDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/></a>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>公債識別碼</td>
		<td class='table_td'>
		<logic:empty name='Aima0101MForm' property='bondType' >
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("BT"),"bondType","","","doAction('AIMA0100M');",10,false)%>
		</logic:empty>
		<logic:notEmpty name='Aima0101MForm' property='bondType' >
			<bean:define id ='bondType' name='Aima0101MForm' property='bondType' type='java.lang.String'/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("BT"),"bondType",bondType,"","doAction('AIMA0100M');",10,false)%>
		</logic:notEmpty>
		</td>
		<td class='table_item'>到期日</td>
		<td class='table_td' colspan="3">
			<html:text name='Aima0101MForm' property='Date(dueDate)' size='7' maxlength='7' />
			<a href="javascript: myCalendar.setCallBackObj('Date(dueDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/></a>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>公債名稱</td>
		<td class='table_td'><html:text name='Aima0101MForm' property='debtName' size='50' maxlength='80'/></td>
		<td class='table_item'><font color="red">*</font>有效兌付期限</td>
		<td class='table_td' colspan="3"><html:text name='Aima0101MForm' property='payLimit' value='5' size='7' maxlength='2' onblur="doAction('AIMA0100M');"/>年</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>公債型式：</td>
		<td class='table_td'>
			<logic:empty name='Aima0101MForm' property='issueKind' >
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("IK"),"issueKind","","","",10,false)%>
			</logic:empty>
			<logic:notEmpty name='Aima0101MForm' property='issueKind' >
				<bean:define id ='issueKind' name='Aima0101MForm' property='issueKind' type='java.lang.String'/>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("IK"),"issueKind",issueKind,"","",10,false)%>
			</logic:notEmpty>
		</td>
		<td class='table_item'>截止兌付日期</td>
		<td class='table_td' colspan="3"><bean:write name='Aima0101MForm' property='DateFormat(cashDueDate)'/></td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>可分割公債：</td>
		<td class='table_td' >
			<html:select name='Aima0101MForm' property='bondSellStatus'>
				<html:option value="Y">是</html:option>
				<html:option value="N">否</html:option>
			</html:select>
		</td>	
		<td class='table_item'><font color="red">*</font>票面利率</td>
		<td class='table_td' colspan="3">年息<html:text name='Aima0101MForm' property='BigDecimal(averageRate)' size='7' maxlength='13'/>％</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>發行額：</td>
		<td class='table_td'>
			<html:text name='Aima0101MForm' property='BigDecimal(issueAmount)' size='20' maxlength='20' />元
		</td>
		<td class='table_item'><font color="red">*</font>利率變動別</td>
		<td class='table_td' colspan="3">
			<logic:empty name='Aima0101MForm' property='issueKind' >
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("RK"),"rateKind","","","",10,false)%>
			</logic:empty>
			<logic:notEmpty name='Aima0101MForm' property='issueKind' >
				<bean:define id ='rateKind' name='Aima0101MForm' property='rateKind' type='java.lang.String'/>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("RK"),"rateKind",rateKind,"","",10,false)%>
			</logic:notEmpty>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>實收數</td>
		<td class='table_td' colspan="5"><html:text name='Aima0101MForm' property='BigDecimal(realAmount)' size='20' maxlength='20' />元</td>
	</tr>
	<tr>
		<td class='table_item'><font color="red">*</font>首次付息日期</td>
		<td class='table_td'>
			<html:text name='Aima0101MForm' property='Date(firstInterestDate)' size='7' maxlength='7'/>
			<a href="javascript: myCalendar.setCallBackObj('Date(firstInterestDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/></a>
		</td>
		<td class='table_item'><font color="red">*</font>付息次數</td>
		<td class='table_td'><html:text name='Aima0101MForm' property='interestAlternate' size='7' maxlength='3' onblur="count(form)"/></td>
		<td class='table_item'>付息間距</td>
		<td class='table_td' id="repayInterestInterval"><bean:write name='Aima0101MForm' property='repayInterestInterval'/>月</td>
	</tr>
	<tr>		
		<td class='table_item'><font color="red">*</font>首次還本日期</td>
		<td class='table_td' width='15%'>
			<html:text name='Aima0101MForm' property='Date(firstRepayDate)' size='7' maxlength='7'/>
			<a href="javascript: myCalendar.setCallBackObj('Date(firstRepayDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/></a>
		</td>
		<td class='table_item'><font color="red">*</font>還本次數</td>
		<td class='table_td' width='15%'><html:text name='Aima0101MForm' property='repayAlternate'  size='7' maxlength='3' onblur="count(form)"/></td>
		<td class='table_item'>還本間距</td>
		<td class='table_td' id="repayCapitalInterval" width='15%'><bean:write name='Aima0101MForm' property='repayCapitalInterval'/>月</td>
	</tr>
</table>