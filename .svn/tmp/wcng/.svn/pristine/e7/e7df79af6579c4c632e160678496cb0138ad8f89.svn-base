<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<%tw.gov.nta.sql.debt.IssueMain sourceIssueMain = (tw.gov.nta.sql.debt.IssueMain)request.getAttribute("sourceIssueMain"); %>
<bean:define id="issueMain" name="Aima0201MForm" property='issueMain' type="tw.gov.nta.sql.debt.IssueMain"/>
<html:hidden name='Aima0201MForm' property='issueMainId' />
<html:hidden name='Aima0201MForm' property='Date(issueDate)'/>
<html:hidden name='Aima0201MForm' property='budgetCode' value='0'/>
<html:hidden name='Aima0201MForm' property='debtCode' value='0'/>
<html:hidden name='Aima0201MForm' property='issueInterval'/>
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='20%'>原始發行公債名稱</td>
		<td class='table_td'><%= sourceIssueMain.getDebtName()%>&nbsp;</td>
		<td class='table_item'><font color="#ff0000">*</font>增額發行日期</td>
		<td class='table_td' colspan="3">
			<html:text name='Aima0201MForm' property='Date(issueDate)' size='7' maxlength='7' onblur="doAction('AIMA0200M');"/>
			<a href="javascript: myCalendar.setCallBackObj('Date(issueDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/></a>
		</td>
	</tr>
	<tr>
		<td class='table_item' width='20%'><font color="#ff0000">*</font>會計年度</td>
		<td class='table_td'><html:text name='Aima0201MForm' property='accountYear' size='5' maxlength='4'/></td>
		<td class='table_item'><font color="#ff0000">*</font>期限</td>
		<td class='table_td' colspan="3"><bean:write name='Aima0201MForm' property='issueInterval'/>年&nbsp;</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>公債期次</td>
		<td class='table_td'><bean:write name='Aima0201MForm' property='serialNo'/>&nbsp;</td>
		<td class='table_item'><font color="#ff0000">*</font>期滿開付日</td>
		<td class='table_td' colspan="3">
			<bean:write name='Aima0201MForm' property='dateFormat(finishDate)'/>&nbsp;
		</td>
	</tr>
	<tr>
		<td class='table_item' width='20%'><font color="#ff0000">*</font>增額公債代號</td>
		<td class='table_td'><html:text name='Aima0201MForm' property='issueSerial' size='10' maxlength='10'/></td>
		<td class='table_item'><font color="#ff0000">*</font>到期日期</td>
		<td class='table_td' colspan="3">
			<bean:write name='Aima0201MForm' property='dateFormat(dueDate)'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>增額公債識別碼</td>
		<td class='table_td'>		
			<bean:define id='bondType' name='Aima0201MForm' property='bondType' type='java.lang.String'/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("BT"),"bondType",bondType,"",10, false)%>&nbsp;
		</td>
		<td class='table_item'><font color="#ff0000">*</font>有效兌付期限</td>
		<td class='table_td' colspan="3"><html:text name='Aima0201MForm' property='payLimit' value='5' size='3' maxlength='2'/>年&nbsp;</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>增額公債名稱</td>
		<td class='table_td'>
			<html:text name='Aima0201MForm' property='debtName' size='60' maxlength='120'/>
		</td>
		<td class='table_item'>截止兌付日期</td>
		<td class='table_td' colspan="3">
			<bean:write name='Aima0201MForm' property='dateFormat(cashDueDate)'/>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>增額公債形式</td>
		<td class='table_td'>
			<bean:define id='issueKind' name='Aima0201MForm' property='issueKind' type='java.lang.String'/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("IK"),"issueKind",issueKind,"",10, false)%>
		</td>
		<td class='table_item'><font color="#ff0000">*</font>票面利率</td>
		<td class='table_td' colspan="3">年息<bean:write name='Aima0201MForm' property='averageRate' format='##0.000'/>％&nbsp;</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>可分割公債</td>
		<td class='table_td'>
			<html:select name='Aima0201MForm' property='bondSellStatus'>
				<html:option value='Y'>是</html:option>
				<html:option value='N'>否</html:option>
			</html:select>
		</td>
		<td class='table_item'><font color="#ff0000">*</font>利率變動別</td>
		<td class='table_td' colspan="3">
			<bean:define id='rateKind' name='Aima0201MForm' property='rateKind' type='java.lang.String'/>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("RK"),"rateKind",rateKind,"",10, false)%>&nbsp;
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>發行額</td>
		<td class='table_td'><html:text name='Aima0201MForm' property='BigDecimal(issueAmount)' size='20' maxlength='25' onblur="doAction('AIMA0200M');"/>元</td>
		<td class='table_item' width='20%'>與原始公債發行日期相距</td>
		<td class='table_td' colspan="3">
			<div id='diff'>
			<logic:notEmpty name='Aima0201MForm' property='diffOriginDay'>
				<bean:write name='Aima0201MForm' property='diffOriginDay'/>日
			</logic:notEmpty>
			</div>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>實收數</td>
		<td class='table_td'><html:text name='Aima0201MForm' property='BigDecimal(realAmount)' size='20' maxlength='20' />元</td>
		<td class='table_item' width='20%'>應計利息</td>
		<td class='table_td' colspan="3">
			<logic:notEmpty name='Aima0201MForm' property='repayInterestAmount'>
				<bean:define id="repayInterestAmount" name='Aima0201MForm' property='repayInterestAmount' type="java.lang.String"/>
					<% 
					  java.math.BigDecimal Interest =new java.math.BigDecimal(Double.parseDouble(repayInterestAmount));
					%>
				<%=new java.text.DecimalFormat("#,##0").format(Interest)%>元	
			</logic:notEmpty>
			<logic:empty name='Aima0201MForm' property='repayInterestAmount'>
					<%=0%>元
			</logic:empty>
		</td>
	</tr>
	<tr>
	<tr>
		<td class='table_item'>首次付息日期</td>
		<td class='table_td'>
			<html:text name='Aima0201MForm' property='date(firstInterestDate)' size='10'/>
		</td>
		<td class='table_item'>付息次數</td>
		<td class='table_td'><html:text name='Aima0201MForm' property='interestAlternate' size='5' onblur="count(form)"/>&nbsp;</td>
		<td class='table_item'>付息間距</td>
		<td class='table_td' id="repayInterestInterval"><bean:write name='Aima0201MForm' property='repayInterestInterval'/>月&nbsp;</td>
	</tr>
	<tr>
		<td class='table_item'>首次還本日期</td>
		<td class='table_td' width='15%'>
			<html:text name='Aima0201MForm' property='date(firstRepayDate)' size='10'/>
		</td>
		<td class='table_item'>還本次數</td>
		<td class='table_td' width='15%'><html:text name='Aima0201MForm' property='repayAlternate' size='5' onblur="count(form)"/>&nbsp;</td>
		<td class='table_item'>還本間距</td>
		<td class='table_td' width='15%' id="repayCapitalInterval"><bean:write name='Aima0201MForm' property='repayCapitalInterval'/>月&nbsp;</td>
	</tr>
</table>