<!--
程式目的：Aima02文字
程式代號：Aima02
程式日期：0950306
程式作者：FormBean Generator
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->

<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<table class='table_1' width='100%'>
	<bean:define id="issueExchangeDet" name="Aima0301AForm" property='issueExchangeDet' type="tw.gov.nta.sql.debt.IssueExchangeDet"/>
	<bean:define id="issueMain" name="Aima0301AForm" property='issueMain' type="tw.gov.nta.sql.debt.IssueMain"/>
<tr>
			<td class='table_item'>*公債名稱：</td>
			<td class='table_td'><html:text name='Aima0301AForm' property='debtName' size='17' maxlength='17'/></td>
			<td class='table_item'>*會計年度：</td>
			<td class='table_td'><html:text name='Aima0301AForm' property='accountYear' size='17' maxlength='17' onchange="changeList(this.form)"/></td>
		</tr>
		<tr>
			<td class='table_item'>*公債識別碼：</td>
			<td class='table_td'><%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.CodeDetManage.getCodeDet("BT"),"bondType",issueMain.getBondType(),"",10, false)%></td>
			<td class='table_item'>公債代號：</td>
			<td class='table_td'><bean:write name='Aima0301AForm' property='issueSerial'/></td>
        </tr>
		<tr>			
			<td class='table_item'>*預算別：</td>
			<td class='table_td'>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode",String.valueOf(issueMain.getBudgetCode()),"","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%>
			</td>
			<td class='table_item'>*債務別：</td>
			<td class='table_td'>
				<%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(),"debtCode",String.valueOf(issueMain.getDebtCode()),false)%>
			</td>
		</tr>
        <tr>
			<td class='table_item'>*發行日期：</td>
			<td class='table_td'>
				<html:text name='Aima0301AForm' property='Date(issueDate)' size='10' maxlength='10' onblur="count(form);"/>
				<a href="javascript: myCalendar.setCallBackObj('Date(issueDate)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/></a>
			</td>
			<td class='table_item'>*發行額：</td>
			<td class='table_td'><html:text name='Aima0301AForm' property='BigDecimal(issueAmount)' size='20' maxlength='20' onblur="countMoney(this.form)"/>元</td>
		</tr>
		<tr>
			<td class='table_item'>*期限：</td>
			<td class='table_td'><html:text name='Aima0301AForm' property='issueInterval' size='10' maxlength='10' onblur="count(form);" />年</td>
			<td class='table_item' >到期日：</td>
			<td class='table_td' ><html:text name='Aima0301AForm' property='Date(dueDate)' size='10' maxlength='10' onblur="count2(form);"/></td>
        </tr>
        
        <tr>
			<td class='table_item'>*利率年息：</td>
			<td class='table_td'><html:text name='Aima0301AForm' property='BigDecimal(averageRate)' size='11' />％</td>
			<td class='table_item'>*收回收益率：</td>
			<td class='table_td'><html:text name='Aima0301AForm' property='BigDecimal(backRate)' size='13' />％</td>
		</tr>
		<tr>
			<td class='table_item'>*賣回收益率：</td>
			<td class='table_td'><html:text name='Aima0301AForm' property='BigDecimal(saleRate)' size='13' />％</td>
			<td class='table_item'>*原始交換價格：</td>
			<td class='table_td'><html:text name='Aima0301AForm' property='BigDecimal(originalPrice)' size='11' />元</td>
		</tr>
		<tr>
			<td class='table_item'>*得標價格：</td>
			<td class='table_td'><html:text name='Aima0301AForm' property='BigDecimal(getPrice)' size='13' onblur="countMoney(this.form)" /></td>
			<td class='table_item'>*外資得標上限：</td>
			<td class='table_td'><html:text name='Aima0301AForm' property='BigDecimal(foreignCapital)' size='13' />元</td>
        </tr>
        <tr>
			<td class='table_item'>*交換標的：</td>
			<td class='table_td'><%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.ExstockCodeManage.getExstockInfo(),"exchangeStockCode", String.valueOf(issueExchangeDet.getExchangeStockCode()),"" ,10, false)%></td>
			<td class='table_item'>*服務處理機構</td>
			<td class='table_td'><%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BankCodeManage.getBankInfo(),"bankCode", String.valueOf(issueExchangeDet.getBankCode()),"" ,10, false)%></td>
        </tr>
        <tr>
			<td class='table_item'>截至目前未償本金數：</td>
			<td class='table_td'><bean:write name='Aima0301AForm' property='BigDecimal(lessCapitalAmount)' format="#,###" /></td>
			<td class='table_item'>截至目前已償本金數：</td>
			<td class='table_td'><html:text name='Aima0301AForm' property='BigDecimal(capitalAmount)' size='17' /></td>
        </tr>
        <tr>
			<td class='table_item'>累計交換股數：</td>
			<td class='table_td'><html:text name='Aima0301AForm' property='BigDecimal(exchangeStockAmount)' size='17' /></td>
			<td class='table_item'>累計釋股金額：</td>
			<td class='table_td'><html:text name='Aima0301AForm' property='BigDecimal(liberateStockAmount)' size='17' /></td>
        </tr>
        <tr>
			<td class='table_item'>溢折價金額</td>
			<td class='table_td' colspan="3">
				<html:text name='Aima0301AForm' property='BigDecimal(sellAmount)' size='13' onblur="countMoney(this.form)"/>元
			</td>
        </tr>
        <tr>
			<td class='table_item'>累計不足一股償付金額：</td>
			<td class='table_td'><html:text name='Aima0301AForm' property='BigDecimal(exchangeLessAmount)' size='17' /></td>
			<td class='table_item'>累計交換面額：</td>
			<td class='table_td'><html:text name='Aima0301AForm' property='BigDecimal(exchangeAmount)' size='17' /></td>
        </tr>
</table>
<html:hidden name='Aima0301AForm' property='issueMainId' />
<html:hidden name='Aima0301AForm' property='issueExchangeId' />