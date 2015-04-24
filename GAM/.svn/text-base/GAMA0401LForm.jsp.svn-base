<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="年度">
					<logic:notEmpty name="row" property="id">
						<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
	
						<bean:define id="qryYear" name="Gama0401Form" property="qryYear" type="java.lang.String"/>
						<bean:define id="qryDataType" name="Gama0401Form" property="qryDataType" type="java.lang.Integer"/>
						<bean:define id="qryBudgetCode" name="Gama0401Form" property="qryBudgetCode" type="java.lang.Integer"/>
						<bean:define id="qryDebtCode" name="Gama0401Form" property="qryDebtCode" type="java.lang.Integer"/>
						<%
							java.util.Map paramMap = new java.util.HashMap();
								paramMap.put("id",id);
								paramMap.put("qryYear",qryYear);
								paramMap.put("qryBudgetCode",qryBudgetCode);
								paramMap.put("qryDebtCode",qryDebtCode);
								paramMap.put("qryDataType",qryDataType);
							pageContext.setAttribute("paramMap", paramMap);
						%>
						<html:link action='/GAMA0403' name='paramMap'>
							<bean:write name='row' property='accountYear'/>
						</html:link>   	
					</logic:notEmpty>
				</display:column>
				<display:column title="預算別" property="budgetCode" decorator="tw.gov.nta.account.form.BudgetCodeNameDecorator"/>
				<display:column title="債務別" property="debtCode" decorator="tw.gov.nta.account.form.DebtCodeNameDecorator"/>
				<display:column title="預算數總額" property="budgetAmount" decorator="tw.gov.nta.account.form.AmountDecorator"/>
				<display:column title="決算數總額" property="auditAmount" decorator="tw.gov.nta.account.form.AmountDecorator"/>
				<display:column title="實際數總額" property="realAmount" decorator="tw.gov.nta.account.form.AmountDecorator"/>
				<display:column title="保留數總額" property="keepAmount" decorator="tw.gov.nta.account.form.AmountDecorator"/>
				<display:footer>
				  	<tr class="odd">
				  		<td colspan='3'><p align="center">合&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 計</p></td>
				  		<td><%= new java.text.DecimalFormat("#,##0").format(new java.math.BigDecimal(request.getAttribute( "budgetAmount").toString())) %></td>
				  		<td><%= new java.text.DecimalFormat("#,##0").format(new java.math.BigDecimal(request.getAttribute( "auditAmount").toString())) %></td>
				  		<td><%= new java.text.DecimalFormat("#,##0").format(new java.math.BigDecimal(request.getAttribute( "realAmount").toString())) %></td>
				  		<td><%= new java.text.DecimalFormat("#,##0").format(new java.math.BigDecimal(request.getAttribute( "keepAmount").toString())) %></td>
				  	<tr>
				</display:footer>

			</display:table>
		</td>
	</tr>
</table>