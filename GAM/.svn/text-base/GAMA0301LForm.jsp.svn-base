<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="年度">
					
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<bean:define id="qryAccountYear" name="Gama0301Form" property="qryAccountYear" type="java.lang.String"/>
					<bean:define id="qryBudgetCode" name="Gama0301Form" property="qryBudgetCode" type="java.lang.Integer"/>
					<bean:define id="qryDebtCode" name="Gama0301Form" property="qryDebtCode" type="java.lang.Integer"/>
					<bean:define id="qryDebtType" name="Gama0301Form" property="qryDebtType" type="java.lang.String"/>
					<bean:define id="qryBoundCode" name="Gama0301Form" property="qryBoundCode" type="java.lang.String"/>
					<bean:define id="qryAccountKind" name="Gama0301Form" property="qryAccountKind" type="java.lang.String"/>
						

					<%			
						String myLink = "GAMA0304?";
						myLink += "id=" + id;
						myLink += "&qryAccountYear=" + qryAccountYear;
						myLink += "&qryBudgetCode=" + qryBudgetCode;
						myLink += "&qryDebtCode=" + qryDebtCode;
						myLink += "&qryDebtType=" + qryDebtType;
						myLink += "&qryBoundCode=" + qryBoundCode;
						myLink += "&qryAccountKind=" + qryAccountKind;
					%>
					
					<A href="<%=myLink%>">
						<bean:write name='row' property='accountYear'/>
					</A>
					
				</display:column>
				<display:column title="預算別">
					<logic:notEmpty name="row" property="budgetCode">
						<bean:define id="budgetCode" name="row" property="budgetCode" type="java.lang.Integer"/>
						<%
							if(budgetCode != null && budgetCode.intValue() != 0)
								out.println(tw.gov.nta.system.common.BudgetCodeManager.get(budgetCode).getBudgetName());
						%>
					</logic:notEmpty>
				</display:column>
				<display:column title="債務別">
					<logic:notEmpty name="row" property="debtCode">
						<bean:define id="debtCode" name="row" property="debtCode" type="java.lang.Integer"/>
						<%
							if(debtCode != null && debtCode.intValue() != 0)
								out.println(tw.gov.nta.system.common.DebitCodeManage.get(debtCode).getDebitName());
						%>
					</logic:notEmpty>
				</display:column>
				<display:column title="債種">
					<logic:notEmpty name="row" property="debtType">
						<bean:define id="debtType" name="row" property="debtType" type="java.lang.String"/>
						<%=tw.gov.nta.system.common.CodeDetManage.getCodeName("DT",debtType)%>
					</logic:notEmpty>
				</display:column>
				<display:column title="自償否">
					<logic:notEmpty name="row" property="boundCode">
						<bean:define id="boundCode" name="row" property="boundCode" type="java.lang.String"/>
						<%=tw.gov.nta.system.common.CodeDetManage.getCodeName("BT",boundCode)%>
					</logic:notEmpty>
				</display:column>
				<display:column title="是否債限">
					<logic:notEmpty name="row" property="debt">
						<bean:define id="debt" name="row" property="debt" type="java.lang.Boolean"/>
						<%=(debt.booleanValue())?"是":"否"%>
					</logic:notEmpty>
				</display:column>
				<display:column title="金額種類">
					<logic:notEmpty name="row" property="accountKind">
						<bean:define id="accountKind" name="row" property="accountKind" type="java.lang.String"/>
						<%=tw.gov.nta.system.common.CodeDetManage.getCodeName("AK",accountKind)%>
					</logic:notEmpty>
				</display:column>
				<display:column title="借款金額">
					<bean:write name='row' property='issueAmount'/>
				</display:column>
				<display:column title="還款金額">
					<bean:write name='row' property='payAmount'/>
				</display:column>
				<display:column title="未償還金額">
					<bean:write name='row' property='remainAmount'/>
				</display:column>
				<display:column title="利息">
					<bean:write name='row' property='interestAmount'/>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
