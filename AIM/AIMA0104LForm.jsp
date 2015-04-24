<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<html:hidden name='Aima0104MForm' property='issueMainId' />
<table class='table_1' width='100%'>
	<tr>
		<td>公債代號</td>
		<td>
			<bean:write name='Aima0104MForm' property='issueSerial'/>
		</td>
		<td>發行日期</td>
		<td>
			<bean:write name='Aima0104MForm' property='DateFormat(issueDate)'/>
		</td>
		<td>發行金額</td>
		<td>
			<bean:write name='Aima0104MForm' property='BigDecimal(issueAmount)' format='#,###'/> 元
		</td>
	</tr>
	<tr>
		<td colspan='6'>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="實施日期起">
					<bean:define id="issueMainId" name="Aima0104MForm" property="issueMainId" type="java.lang.Integer"/>
					<bean:define id="seqNo" name="row" property="seqNo" type="java.lang.Integer"/>
				<%
					String	myLink	=	"AIMA0123?";
					myLink	+= "issueMainId=" + issueMainId;
					myLink += "&seqNo=" + seqNo;
				%>
				<A href="<%=myLink%>">
					<%
					tw.gov.nta.sql.debt.DebtRateDet tDebtRateDet = (tw.gov.nta.sql.debt.DebtRateDet)row;
					if(tDebtRateDet != null && tDebtRateDet.getEffectiveDate() != null)
						//out.print(new java.util.Date(tDebtRateDet.getEffectiveDate().getTime()).toString().substring(0,10));
						out.print(gov.dnt.tame.util.DateUtil.date2ROCStr(tDebtRateDet.getEffectiveDate(),"yyy/MM/dd"));
					%>
				</A>
				</display:column>
				<display:column title="實施日期迄">
					<%
					tw.gov.nta.sql.debt.DebtRateDet tDebtRateDet = (tw.gov.nta.sql.debt.DebtRateDet)row;
					if(tDebtRateDet != null && tDebtRateDet.getSuspendDate() != null)
						//out.print(new gov.dnt.tame.util.DateUtil.date2ROCStr(new java.util.Date(tDebtRateDet.getSuspendDate().getTime()).toString().substring(0,10)));
						out.print(gov.dnt.tame.util.DateUtil.date2ROCStr(tDebtRateDet.getSuspendDate(),"yyy/MM/dd"));
					%>
				</display:column>
				<display:column title="利率％">
					<bean:write name='row' property='debtRate' format='0.000'/>%
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
