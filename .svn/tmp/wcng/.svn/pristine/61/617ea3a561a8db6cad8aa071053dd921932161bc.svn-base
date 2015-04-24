<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td>公債代號</td>
		<td>
			<bean:write name='Aima0103MForm' property='issueSerial'/>
		</td>
		<td>發行日期</td>
		<td>
			<bean:write name='Aima0103MForm' property='DateFormat(issueDate)'/>
		</td>
		<td>發行金額</td>
		<td>
			<bean:write name='Aima0103MForm' property='issueAmount' format='#,###'/> 元
		</td>
	</tr>
	<tr>
		<td colspan='6'>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="面額">
					<bean:define id="issueMainId" name="Aima0103MForm" property="issueMainId" type="java.lang.Integer"/>
					<bean:define id="issueTicketId" name="row" property="id" type="java.lang.Integer"/>
				<%
					String	myLink	=	"AIMA0118?";
					myLink	+= "issueMainId=" + issueMainId;
					myLink += "&issueTicketDetId=" + issueTicketId;
				%>
				<div align="right"><A href="<%=myLink%>">
					<bean:write name='row' property='ticketAmount' format='#,###'/>　元
				</A></div>
				</display:column>
				<display:column title="張數">
					<div align="right"><bean:write name='row' property='ticketCount' format='#,###'/></div>
				</display:column>
				<display:column title="發行額">
					<bean:define id='ticketCount' name='row' property='ticketCount' type='java.lang.Long'/>
					<bean:define id='ticketAmount' name='row' property='ticketAmount' type='java.math.BigDecimal'/>
					<div align="right"><%= new java.text.DecimalFormat("#,###").format(ticketAmount.multiply(new java.math.BigDecimal(ticketCount.toString())))%>
					元</div>
				</display:column>
			</display:table>
		</td>
	</tr>
	<html:hidden name='Aima0103MForm' property='issueMainId' />
</table>
