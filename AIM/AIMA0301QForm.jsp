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
		<tr>
			<td width="394" class='table_item'>公債代號：</td>
			<td width="394" class='table_td'><html:text name='Aima0301QForm' property='qryIssueSerial' size='15' maxlength='12'/></td>
		</tr>
        <tr>
			<td width="394" class='table_item'>預算別：</td>
			<td width="394" class='table_td'><%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.BudgetCodeManager.getBudgetInfo(),"budgetCode",null,"","getDebtCode(this.form.budgetCode.value,'debtCode')",10,false)%></td>
        </tr>
        <tr>
			<td width="394" class='table_item'>債務別：</td>
			<td width="394" class='table_td'><%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.DebitCodeManage.getDebitInfo(),"debtCode",null,false)%></td>
        </tr>
        <tr>
			<td width="394" class='table_item'>交換標的：</td>
			<td width="394" class='table_td'><%=gov.dnt.tame.util.CombinText.getAutoComCodeListWithSpaceBySql(tw.gov.nta.system.common.ExstockCodeManage.getExstockInfo(),"qryExchangeStockCode","" ,10, false)%>
          </td>
        </tr>
        <tr>
			<td width="394" class='table_item'>發行日期：</td>
			<td width="394" class='table_td'>
				<html:text name='Aima0301QForm' property='Date(qryIssueDateStart)' size='7' maxlength='7'/>
				<a href="javascript: myCalendar.setCallBackObj('Date(qryIssueDateStart)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/></a>
				~
				<html:text name='Aima0301QForm' property='Date(qryIssueDateEnd)' size='7' maxlength='7'/>
				<a href="javascript: myCalendar.setCallBackObj('Date(qryIssueDateEnd)');myCalendar.show();"><img src="/tapf/assets/images/calendar/dynCalendar.gif" border="0" align="absmiddle" width="16" height="16" title="選擇日期"/></a>
			</td>
        </tr>
</table>
