<!-- DIMA0201LForm.jsp
程式目的：DIMA02
程式代號：DIMA03
程式日期：0950224
程式作者：Andrew Sung
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
			<display:table class="table_list" name="Dima0201Form.debtMains" id="row">
				<display:column title="銀行代碼">
						<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
						<bean:define id="qryAccountYear" name="Dima0201Form" property="qryAccountYear" type="java.lang.String"/>
						<bean:define id="qrySerialNo" name="Dima0201Form" property="qrySerialNo" type="java.lang.String"/>
						<bean:define id="qryId" name="Dima0201Form" property="qryId" type="java.lang.Integer"/>
						<bean:define id="kindId" name="Dima0201Form" property="id" type="java.lang.Integer"/>
						<bean:define id='bank' name="row" property="bank" type="tw.gov.nta.sql.debt.BankRef"/>
						<bean:define id='bankId' name='bank' property='id'/>
						<%			
									String myLink = "DIMA0214?";
									myLink += "&id="+id;
									myLink += "&qryAccountYear="+qryAccountYear;
									myLink += "&qrySerialNo="+qrySerialNo;
									myLink += "&qryId="+qryId;
									myLink += "&kindId="+kindId;
									myLink += "&bankId="+bankId;
									BigDecimal a = new BigDecimal("12313.1231");
									a.setScale(0,5);
						%>   
						<A href='<%=myLink%>'>
							<bean:define id='bank' name="row" property="bank" type="tw.gov.nta.sql.debt.BankRef"/>
							<bean:write name='bank' property='bankCode'/>
						</A>
				</display:column>
				<display:column title="銀行名稱">
						<bean:write name='bank' property='bankName'/>
				</display:column>
				<display:column title="比價金額">
						<p align="right"><bean:write name='row' property='compareAmount' format='#,##0'/></p>
				</display:column>
				<display:column title="利率％">
					<p id='compareRate[<%=row_rowNum%>]'><bean:write name='row' property='compareRate' format='##0.000'/></p>
					<html:hidden name='row' property='compareRate'/>
				</display:column>
				<display:column title="得標否">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<bean:define id="accrue" name="row" property="accrue" type="java.lang.String"/>
					<p align="center"><input type="checkbox" name="debtMain[<%=row_rowNum%>].accrue" <%="Y".equals(accrue)?"checked":""%>></p>
					<input type="hidden" name="debtMain[<%=row_rowNum%>].id" value="<%=id%>">
				</display:column>
				<display:column title="得標金額">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<input type="hidden" name="debtMain[<%=row_rowNum%>].id" value="<%=id%>">
					<bean:define id="issueAmount" name="row" property="issueAmount" type="java.math.BigDecimal"/>
					<input type='text' name="debtMain[<%=row_rowNum%>].issueAmount" value='<%= issueAmount%>' onblur="getAmount(<%=row_rowNum%>)"/ >
				</display:column>
				<display:column title="利息">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<bean:define id="originInterestAmount" name="row" property="originInterestAmount" type="java.math.BigDecimal"/>
					<p id='originInterestAmount[<%=row_rowNum%>]'  align="right"><%= new java.text.DecimalFormat("###,###").format(originInterestAmount)%></p>
					<input type="hidden" name="debtMain[<%=row_rowNum%>].id" value="<%=id%>">
					<input type='hidden' name="debtMain[<%=row_rowNum%>].originInterestAmount" value='<%= originInterestAmount%>'/ >
				</display:column>
				<display:column title="本息合計">
					<bean:define id="issueAmount" name="row" property="issueAmount" type="java.math.BigDecimal"/>
					<bean:define id="originInterestAmount" name="row" property="originInterestAmount" type="java.math.BigDecimal"/>		
					<p id='totalAmount[<%=row_rowNum%>]'  align="right"><%= new java.text.DecimalFormat("###,###").format(issueAmount.add(originInterestAmount))%></p>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>

