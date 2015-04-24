<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<%@ page import="gov.dnt.tame.util.DateUtil" %>
<html:hidden name='Aima0204MForm' property='issueMainId' />
<table class='table_1' width='100%'>
	<tr>
		<td>公債代號</td>
		<td>
			<bean:write name='Aima0204MForm' property='issueSerial'/>
		</td>
		<td>增額發行日期</td>
		<td>
			<bean:write name='Aima0204MForm' property='DateFormat(issueDate)'/>
		</td>
		<td>增額發行金額</td>
		<td>
			<bean:write name='Aima0204MForm' property='BigDecimal(issueAmount)' format="#,###"/>
		</td>
	</tr>
	<tr>
		<td colspan='6'>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="實施日期起">
					<bean:define id="issueMainId" name="Aima0204MForm" property="issueMainId" type="java.lang.Integer"/>
					<bean:define id="seqNo" name="row" property="seqNo" type="java.lang.Integer"/>
				<%
					String	myLink	=	"AIMA0223?";
					myLink	+= "issueMainId=" + issueMainId;
					myLink += "&seqNo=" + seqNo;
				%>
				<A href="<%=myLink%>">
					<%
					tw.gov.nta.sql.debt.DebtRateDet tDebtRateDet = (tw.gov.nta.sql.debt.DebtRateDet)row;
					if(tDebtRateDet != null && tDebtRateDet.getEffectiveDate() != null)
						out.print(DateUtil.date2ROCStr(tDebtRateDet.getEffectiveDate(),"yyy/MM/dd"));
					%>
				</A>
				</display:column>
				<display:column title="實施日期迄">
					<%
					tw.gov.nta.sql.debt.DebtRateDet tDebtRateDet = (tw.gov.nta.sql.debt.DebtRateDet)row;
					if(tDebtRateDet != null && tDebtRateDet.getSuspendDate() != null)
						out.print(DateUtil.date2ROCStr(tDebtRateDet.getSuspendDate(),"yyy/MM/dd"));
					%>
				</display:column>
				<display:column title="利率％">
					<bean:write name='row' property='debtRate' format="#,###.000"/>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
