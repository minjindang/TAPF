<%@ page pageEncoding="Big5" %>
<%@ include file="/common/taglibs.jsp"%>

<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="發行年度">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<bean:define id="qrydebtCode" name="Bima0101Form" property="qrydebtCode" type="java.lang.Integer"/>
					<bean:define id="qrybudgetCode" name="Bima0101Form" property="qrybudgetCode" type="java.lang.Integer"/>
					<bean:define id="qryaccountYear" name="Bima0101Form" property="qryaccountYear" type="java.lang.String"/>
					<bean:define id="qrydebtName" name="Bima0101Form" property="qrydebtName" type="java.lang.Integer"/>
					<%
						String myLink = "BIMA0105?";
						myLink +=  "qrydebtCode=" + qrydebtCode;
						myLink +=  "&qrybudgetCode=" + qrybudgetCode;
						myLink +=  "&qryaccountYear=" + qryaccountYear;
						myLink += "&qrydebtName=" + qrydebtName;
						myLink +=  "&id=" + id ; 
					%>
					<A href="<%=myLink%>">
						<bean:write name='row' property='accountYear'/>
					</A>
				</display:column>
				<display:column title="發行期別">
					<bean:write name='row' property='issueSerial'/>
				</display:column>
				<display:column title="預算別">
					<bean:define id="budgetCode" name="row" property="budgetCode" type="java.lang.Integer"/>
					<%= tw.gov.nta.system.common.BudgetCodeManager.get(budgetCode).getBudgetName()%>
				</display:column>
				<display:column title="債務別">
					<bean:define id="debtCode" name="row" property="debtCode" type="java.lang.Integer"/>
					<%= tw.gov.nta.system.common.DebitCodeManage.get(debtCode).getDebitName()%>
				</display:column>
				<display:column title="國庫券名稱">
					<bean:write name='row' property='debtName'/>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>