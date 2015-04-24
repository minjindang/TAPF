<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>
<html:hidden name='Aima0203MForm' property='issueMainId' />
<table class='table_1' width='100%'>
	<tr>
		<td>公債代號</td>
		<td>
			<bean:write name='Aima0203MForm' property='issueSerial'/>
		</td>
		<td>增額發行日期</td>
		<td>
			<bean:write name='Aima0203MForm' property='DateFormat(issueDate)'/>
		</td>
		<td>增額發行金額</td>
		<td>
			<bean:write name='Aima0203MForm' property='bigDecimal(issueAmount)' format="#,###"/>
		</td>
	</tr>
	<tr>
		<td colspan='6'>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="面額">
					<bean:define id="issueMainId" name="Aima0203MForm" property="issueMainId" type="java.lang.Integer"/>
					<bean:define id="issueTicketId" name="row" property="id" type="java.lang.Integer"/>
				<%
					String	myLink	=	"AIMA0218?";
					myLink	+= "issueMainId=" + issueMainId;
					myLink += "&issueTicketDetId=" + issueTicketId;
				%>
				<p align="right"><A href="<%=myLink%>">
					<bean:write name='row' property='ticketAmount' format="#,###"/>
				</A></p>
				</display:column>
				<display:column title="張數">
					<p align="right"><bean:write name='row' property='ticketCount'/></p>
				</display:column>
				<display:column title="發行額">
					<bean:define id='ticketCount' name='row' property='ticketCount' type='java.lang.Long'/>
					<bean:define id='ticketAmount' name='row' property='ticketAmount' type='java.math.BigDecimal'/>
					<p align="right"><%= new java.text.DecimalFormat("#,###").format(ticketAmount.multiply(new java.math.BigDecimal(ticketCount.toString())))%>
					元</p>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
