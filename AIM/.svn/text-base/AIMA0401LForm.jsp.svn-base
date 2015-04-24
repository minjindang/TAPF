<!--
程式目的：AIMA01文字
程式代號：AIMA01
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
		<table width="100%">
		<tr>
			<td width="132" class='table_item'>公債代號：</td>
			<td width="132" class='table_td'><bean:write name='Aima0401QForm' property='issueSerial'/></td>
			<td width="131" class='table_item'>發行日期：</td>
			<td width="131" class='table_td'><bean:write name='Aima0401QForm' property='Date(issueDate)'/></td>
			<td width="131" class='table_item'>發行金額：</td>
			<td width="131" class='table_td'><bean:write name='Aima0401QForm' property='BigDecimal(issueAmount)'/></td>
		</tr>
        <tr>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="預算別">
				<bean:define id="debtId" name="row" property="id" type="java.lang.Integer"/>
				<bean:define id="issueMainId" name="Aima0401QForm" property="issueMainId" type="java.lang.Integer"/>
				
				<%
					String	myLink	=	"AIMA0407?";
					myLink	+= "debtId=" + debtId;
					myLink += "&issueMainId=" + issueMainId;
				%>
				<A href="<%=myLink%>">
					<%
					tw.gov.nta.sql.debt.DebtMain tDebtMain = (tw.gov.nta.sql.debt.DebtMain)row;
					if(tDebtMain != null && tDebtMain.getBudgetCode() != null)
						out.print(tw.gov.nta.system.common.BudgetCodeManager.findBudgetName(tDebtMain.getBudgetCode().intValue()));
					%>
				</A>
				</display:column>
				<display:column title="債務別">
					<%
					tw.gov.nta.sql.debt.DebtMain tDebtMain = (tw.gov.nta.sql.debt.DebtMain)row;
					if(tDebtMain != null && tDebtMain.getDebtCode() != null)
						out.print(tw.gov.nta.system.common.DebitCodeManage.findDebitName(tDebtMain.getDebtCode().intValue()));
					%>
				</display:column>
				<display:column title="發行額">
					<bean:write name='row' property='issueAmount'/>
				</display:column>
				<display:column title="實收額">
					<bean:write name='row' property='realAmount'/>
				</display:column>
				<display:column title="差價金額">
					<bean:write name='row' property='diversityAmount'/>
				</display:column>
			</display:table>
        </tr>
	</tr>
</table>
