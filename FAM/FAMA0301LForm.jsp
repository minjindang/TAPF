<!--
�{���ت��GHARA04��r
�{���N���GHARA04
�{������G0950221
�{���@�̡GFormBean Generator
--------------------------------------------------------
�ק�@�̡@�@�ק����@�@�@�ק�ت�
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
				<display:column title="�ŰȧO">
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
				<display:column title="�ŰȧO�W��">
					<bean:write name='row' property='debitName'/>
				</display:column>
				<display:column title="���ݹw��O">
					<bean:define id="budgetCode" name="row" property="budgetCode" type="tw.gov.nta.sql.BudgetRef"/>
					<bean:write name='budgetCode' property='budgetName'/>
				</display:column>
				<display:column title="�Ƶ�">
					<bean:write name='row' property='remark'/>
				</display:column>
			</display:table>
		</td>
	</tr>
</table>
