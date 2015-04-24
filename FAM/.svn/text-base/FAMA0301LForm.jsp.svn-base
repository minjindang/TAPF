<!--
程式目的：HARA04文字
程式代號：HARA04
程式日期：0950221
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
<table class='table_1' width='100%'>
	<tr>
		<td>
			<display:table class="table_list" name="collection" id="row">
				<display:column title="債務別">
					<bean:define id="id" name="row" property="id" type="java.lang.Integer"/>
					<bean:define id="qryDebitType" name="Fama0301Form" property="qryDebitType" type="java.lang.String"/>
					<bean:define id="qryDebitName" name="Fama0301Form" property="qryDebitName" type="java.lang.String"/>
					<bean:define id="qryBudgetCode" name="Fama0301Form" property="qryBudgetCode" type="java.lang.Integer"/>
					<%			
						String myLink = "FAMA0303?";
						myLink += "id=" + id;
						myLink += "&qryDebitType=" + qryDebitType;
						myLink += "&qryDebitName=" + qryDebitName;
						myLink += "&qryBudgetCode=" + qryBudgetCode;
						myLink += "&qry=Y";
					%>
					
					<A href="<%=myLink%>">
						<bean:write name='row' property='debitType'/>
					</A>
				</display:column>
				<display:column title="債務別名稱">
					<bean:write name='row' property='debitName'/>
				</display:column>
				<display:column title="所屬預算別">
					<bean:define id="budgetCode" name="row" property="budgetCode" type="tw.gov.nta.sql.BudgetRef"/>
					<bean:write name='budgetCode' property='budgetName'/>
				</display:column>
				<display:column title="備註">
					<bean:write name='row' property='remark'/>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
