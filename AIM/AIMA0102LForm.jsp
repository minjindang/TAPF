<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<html:hidden name='Aima0102MForm' property='issueMainId' />
<table class='table_1' width='100%'>
	<tr>
		<td>公債代號</td>
		<td>
			<bean:write name='Aima0102MForm' property='issueSerial'/>
		</td>
		<td>發行日期</td>
		<td>
			<bean:write name='Aima0102MForm' property='DateFormat(issueDate)'/>
		</td>
		<td>發行金額</td>
		<td>
			<bean:write name='Aima0102MForm' property='issueAmount' format='#,###'/> 元
		</td>
	</tr>
	<tr>
		<td colspan='6'>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="預算別">
				<bean:define id="debtId" name="row" property="id" type="java.lang.Integer"/>
				<bean:define id="issueMainId" name="Aima0102MForm" property="issueMainId" type="java.lang.Integer"/>
				<%
					String	myLink	=	"AIMA0113?";
					myLink	+= "debtId=" + debtId;
					myLink	+= "&issueMainId=" + issueMainId;
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
					<div align="right"><bean:write name='row' property='issueAmount' format='#,###'/> 元</div>
				</display:column>
				<display:column title="實收額">
					<div align="right"><bean:write name='row' property='realAmount' format='#,##0'/> 元</div>
				</display:column>
			</display:table>
		</td>
	</tr>
	<html:hidden name='Aima0102MForm' property='issueMainId' />
</table>
