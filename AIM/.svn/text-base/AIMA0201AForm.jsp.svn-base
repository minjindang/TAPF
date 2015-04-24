<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<bean:define id="issueMain" name="Aima0201MForm" property='issueMain' type="tw.gov.nta.sql.debt.IssueMain"/>
<html:hidden name='Aima0201MForm' property='budgetCode' value='0'/>
<html:hidden name='Aima0201MForm' property='debtCode' value='0'/>
<html:hidden name='Aima0201MForm' property='issueInterval'/>
<html:hidden name='Aima0201MForm' property='sourceIssueId'/>
<html:hidden name='Aima0201MForm' property='Date(finishDate)'/>
<html:hidden name='Aima0201MForm' property='Date(dueDate)'/>
<html:hidden name='Aima0201MForm' property='serialNo'/>
<html:hidden name='Aima0201MForm' property='accountYear'/>
<html:hidden name='Aima0201MForm' property='payLimit' />
<html:hidden name='Aima0201MForm' property='Date(cashDueDate)' />
<html:hidden name='Aima0201MForm' property='BigDecimal(averageRate)'/>
<html:hidden name='Aima0201MForm' property='date(firstInterestDate)'/>
<html:hidden name='Aima0201MForm' property='interestAlternate'/>
<html:hidden name='Aima0201MForm' property='repayInterestInterval'/>
<html:hidden name='Aima0201MForm' property='date(firstRepayDate)' />
<html:hidden name='Aima0201MForm' property='repayAlternate'/>
<html:hidden name='Aima0201MForm' property='repayCapitalInterval'/>
<html:hidden name='Aima0201MForm' property='BigDecimal(repayInterestAmount)' />
<table class='table_1' width='100%'>
	<tr>
		<td class='table_item' width='20%'><font color="#ff0000">*</font>原始發行公債名稱</td>
		<td class='table_td'>
			<logic:empty name='Aima0201MForm' property='addSourceIssueId'>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(gov.dnt.tame.util.ListToolManager.getList("select id, debtName from IssueMain where debtType='A' and bondKind='1' order by accountYear desc, serialNo desc"),"addSourceIssueId","","","doAction('AIMA0200A');",10, false)%>
			</logic:empty>
			<logic:notEmpty name='Aima0201MForm' property='addSourceIssueId'>
				<bean:define id='addSourceIssueId' name='Aima0201MForm' property='addSourceIssueId' type='java.lang.Integer'/>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(gov.dnt.tame.util.ListToolManager.getList("select id, debtName from IssueMain where debtType='A' and bondKind='1' order by accountYear desc, serialNo desc"),"addSourceIssueId",addSourceIssueId.toString(),"","doAction('AIMA0200A');",10, false)%>
			</logic:notEmpty>
			
		</td>
		<td class='table_item'><font color="#ff0000">*</font>增額發行日期</td>
		<td class='table_td'  colspan="3">
			<html:text name='Aima0201MForm' property='Date(issueDate)' size='7' maxlength='7' onblur="countDay(this.form);doAction('AIMA0200A');"/>
			<%=gov.dnt.tame.util.CommonFun.addCalendar("Date(issueDate)",new Integer(0))%>
		</td>
	</tr>
	<tr>
		<td class='table_item' width='20%'><font color="#ff0000">*</font>會計年度</td>
		<td class='table_td'><bean:write name='Aima0201MForm' property='accountYear'/></td>
		<td class='table_item'><font color="#ff0000">*</font>期限</td>
		<td class='table_td'  colspan="3"><bean:write name='Aima0201MForm' property='issueInterval'/>年&nbsp;</td>
	</tr>
	<tr>	
		<td class='table_item'><font color="#ff0000">*</font>公債期次</td>
		<td class='table_td'><bean:write name='Aima0201MForm' property='serialNo'/>&nbsp;</td>
		<td class='table_item'><font color="#ff0000">*</font>期滿開付日</td>
		<td class='table_td'  colspan="3">
			<bean:write name='Aima0201MForm' property='dateFormat(finishDate)'/>&nbsp;
		</td>
	</tr>
	<tr>	
		<td class='table_item' width='20%'><font color="#ff0000">*</font>增額公債代號</td>
		<td class='table_td'><html:text name='Aima0201MForm' property='issueSerial' size='10' maxlength='10'/></td>
		<td class='table_item'><font color="#ff0000">*</font>到期日期</td>
		<td class='table_td'  colspan="3"><bean:write name='Aima0201MForm' property='dateFormat(dueDate)'/>&nbsp;</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>增額公債識別碼</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("BT"),"bondType",issueMain.getBondType(),"","doAction('AIMA0200A');",10, false)%>&nbsp;
		</td>
		<td class='table_item'><font color="#ff0000">*</font>有效兌付期限</td>
		<td class='table_td'  colspan="3"><bean:write name='Aima0201MForm' property='payLimit'/>年&nbsp;</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>增額公債名稱</td>
		<td class='table_td'>
			<html:text name='Aima0201MForm' property='debtName' size='50' maxlength='120' onfocus="if(this.form.issueMainId.value!='null' && this.value==''){this.value='增額發行'+this.form.issueMainId_options.options[this.form.issueMainId_options.selectedIndex].text}"/>
		</td>
		<td class='table_item'>截止兌付日期</td>
		<td class='table_td'  colspan="3"><bean:write name='Aima0201MForm' property='dateFormat(cashDueDate)'/></td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>增額公債形式</td>
		<td class='table_td'>
			<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("IK"),"issueKind",issueMain.getIssueKind(),"",10, false)%>
		</td>
		<td class='table_item'><font color="#ff0000">*</font>票面利率</td>
		<td class='table_td'  colspan="3">年息<bean:write name='Aima0201MForm' property='averageRate' format='###0.000'/>％&nbsp;</td>
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
		<td class='table_td'  colspan="3"><%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("RK"),"rateKind",issueMain.getRateKind(),"",10, false)%>&nbsp;</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>發行額</td>
		<td class='table_td'><html:text name='Aima0201MForm' property='BigDecimal(issueAmount)' size='20' maxlength='25' onblur="doAction('AIMA0200A');"/>元</td>
				<td class='table_item' width='20%'>與原始公債發行日期相距</td>
		<td class='table_td'  colspan="3">
			<div id='diff'>
				<logic:notEmpty name='Aima0201MForm' property='diffOriginDay'>
					<bean:write name='Aima0201MForm' property='diffOriginDay'/>日
				</logic:notEmpty>&nbsp;
			</div>
		</td>
	</tr>
	<tr>
		<td class='table_item'><font color="#ff0000">*</font>實收數</td>
		<td class='table_td'><html:text name='Aima0201MForm' property='BigDecimal(realAmount)' size='20' maxlength='20' />元</td>
		<td class='table_item' width='20%'>應計利息</td>
		<td class='table_td'  colspan="3">
			<bean:write name='Aima0201MForm' property='repayInterestAmount' format='#,###'/>元
		</td>
	</tr>
	<tr>
		<td class='table_item' width='15%'>首次付息日期</td>
		<td class='table_td'>
			<bean:write name='Aima0201MForm' property='dateFormat(firstInterestDate)'/>
		</td>
		<td class='table_item' width='15%'>付息次數</td>
		<td class='table_td'><bean:write name='Aima0201MForm' property='interestAlternate' />次&nbsp;</td>
		<td class='table_item' width='15%'>付息間距</td>
		<td class='table_td' id="repayInterestInterval"><bean:write name='Aima0201MForm' property='repayInterestInterval'/>月&nbsp;</td>
	</tr>
	<tr>
		<td class='table_item'>首次還本日期</td>
		<td class='table_td'  width='15%'>
			<bean:write name='Aima0201MForm' property='dateFormat(firstRepayDate)' />&nbsp;
		</td>
		<td class='table_item'>還本次數</td>
		<td class='table_td'  width='15%'><bean:write name='Aima0201MForm' property='repayAlternate' />次&nbsp;</td>
		<td class='table_item'>還本間距</td>
		<td class='table_td' id="repayCapitalInterval" width='15%'><bean:write name='Aima0201MForm' property='repayCapitalInterval'/>月&nbsp;</td>
	</tr>
</table>
