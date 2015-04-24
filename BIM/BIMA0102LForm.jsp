<!-- BIMA0102LForm.jsp
程式目的：BIMA01
程式代號：BIMA01
程式日期：0950302
程式作者：Eric.Chen
--------------------------------------------------------
修改作者　　修改日期　　　修改目的
--------------------------------------------------------
-->


<%@ page language="java" contentType="text/html;charset=Big5" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/displaytag" prefix="display" %>
<%@ page import="java.math.BigDecimal" %>
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
			
				<display:column title="面額">	
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<bean:define id="issueId" name="Bima0101Form" property="id" type="java.lang.Integer"/>
					<bean:define id="qrydebtCode" name="Bima0101Form" property="qrydebtCode" type="java.lang.Integer"/>
					<bean:define id="qrybudgetCode" name="Bima0101Form" property="qrybudgetCode" type="java.lang.Integer"/>
					<bean:define id="qryaccountYear" name="Bima0101Form" property="qryaccountYear" type="java.lang.String"/>
					<bean:define id="qrydebtName" name="Bima0101Form" property="qrydebtName" type="java.lang.Integer"/> 
					<%			
								String myLink = "BIMA0109?";
								myLink += "&id=" + id ; 
								myLink += "&issueId=" + issueId ; 
								myLink += "&qrydebtCode=" + qrydebtCode;
								myLink += "&qrybudgetCode=" + qrybudgetCode;
								myLink += "&qryaccountYear=" + qryaccountYear;
								myLink += "&qrydebtName=" + qrydebtName;
					%>   
					<A href="<%=myLink%>">
						<bean:write name='row' property='ticketAmount' format='#,####'/>
					</A>
				</display:column>
				<display:column title="張數">
					<bean:write name='row' property='ticketCount' format='#,####'/>
				</display:column>
				<display:column title="合計">
					<bean:define id="ticketAmount" name="row" property="ticketAmount" type="java.math.BigDecimal"/>
					<bean:define id="ticketCount" name="row" property="ticketCount" type="java.lang.Long"/>
					<% 
						out.print(new java.text.DecimalFormat("#,###").format(ticketAmount.multiply(BigDecimal.valueOf(ticketCount.longValue() ))));
					%>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>

