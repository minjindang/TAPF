<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<html:hidden name='Aima0202MForm' property='issueMainId' />
<table class='table_1' width='100%'>
	<tr>
		<td>公債代號</td>
		<td>
			<bean:write name='Aima0202MForm' property='issueSerial'/>
		</td>
		
		<td>增額發行金額</td>
		<td>
			<bean:write name='Aima0202MForm' property='issueAmount' format='#,##0'/>元
		</td>
		<td>應付利息</td>
		<td>
			<bean:write name='Aima0202MForm' property='repayInterestAmount' format='#,##0'/>元
		</td>
	</tr>
	<tr>
		<td colspan='8'>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="預算別">
				<bean:define id="debtId" name="row" property="id" type="java.lang.Integer"/>
				<bean:define id="issueMainId" name="Aima0202MForm" property="issueMainId" type="java.lang.Integer"/>
				<%
					String	myLink	=	"AIMA0213?";
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
					<p align="right"><bean:write name='row' property='issueAmount' format='#,##0'/>元</p>
					<bean:define id="issueAmount" name="row" property="issueAmount" type="java.math.BigDecimal" />
					<% 
						if(1==row_rowNum.intValue())
						{
							request.getSession().setAttribute("sumIssueAmount",null);
						}
						java.math.BigDecimal sumIssueAmount = (java.math.BigDecimal)request.getSession().getAttribute("sumIssueAmount");
						if(null == sumIssueAmount)
						{
							sumIssueAmount = issueAmount;
						}
						else
						{
							sumIssueAmount = sumIssueAmount.add(issueAmount);
						}
						request.getSession().setAttribute("sumIssueAmount",sumIssueAmount);
					%>
				</display:column>
				<display:column title="實收額">
					<p align="right"><bean:write name='row' property='realAmount' format='#,##0'/>元</p>
					<bean:define id="realAmount" name="row" property="realAmount" type="java.math.BigDecimal" />
					<% 
						if(1==row_rowNum.intValue())
						{
							request.getSession().setAttribute("sumRealAmount",null);
						}
						java.math.BigDecimal sumRealAmount = (java.math.BigDecimal)request.getSession().getAttribute("sumRealAmount");
						if(null == sumRealAmount)
						{
							sumRealAmount = realAmount;
						}
						else
						{
							sumRealAmount = sumRealAmount.add(realAmount);
						}
						request.getSession().setAttribute("sumRealAmount",sumRealAmount);
					%>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
