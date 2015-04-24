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
<%@ page import="gov.dnt.tame.util.DateUtil" %>
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="公債代號">
				<bean:define id="issueMain" name="row" property="issue" type="tw.gov.nta.sql.debt.IssueMain"/>
				<bean:define id="issueMainId" name="issueMain" property="id" type="java.lang.Integer"/>
				<bean:define id="issueExchangeDetId" name="row" property="id" type="java.lang.Integer"/>
				<%
					String	myLink	=	"AIMA0305?";
					myLink	+= "issueMainId=" + issueMainId;
					myLink += "&issueExchangeId=" + issueExchangeDetId;
				%>
				<A href="<%=myLink%>">
					<bean:write name='issueMain' property='issueSerial'/>
				</A>
				</display:column>
				<display:column title="發行日期">
					<bean:define id="issueMain" name="row" property="issue" type="tw.gov.nta.sql.debt.IssueMain"/>
					<%
						out.print(DateUtil.date2ROCStr(issueMain.getIssueDate(),"yyy/MM/dd"));
					%>
				</display:column>
				<display:column title="預算別">
					<%
					tw.gov.nta.sql.debt.IssueMain tIssueMain = (tw.gov.nta.sql.debt.IssueMain)((tw.gov.nta.sql.debt.IssueExchangeDet)row).getIssue();
					if(tIssueMain != null && tIssueMain.getBudgetCode() != null)
						out.print(tw.gov.nta.system.common.BudgetCodeManager.findBudgetName(tIssueMain.getBudgetCode().intValue()));
					%>
				</display:column>
				<display:column title="債務別">
					<%
					tw.gov.nta.sql.debt.IssueMain tIssueMain = (tw.gov.nta.sql.debt.IssueMain)((tw.gov.nta.sql.debt.IssueExchangeDet)row).getIssue();
					if(tIssueMain != null && tIssueMain.getDebtCode() != null)
						out.print(tw.gov.nta.system.common.DebitCodeManage.findDebitName(tIssueMain.getDebtCode().intValue()));
					%>
				</display:column>
				<display:column title="交換標的">
					<logic:notEmpty name='row' property='exchangeStockCode'>
						<bean:define id="exchangeStockCode" name='row' property='exchangeStockCode' type="java.lang.Integer"/>
						<%	
							if(null != exchangeStockCode)
							{
								int stockId = exchangeStockCode.intValue();
								out.print((new tw.gov.nta.system.common.ExstockCodeManage().get(stockId)).getStockName());
							}
						%>
					</logic:notEmpty>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
